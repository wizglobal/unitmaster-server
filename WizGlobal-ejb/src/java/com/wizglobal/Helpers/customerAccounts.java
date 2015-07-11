/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Helpers;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Accounts")
@Entity
public class customerAccounts {
   @Id private String ACCOUNT_NO;
    private String DESCRIPT;
    private String SECURITY_CODE;
    private String FUNDTYPE; 
    private String AGENT_NO;
    private String AGENT_NAME; 

    /**
     * @return the ACCOUNT_NO
     */
    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    /**
     * @param ACCOUNT_NO the ACCOUNT_NO to set
     */
    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    /**
     * @return the DESCRIPTION
     */
    public String getDESCRIPT() {
        return DESCRIPT;
    }

    /**
     * @param DESCRIPTION the DESCRIPTION to set
     */
    public void setDESCRIPT(String DESCRIPT) {
        this.DESCRIPT = DESCRIPT;
    }

    /**
     * @return the SECURITY_CODE
     */
    public String getSECURITY_CODE() {
        return SECURITY_CODE;
    }

    /**
     * @param SECURITY_CODE the SECURITY_CODE to set
     */
    public void setSECURITY_CODE(String SECURITY_CODE) {
        this.SECURITY_CODE = SECURITY_CODE;
    }

    /**
     * @return the FUNDTYPE
     */
    public String getFUNDTYPE() {
        return FUNDTYPE;
    }

    /**
     * @param FUNDTYPE the FUNDTYPE to set
     */
    public void setFUNDTYPE(String FUNDTYPE) {
        this.FUNDTYPE = FUNDTYPE;
    }

    /**
     * @return the AGENT_NO
     */
    public String getAGENT_NO() {
        return AGENT_NO;
    }

    /**
     * @param AGENT_NO the AGENT_NO to set
     */
    public void setAGENT_NO(String AGENT_NO) {
        this.AGENT_NO = AGENT_NO;
    }

    /**
     * @return the AGENT_NAME
     */
    public String getAGENT_NAME() {
        return AGENT_NAME;
    }

    /**
     * @param AGENT_NAME the AGENT_NAME to set
     */
    public void setAGENT_NAME(String AGENT_NAME) {
        this.AGENT_NAME = AGENT_NAME;
    }
}
