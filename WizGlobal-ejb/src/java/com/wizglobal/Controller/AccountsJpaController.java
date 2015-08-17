/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Controller;

import com.wizglobal.Helpers.AgentAccountList;
import com.wizglobal.Service.exceptions.NonexistentEntityException;
import com.wizglobal.Service.exceptions.PreexistingEntityException;
import com.wizglobal.Service.exceptions.RollbackFailureException;
import com.wizglobal.entities.Accounts;
import com.wizglobal.Helpers.CustomeragentsAccounts;
import com.wizglobal.listener.LocalEntityManagerFactory;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;


public class AccountsJpaController implements Serializable {


    EntityManager em; 
    @Resource 
    UserTransaction utx; 
  

    public void create(Accounts accounts) throws PreexistingEntityException, RollbackFailureException, Exception {
     
        try {
            
           em = LocalEntityManagerFactory.createEntityManager();   
            utx.begin();

            em.persist(accounts);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAccounts(accounts.getAccountNo()) != null) {
                throw new PreexistingEntityException("Accounts " + accounts + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accounts accounts) throws NonexistentEntityException, RollbackFailureException, Exception {
      
        try {
             em = LocalEntityManagerFactory.createEntityManager(); 
            utx.begin();
            accounts = em.merge(accounts);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = accounts.getAccountNo();
                if (findAccounts(id) == null) {
                    throw new NonexistentEntityException("The accounts with id " + id + " no longer exists.");
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
      
        try {
             em = LocalEntityManagerFactory.createEntityManager(); 
            utx.begin();
            Accounts accounts;
            try {
                accounts = em.getReference(Accounts.class, id);
                accounts.getAccountNo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accounts with id " + id + " no longer exists.", enfe);
            }
            em.remove(accounts);
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

    public List<Accounts> findAccountsEntities() {
        return findAccountsEntities(true, -1, -1);
    }

    public List<Accounts> findAccountsEntities(int maxResults, int firstResult) {
        return findAccountsEntities(false, maxResults, firstResult);
    }

    private List<Accounts> findAccountsEntities(boolean all, int maxResults, int firstResult) {
      try {
       em = LocalEntityManagerFactory.createEntityManager(); 
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accounts.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
      }finally {
            if (em != null) {
                em.close();
            }
        }
       
    }

    public Accounts findAccounts(String id) {
       
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            return em.find(Accounts.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Accounts> findAccountsbyMembernumber(String memberNo) {
       
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            return em.createNamedQuery("Accounts.findByMemberNo", Accounts.class)
                    .setParameter("memberNo", memberNo)
                    .getResultList();
        } finally {
            em.close();
        }
    }
     public List<CustomeragentsAccounts> findCustomerAgents(String memberNo) {
        String querry = "SELECT A.ACCOUNT_NO,G.AGENT_NAME,G.E_MAIL,G.GSM_NO FROM ACCOUNTS A INNER JOIN AGENTS G ON G.AGENT_NO = A.AGENT_NO  where A.MEMBER_NO = ?";
        try {
             em = LocalEntityManagerFactory.createEntityManager();
              return    em.createNativeQuery(querry)
                          .setParameter("1", memberNo)
                           .getResultList();
             
        } finally {
            em.close();
        }
    }
    
        public List findAgentCustomerList(String agentNo) {
        String querry = "SELECT distinct AGENTS.AGENT_NO, AGENTS.AGENT_NAME, MEMBERS.MEMBER_NO,MEMBERS.TITLE,MEMBERS.ALLNAMES,MEMBERS.POST_ADDRESS,MEMBERS.REG_DATE,MEMBERS.TEL_NO,MEMBERS.PHYS_ADDRESS,MEMBERS.TOWN,MEMBERS.STREET,MEMBERS.GSM_NO,MEMBERS.E_MAIL,MEMBERS.ID_NO,MEMBERS.PIN_NO FROM ACCOUNTS INNER JOIN AGENTS  ON AGENTS.AGENT_NO = ACCOUNTS.AGENT_NO INNER JOIN MEMBERS  ON ACCOUNTS.MEMBER_NO = MEMBERS.MEMBER_NO where AGENTS.AGENT_NO=?";
        try {
             em = LocalEntityManagerFactory.createEntityManager();
              return    em.createNativeQuery(querry)
                          .setParameter("1", agentNo).getResultList();
                          
             
        } finally {
            em.close();
        }
    }
     
     
    public int getAccountsCount() {
      
        try {
             em = LocalEntityManagerFactory.createEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accounts> rt = cq.from(Accounts.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
