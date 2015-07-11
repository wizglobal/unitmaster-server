/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Accounts;
import com.wizglobal.entities.Memberpass;
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
public class MemberpassJpaController implements Serializable {

      EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Memberpass memberpass) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            em.persist(memberpass);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMemberpass(memberpass.getUsername()) != null) {
                throw new PreexistingEntityException("Memberpass " + memberpass + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Memberpass memberpass) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
             em = LocalEntityManagerFactory.createEntityManager();  
            memberpass = em.merge(memberpass);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = memberpass.getUsername();
                if (findMemberpass(id) == null) {
                    throw new NonexistentEntityException("The memberpass with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
             em = LocalEntityManagerFactory.createEntityManager();  
            Memberpass memberpass;
            try {
                memberpass = em.getReference(Memberpass.class, id);
                memberpass.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The memberpass with id " + id + " no longer exists.", enfe);
            }
            em.remove(memberpass);
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

    public List<Memberpass> findMemberpassEntities() {
        return findMemberpassEntities(true, -1, -1);
    }

    public List<Memberpass> findMemberpassEntities(int maxResults, int firstResult) {
        return findMemberpassEntities(false, maxResults, firstResult);
    }

    private List<Memberpass> findMemberpassEntities(boolean all, int maxResults, int firstResult) {
         em = LocalEntityManagerFactory.createEntityManager();  
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Memberpass.class));
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

    public Memberpass findMemberpass(String id) {
        EntityManager  em = LocalEntityManagerFactory.createEntityManager();  
        try {
            return em.find(Memberpass.class, id);
        } finally {
            em.close();
        }
    }
    
     public Memberpass findMemberDetails(String username) {
       
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            return em.createNamedQuery("Memberpass.findByUsername", Memberpass.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
    

    public int getMemberpassCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Memberpass> rt = cq.from(Memberpass.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
