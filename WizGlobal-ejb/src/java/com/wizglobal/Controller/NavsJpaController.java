/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.entities.Navs;
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
public class NavsJpaController implements Serializable {

      EntityManager em; 
    @Resource 
    UserTransaction utx; 


    public void create(Navs navs) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            em.persist(navs);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findNavs(navs.getNavId()) != null) {
                throw new PreexistingEntityException("Navs " + navs + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Navs navs) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            navs = em.merge(navs);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = navs.getNavId();
                if (findNavs(id) == null) {
                    throw new NonexistentEntityException("The navs with id " + id + " no longer exists.");
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
            Navs navs;
            try {
                navs = em.getReference(Navs.class, id);
                navs.getNavId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The navs with id " + id + " no longer exists.", enfe);
            }
            em.remove(navs);
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

    public List<Navs> findNavsEntities() {
        return findNavsEntities(true, -1, -1);
    }

    public List<Navs> findNavsEntities(int maxResults, int firstResult) {
        return findNavsEntities(false, maxResults, firstResult);
    }

    private List<Navs> findNavsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Navs.class));
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

    public Navs findNavs(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            return em.find(Navs.class, id);
        } finally {
            em.close();
        }
    }

    public int getNavsCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Navs> rt = cq.from(Navs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Navs> findUnconfirmedNav(String username) {
        
       String querry = "select * from navs where CONFIRMD IS NULL AND  STAFFNAME !=? " ;
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Navs.class)
                        .setParameter("1", username)
                           .getResultList();
             
        } finally {
            em.close();
        }
        
    }
    
}
