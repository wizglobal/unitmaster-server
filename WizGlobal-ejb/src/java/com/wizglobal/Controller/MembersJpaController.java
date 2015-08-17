/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Controller.exceptions.NonexistentEntityException;
import com.wizglobal.Controller.exceptions.PreexistingEntityException;
import com.wizglobal.Controller.exceptions.RollbackFailureException;
import com.wizglobal.Helpers.customerAccounts;
import com.wizglobal.entities.Members;
import com.wizglobal.listener.LocalEntityManagerFactory;
import java.io.Serializable;
import java.util.List;
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
public class MembersJpaController implements Serializable {

    public MembersJpaController() {
        this.utx = utx;
        this.emf = LocalEntityManagerFactory.createEntityManager();
    }
    private UserTransaction utx = null;
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Members members) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(members);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMembers(members.getMemberNo()) != null) {
                throw new PreexistingEntityException("Members " + members + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Members members) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            members = em.merge(members);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = members.getMemberNo();
                if (findMembers(id) == null) {
                    throw new NonexistentEntityException("The members with id " + id + " no longer exists.");
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
            em = getEntityManager();
            Members members;
            try {
                members = em.getReference(Members.class, id);
                members.getMemberNo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The members with id " + id + " no longer exists.", enfe);
            }
            em.remove(members);
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

    public List<Members> findMembersEntities() {
        return findMembersEntities(true, -1, -1);
    }

    public List<Members> findMembersEntities(int maxResults, int firstResult) {
        return findMembersEntities(false, maxResults, firstResult);
    }

    private List<Members> findMembersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Members.class));
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

    public Members findMembers(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Members.class, id);
        } finally {
            em.close();
        }
    }
    
    public Members memberDetails(String memberNo){
        EntityManager em = getEntityManager();
        try {
            
            return em.createNamedQuery("Members.findByMemberNo", Members.class)
                    .setParameter("memberNo", memberNo)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
    public List<customerAccounts> findCustomerAccounts(String memberNo) {
        
       String querry = "SELECT A.ACCOUNT_NO, S.DESCRIPT, S.SECURITY_CODE, S.FUNDTYPE, G.AGENT_NO, G.AGENT_NAME FROM ACCOUNTS A INNER JOIN AGENTS G ON A.AGENT_NO = G.AGENT_NO INNER JOIN SECURITIES S ON A.SECURITY_CODE = S.SECURITY_CODE where A.MEMBER_NO= ? order by A.ACCOUNT_NO asc ";
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,customerAccounts.class)
                          .setParameter("1", memberNo)
                           .getResultList();
             
        } finally {
            em.close();
        }
    }
   
    
       public List<Members> findUnregisteredCustomers() {
        
       String querry = "select  * from MEMBERS where WEBPASS IS NULL AND CONFIRMED ='1' ORDER BY MEMBER_NO " ;
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Members.class)
                           .getResultList();
             
        } finally {
            em.close();
        }
       }  
        public List<Members> findUnconfirmedMembers(String username) {
        
       String querry = "select * from members where CONFIRMED IS NULL AND UNAME !=? " ;
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Members.class)
                        .setParameter("1", username)
                           .getResultList();
             
        } finally {
            em.close();
        }
        
    }

    public int getMembersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Members> rt = cq.from(Members.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
