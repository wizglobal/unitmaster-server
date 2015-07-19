/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Beneficiaries;
import com.wizglobal.entities.Feedbacks;
import com.wizglobal.listener.LocalEntityManagerFactory;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author nhif
 */
public class FeedbacksJpaController implements Serializable {

         EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public String create(Feedbacks feedbacks) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        String status="";
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            em.persist(feedbacks);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findFeedbacks(feedbacks.getId()) != null) {
                throw new PreexistingEntityException("Feedbacks " + feedbacks + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return status;
    }

    public void edit(Feedbacks feedbacks) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            feedbacks = em.merge(feedbacks);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = feedbacks.getId();
                if (findFeedbacks(id) == null) {
                    throw new NonexistentEntityException("The feedbacks with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            Feedbacks feedbacks;
            try {
                feedbacks = em.getReference(Feedbacks.class, id);
                feedbacks.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The feedbacks with id " + id + " no longer exists.", enfe);
            }
            em.remove(feedbacks);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Feedbacks> findFeedbacksEntities() {
        return findFeedbacksEntities(true, -1, -1);
    }

    public List<Feedbacks> findFeedbacksEntities(int maxResults, int firstResult) {
        return findFeedbacksEntities(false, maxResults, firstResult);
    }

    private List<Feedbacks> findFeedbacksEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Feedbacks.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Feedbacks > findMemberFeedback(String memberNo,String category) {
        
        
          String querry = "SELECT * FROM FEEDBACKS WHERE MEMBER_NO =? AND CATEGORY =?'";
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Feedbacks .class)
                          .setParameter("1", memberNo)
                          .setParameter("2", category)
                           .getResultList();
             
        } finally {
            em.close();
        }
    } 

    public Feedbacks findFeedbacks(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            return em.find(Feedbacks.class, id);
        } finally {
            em.close();
        }
    }

    public int getFeedbacksCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Feedbacks> rt = cq.from(Feedbacks.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
