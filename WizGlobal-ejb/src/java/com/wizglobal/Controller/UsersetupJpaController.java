/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Usersetup;
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
public class UsersetupJpaController implements Serializable {

 EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Usersetup usersetup) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            em.persist(usersetup);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUsersetup(usersetup.getUserId()) != null) {
                throw new PreexistingEntityException("Usersetup " + usersetup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        public int updateStaff(String staffno){
        String querry ="UPDATE USERSETUP SET WEBPASS ='1' where USER_ID=?";
        int k=0;
        try {
           
             em = LocalEntityManagerFactory.createEntityManager();
             em.getTransaction().begin();
            k= em.createNativeQuery(querry)
                 .setParameter(1, staffno)      
                 .executeUpdate();
            
            em.getTransaction().commit();
            
            
           
        } catch (Exception ex){
            ex.printStackTrace();
            k=0;
        }
        
        finally {
            em.close();
            return k;
        }
        
    }

    public void edit(Usersetup usersetup) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager();
            usersetup = em.merge(usersetup);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usersetup.getUserId();
                if (findUsersetup(id) == null) {
                    throw new NonexistentEntityException("The usersetup with id " + id + " no longer exists.");
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
            Usersetup usersetup;
            try {
                usersetup = em.getReference(Usersetup.class, id);
                usersetup.getUserId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usersetup with id " + id + " no longer exists.", enfe);
            }
            em.remove(usersetup);
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

    public List<Usersetup> findUsersetupEntities() {
        return findUsersetupEntities(true, -1, -1);
    }

    public List<Usersetup> findUsersetupEntities(int maxResults, int firstResult) {
        return findUsersetupEntities(false, maxResults, firstResult);
    }

    private List<Usersetup> findUsersetupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usersetup.class));
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

    public Usersetup findUsersetup(String id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            return em.find(Usersetup.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersetupCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usersetup> rt = cq.from(Usersetup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
         
       public List<Usersetup> findUnregisteredStaff() {
        
       String querry = "select * from USERSETUP where ((WEBPASS <> '1') or (WEBPASS is null)) AND CONFIRMED=1 " ;
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Usersetup.class)
                           .getResultList();
             
        } finally {
            em.close();
        }
    }
    
}
