/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Service.exceptions.NonexistentEntityException;
import com.wizglobal.Service.exceptions.PreexistingEntityException;
import com.wizglobal.Service.exceptions.RollbackFailureException;
import com.wizglobal.entities.Agents;
import com.wizglobal.listener.LocalEntityManagerFactory;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author nhif
 */
public class AgentsJpaController implements Serializable {

    EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Agents agents) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            em.persist(agents);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAgents(agents.getAgentNo()) != null) {
                throw new PreexistingEntityException("Agents " + agents + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agents agents) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            agents = em.merge(agents);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = agents.getAgentNo();
                if (findAgents(id) == null) {
                    throw new NonexistentEntityException("The agents with id " + id + " no longer exists.");
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
            Agents agents;
            try {
                agents = em.getReference(Agents.class, id);
                agents.getAgentNo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agents with id " + id + " no longer exists.", enfe);
            }
            em.remove(agents);
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

    public List<Agents> findAgentsEntities() {
        return findAgentsEntities(true, -1, -1);
    }

    public List<Agents> findAgentsEntities(int maxResults, int firstResult) {
        return findAgentsEntities(false, maxResults, firstResult);
    }

    private List<Agents> findAgentsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agents.class));
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

    public Agents findAgents(String id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            return em.find(Agents.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgentsCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agents> rt = cq.from(Agents.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public Agents findAgentbyagentnumber(String agentnumber) {
       
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            return em.createNamedQuery("Agents.findByAgentNo", Agents.class)
                    .setParameter("agentNo", agentnumber)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
    
}
