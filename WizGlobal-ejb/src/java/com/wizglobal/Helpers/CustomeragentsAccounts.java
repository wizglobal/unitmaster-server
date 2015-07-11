/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Helpers;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Accounts")
public class CustomeragentsAccounts {
    
   
    
    private String ACCOUNT_NO;
    private String AGENT_NAME;
    private String E_MAIL;
    private String GSM_NO;

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

    /**
     * @return the E_MAIL
     */
    public String getE_MAIL() {
        return E_MAIL;
    }

    /**
     * @param E_MAIL the E_MAIL to set
     */
    public void setE_MAIL(String E_MAIL) {
        this.E_MAIL = E_MAIL;
    }

    /**
     * @return the GSM_NO
     */
    public String getGSM_NO() {
        return GSM_NO;
    }

    /**
     * @param GSM_NO the GSM_NO to set
     */
    public void setGSM_NO(String GSM_NO) {
        this.GSM_NO = GSM_NO;
    }
    
}
