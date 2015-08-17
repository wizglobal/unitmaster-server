/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.IRates;
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
public class IRatesJpaController implements Serializable {

   EntityManager em; 
    @Resource 
    UserTransaction utx; 
    public void create(IRates IRates) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            em.persist(IRates);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findIRates(IRates.getRateId()) != null) {
                throw new PreexistingEntityException("IRates " + IRates + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IRates IRates) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            IRates = em.merge(IRates);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = IRates.getRateId();
                if (findIRates(id) == null) {
                    throw new NonexistentEntityException("The iRates with id " + id + " no longer exists.");
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
            IRates IRates;
            try {
                IRates = em.getReference(IRates.class, id);
                IRates.getRateId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The IRates with id " + id + " no longer exists.", enfe);
            }
            em.remove(IRates);
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

    public List<IRates> findIRatesEntities() {
        return findIRatesEntities(true, -1, -1);
    }

    public List<IRates> findIRatesEntities(int maxResults, int firstResult) {
        return findIRatesEntities(false, maxResults, firstResult);
    }

    private List<IRates> findIRatesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IRates.class));
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

    public IRates findIRates(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            return em.find(IRates.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<IRates> ListUnconfirmedRates(String username) {
        String querry = "SELECT * FROM I_RATES WHERE I_RATES.CONFIRMD IS NULL AND STAFFNAME !=?";
        try {
             em = LocalEntityManagerFactory.createEntityManager();
              return    em.createNativeQuery(querry,IRates.class)
                          .setParameter("1", username)
                           .getResultList();
             
        } finally {
            em.close();
        }
    }

    public int getIRatesCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IRates> rt = cq.from(IRates.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
