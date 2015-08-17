/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.Helpers;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerAccountList")
@Entity
public class AgentAccountList {
    private String AGENT_NO;
    private String AGENT_NAME;
    private String MEMBER_NO;
    private String TITLE;
    private String ALLNAMES;
    private String POST_ADDRESS;
    private String REG_DATE;
    private String TEL_NO;
    
    private String PHYS_ADDRESS;
    private String TOWN;
    private String STREET;
    private String GSM_NO;
    
      private String E_MAIL;
   @Id private String ID_NO;
    private String PIN_NO;

    /**
     * @return the AGENT_NO
     */
    @XmlElement 
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
    @XmlElement 
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
     * @return the MEMBER_NO
     */
    @XmlElement 
    public String getMEMBER_NO() {
        return MEMBER_NO;
    }

    /**
     * @param MEMBER_NO the MEMBER_NO to set
     */

    public void setMEMBER_NO(String MEMBER_NO) {
        this.MEMBER_NO = MEMBER_NO;
    }

    /**
     * @return the TITLE
     */
    @XmlElement 
    public String getTITLE() {
        return TITLE;
    }

    /**
     * @param TITLE the TITLE to set
     */

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    /**
     * @return the ALLNAMES
     */
    @XmlElement 
    public String getALLNAMES() {
        return ALLNAMES;
    }

    /**
     * @param ALLNAMES the ALLNAMES to set
     */
 
    public void setALLNAMES(String ALLNAMES) {
        this.ALLNAMES = ALLNAMES;
    }

    /**
     * @return the POST_ADDRESS
     */
    @XmlElement 
    public String getPOST_ADDRESS() {
        return POST_ADDRESS;
    }

    /**
     * @param POST_ADDRESS the POST_ADDRESS to set
     */
   
    public void setPOST_ADDRESS(String POST_ADDRESS) {
        this.POST_ADDRESS = POST_ADDRESS;
    }

    /**
     * @return the REG_DATE
     */
    @XmlElement 
    public String getREG_DATE() {
        return REG_DATE;
    }

    /**
     * @param REG_DATE the REG_DATE to set
     */

    public void setREG_DATE(String REG_DATE) {
        this.REG_DATE = REG_DATE;
    }

    /**
     * @return the TEL_NO
     */
    @XmlElement 
    public String getTEL_NO() {
        return TEL_NO;
    }

    /**
     * @param TEL_NO the TEL_NO to set
     */
   
    public void setTEL_NO(String TEL_NO) {
        this.TEL_NO = TEL_NO;
    }

    /**
     * @return the PHYS_ADDRESS
     */
    @XmlElement 
    public String getPHYS_ADDRESS() {
        return PHYS_ADDRESS;
    }

    /**
     * @param PHYS_ADDRESS the PHYS_ADDRESS to set
     */
  
    public void setPHYS_ADDRESS(String PHYS_ADDRESS) {
        this.PHYS_ADDRESS = PHYS_ADDRESS;
    }

    /**
     * @return the TOWN
     */
    @XmlElement 
    public String getTOWN() {
        return TOWN;
    }

    /**
     * @param TOWN the TOWN to set
     */
   
    public void setTOWN(String TOWN) {
        this.TOWN = TOWN;
    }

    /**
     * @return the STREET
     */
    @XmlElement 
    public String getSTREET() {
        return STREET;
    }

    /**
     * @param STREET the STREET to set
     */

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    /**
     * @return the GSM_NO
     */
    @XmlElement 
    public String getGSM_NO() {
        return GSM_NO;
    }

    /**
     * @param GSM_NO the GSM_NO to set
     */
  
    public void setGSM_NO(String GSM_NO) {
        this.GSM_NO = GSM_NO;
    }

    /**
     * @return the E_MAIL
     */
    @XmlElement 
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
     * @return the ID_NO
     */
    @XmlElement 
    public String getID_NO() {
        return ID_NO;
    }

    /**
     * @param ID_NO the ID_NO to set
     */
  
    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO;
    }

    /**
     * @return the PIN_NO
     */
    @XmlElement 
    public String getPIN_NO() {
        return PIN_NO;
    }

    /**
     * @param PIN_NO the PIN_NO to set
     */
    
    public void setPIN_NO(String PIN_NO) {
        this.PIN_NO = PIN_NO;
    }
    
    
    
}
