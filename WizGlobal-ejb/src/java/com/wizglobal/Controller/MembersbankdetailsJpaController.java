/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Members;
import com.wizglobal.entities.Membersbankdetails;
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
public class MembersbankdetailsJpaController implements Serializable {

    EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Membersbankdetails membersbankdetails) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            em.persist(membersbankdetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMembersbankdetails(membersbankdetails.getMemberno()) != null) {
                throw new PreexistingEntityException("Membersbankdetails " + membersbankdetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Membersbankdetails membersbankdetails) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            membersbankdetails = em.merge(membersbankdetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = membersbankdetails.getMemberno();
                if (findMembersbankdetails(id) == null) {
                    throw new NonexistentEntityException("The membersbankdetails with id " + id + " no longer exists.");
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
            Membersbankdetails membersbankdetails;
            try {
                membersbankdetails = em.getReference(Membersbankdetails.class, id);
                membersbankdetails.getMemberno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The membersbankdetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(membersbankdetails);
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

    public List<Membersbankdetails> findMembersbankdetailsEntities() {
        return findMembersbankdetailsEntities(true, -1, -1);
    }

    public List<Membersbankdetails> findMembersbankdetailsEntities(int maxResults, int firstResult) {
        return findMembersbankdetailsEntities(false, maxResults, firstResult);
    }

    private List<Membersbankdetails> findMembersbankdetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Membersbankdetails.class));
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

    public Membersbankdetails findMembersbankdetails(String id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            return em.find(Membersbankdetails.class, id);
        } finally {
            em.close();
        }
    }
    
     public List<Membersbankdetails> getmemberBankDetails(String memberNo){
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            
            return em.createNamedQuery("Membersbankdetails.findByMemberno", Membersbankdetails.class)
                    .setParameter("memberno", memberNo)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public int getMembersbankdetailsCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Membersbankdetails> rt = cq.from(Membersbankdetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
