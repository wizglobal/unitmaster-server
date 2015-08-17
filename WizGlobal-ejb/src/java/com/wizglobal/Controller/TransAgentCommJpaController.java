/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.TransAgent;
import com.wizglobal.entities.TransAgentComm;
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
public class TransAgentCommJpaController implements Serializable {

      EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(TransAgentComm transAgentComm) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            em.persist(transAgentComm);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTransAgentComm(transAgentComm.getTransId()) != null) {
                throw new PreexistingEntityException("TransAgentComm " + transAgentComm + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TransAgentComm transAgentComm) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            transAgentComm = em.merge(transAgentComm);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transAgentComm.getTransId();
                if (findTransAgentComm(id) == null) {
                    throw new NonexistentEntityException("The transAgentComm with id " + id + " no longer exists.");
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
            TransAgentComm transAgentComm;
            try {
                transAgentComm = em.getReference(TransAgentComm.class, id);
                transAgentComm.getTransId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transAgentComm with id " + id + " no longer exists.", enfe);
            }
            em.remove(transAgentComm);
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

    public List<TransAgentComm> findTransAgentCommEntities() {
        return findTransAgentCommEntities(true, -1, -1);
    }

    public List<TransAgentComm> findTransAgentCommEntities(int maxResults, int firstResult) {
        return findTransAgentCommEntities(false, maxResults, firstResult);
    }

    private List<TransAgentComm> findTransAgentCommEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransAgentComm.class));
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

    public TransAgentComm findTransAgentComm(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            return em.find(TransAgentComm.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransAgentCommCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransAgentComm> rt = cq.from(TransAgentComm.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<TransAgentComm> findAgentDetailedTransactions(String membernumber) {
      String querry = "select TRANS_ID, TRANS_DATE, MEMBER_NO, FULL_NAME, ACCOUNT_NO, PORTFOLIO, AMOUNT, NETAMOUNT, AMTVALUE, PERVALUE from TRANS_AGENT_COMM where MEMBER_NO=?  order by ACCOUNT_NO, TRANS_DATE"; // removed and USED is not nulland USED is not null
         EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
                  return    em.createNativeQuery(querry,TransAgentComm.class)
                          .setParameter("1", membernumber)
                           .getResultList();
        } finally {
            em.close();
        }
    }
    
}
