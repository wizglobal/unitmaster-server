/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhif
 */
@Entity
@Table(name = "MEMBERSBANKDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membersbankdetails.findAll", query = "SELECT m FROM Membersbankdetails m"),
    @NamedQuery(name = "Membersbankdetails.findByMemberno", query = "SELECT m FROM Membersbankdetails m WHERE m.memberno = :memberno"),
    @NamedQuery(name = "Membersbankdetails.findByBankname", query = "SELECT m FROM Membersbankdetails m WHERE m.bankname = :bankname"),
    @NamedQuery(name = "Membersbankdetails.findByBankcode", query = "SELECT m FROM Membersbankdetails m WHERE m.bankcode = :bankcode"),
    @NamedQuery(name = "Membersbankdetails.findByFullnames", query = "SELECT m FROM Membersbankdetails m WHERE m.fullnames = :fullnames"),
    @NamedQuery(name = "Membersbankdetails.findByBranch", query = "SELECT m FROM Membersbankdetails m WHERE m.branch = :branch"),
    @NamedQuery(name = "Membersbankdetails.findByAccountname", query = "SELECT m FROM Membersbankdetails m WHERE m.accountname = :accountname"),
    @NamedQuery(name = "Membersbankdetails.findByAccountno", query = "SELECT m FROM Membersbankdetails m WHERE m.accountno = :accountno"),
    @NamedQuery(name = "Membersbankdetails.findByTown", query = "SELECT m FROM Membersbankdetails m WHERE m.town = :town"),
    @NamedQuery(name = "Membersbankdetails.findByAccounttype", query = "SELECT m FROM Membersbankdetails m WHERE m.accounttype = :accounttype")})
public class Membersbankdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "MEMBERNO")
    private String memberno;
    @Size(max = 70)
    @Column(name = "BANKNAME")
    private String bankname;
    @Size(max = 10)
    @Column(name = "BANKCODE")
    private String bankcode;
    @Size(max = 200)
    @Column(name = "FULLNAMES")
    private String fullnames;
    @Size(max = 20)
    @Column(name = "BRANCH")
    private String branch;
    @Size(max = 200)
    @Column(name = "ACCOUNTNAME")
    private String accountname;
    @Size(max = 20)
    @Column(name = "ACCOUNTNO")
    private String accountno;
    @Size(max = 18)
    @Column(name = "TOWN")
    private String town;
    @Size(max = 15)
    @Column(name = "ACCOUNTTYPE")
    private String accounttype;

    public Membersbankdetails() {
    }

    public Membersbankdetails(String memberno) {
        this.memberno = memberno;
    }

    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberno != null ? memberno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membersbankdetails)) {
            return false;
        }
        Membersbankdetails other = (Membersbankdetails) object;
        if ((this.memberno == null && other.memberno != null) || (this.memberno != null && !this.memberno.equals(other.memberno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Membersbankdetails[ memberno=" + memberno + " ]";
    }
    
}
