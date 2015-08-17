/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhif
 */
@XmlRootElement
public class Userdetails {
    private String Category;
    private String EMail;
    private String Refno;
    private String Username;
    private String Passwrd;
    private String number;

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the EMail
     */
    public String getEMail() {
        return EMail;
    }

    /**
     * @param EMail the EMail to set
     */
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    /**
     * @return the Refno
     */
    public String getRefno() {
        return Refno;
    }

    /**
     * @param Refno the Refno to set
     */
    public void setRefno(String Refno) {
        this.Refno = Refno;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Passwrd
     */
    public String getPasswrd() {
        return Passwrd;
    }

    /**
     * @param Passwrd the Passwrd to set
     */
    public void setPasswrd(String Passwrd) {
        this.Passwrd = Passwrd;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
