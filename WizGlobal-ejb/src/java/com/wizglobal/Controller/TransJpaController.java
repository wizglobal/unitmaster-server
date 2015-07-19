/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Trans;
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
public class TransJpaController implements Serializable {

    EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Trans trans) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            em.persist(trans);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTrans(trans.getTransId()) != null) {
                throw new PreexistingEntityException("Trans " + trans + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trans trans) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            trans = em.merge(trans);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trans.getTransId();
                if (findTrans(id) == null) {
                    throw new NonexistentEntityException("The trans with id " + id + " no longer exists.");
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
            Trans trans;
            try {
                trans = em.getReference(Trans.class, id);
                trans.getTransId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trans with id " + id + " no longer exists.", enfe);
            }
            em.remove(trans);
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

    public List<Trans> findTransEntities() {
        return findTransEntities(true, -1, -1);
    }

    public List<Trans> findTransEntities(int maxResults, int firstResult) {
        return findTransEntities(false, maxResults, firstResult);
    }

    private List<Trans> findTransEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trans.class));
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

    public Trans findTrans(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            return em.find(Trans.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trans> rt = cq.from(Trans.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    } public List<Trans> ListaccountTransactions(String acctNo) {
        String querry = "SELECT * FROM TRANS WHERE ACCOUNT_NO=? AND CONFIRMED IS NOT NULL AND DELETED IS NULL AND REVERSED IS NULL order by TRANS_DATE asc";
        try {
             em = LocalEntityManagerFactory.createEntityManager();
              return    em.createNativeQuery(querry,Trans.class)
                          .setParameter("1", acctNo)
                           .getResultList();
             
        } finally {
            em.close();
        }
    }
    
    
    
    
}
