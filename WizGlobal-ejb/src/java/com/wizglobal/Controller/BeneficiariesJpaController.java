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
import com.wizglobal.entities.Accounts;
import com.wizglobal.entities.Beneficiaries;
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
public class BeneficiariesJpaController implements Serializable {

  
    EntityManager em; 
    @Resource 
    UserTransaction utx; 

    public void create(Beneficiaries beneficiaries) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            em.persist(beneficiaries);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findBeneficiaries(beneficiaries.getTransno()) != null) {
                throw new PreexistingEntityException("Beneficiaries " + beneficiaries + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Beneficiaries beneficiaries) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = LocalEntityManagerFactory.createEntityManager(); 
            beneficiaries = em.merge(beneficiaries);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = beneficiaries.getTransno();
                if (findBeneficiaries(id) == null) {
                    throw new NonexistentEntityException("The beneficiaries with id " + id + " no longer exists.");
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
            Beneficiaries beneficiaries;
            try {
                beneficiaries = em.getReference(Beneficiaries.class, id);
                beneficiaries.getTransno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The beneficiaries with id " + id + " no longer exists.", enfe);
            }
            em.remove(beneficiaries);
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

    public List<Beneficiaries> findBeneficiariesEntities() {
        return findBeneficiariesEntities(true, -1, -1);
    }

    public List<Beneficiaries> findBeneficiariesEntities(int maxResults, int firstResult) {
        return findBeneficiariesEntities(false, maxResults, firstResult);
    }

    private List<Beneficiaries> findBeneficiariesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Beneficiaries.class));
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

    public Beneficiaries findBeneficiaries(Integer id) {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            return em.find(Beneficiaries.class, id);
        } finally {
            em.close();
        }
    }
    
    
    public List<Beneficiaries> findBeneficiariesByMemberNo(String memberNo) {
        
        
          String querry = "SELECT TRANSNO,ALLNAMES,POST_ADDRESS,TEL_NO,PHYS_ADDRESS,GSM_NO,E_MAIL,RELATIONSHIP,PERCENTAGE FROM BENEFICIARIES WHERE MEMBER_NO = ? ORDER BY ALLNAMES ASC";
         EntityManager em = LocalEntityManagerFactory.createEntityManager();
        try {
             
            
              return    em.createNativeQuery(querry,Beneficiaries.class)
                          .setParameter("1", memberNo)
                           .getResultList();
             
        } finally {
            em.close();
        }
       
//        try {
//             em = LocalEntityManagerFactory.createEntityManager();
//            return em.createNamedQuery("Beneficiaries.findByMemberNo", Beneficiaries.class)
//                    .setParameter("memberNo", memberNo)
//                    .getResultList();
//        } finally {
//            em.close();
//        }
    }

    public int getBeneficiariesCount() {
        EntityManager em = LocalEntityManagerFactory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Beneficiaries> rt = cq.from(Beneficiaries.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
