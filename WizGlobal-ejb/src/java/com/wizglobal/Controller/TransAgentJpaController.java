/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Agents;
import com.wizglobal.entities.TransAgent;
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
public class TransAgentJpaController implements Serializable {

     EntityManager em; 
    @Resource 
    UserTransaction utx; 
  

    public void create(TransAgent transAgent) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            em.persist(transAgent);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTransAgent(transAgent.getTransId()) != null) {
                throw new PreexistingEntityException("TransAgent " + transAgent + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TransAgent transAgent) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();  
            transAgent = em.merge(transAgent);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transAgent.getTransId();
                if (findTransAgent(id) == null) {
                    throw new NonexistentEntityException("The transAgent with id " + id + " no longer exists.");
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
            TransAgent transAgent;
            try {
                transAgent = em.getReference(TransAgent.class, id);
                transAgent.getTransId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transAgent with id " + id + " no longer exists.", enfe);
            }
            em.remove(transAgent);
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

    public List<TransAgent> findTransAgentEntities() {
        return findTransAgentEntities(true, -1, -1);
    }

    public List<TransAgent> findTransAgentEntities(int maxResults, int firstResult) {
        return findTransAgentEntities(false, maxResults, firstResult);
    }

    private List<TransAgent> findTransAgentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransAgent.class));
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

    public TransAgent findTransAgent(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            return em.find(TransAgent.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransAgentCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();  
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransAgent> rt = cq.from(TransAgent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
     public List<TransAgent> findAgentTrxnByAgentcode(String agentcode) {
       
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            return em.createNamedQuery("TransAgent.findByAgentCode", TransAgent.class)
                    .setParameter("agentCode", agentcode)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
}
