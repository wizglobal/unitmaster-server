/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhif
 */
@Entity
@Table(name = "MEMBERPASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memberpass.findAll", query = "SELECT m FROM Memberpass m"),
    @NamedQuery(name = "Memberpass.findByRefno", query = "SELECT m FROM Memberpass m WHERE m.refno = :refno"),
    @NamedQuery(name = "Memberpass.findByEMail", query = "SELECT m FROM Memberpass m WHERE m.eMail = :eMail"),
    @NamedQuery(name = "Memberpass.findByMemberno", query = "SELECT m FROM Memberpass m WHERE m.memberno = :memberno"),
    @NamedQuery(name = "Memberpass.findByUsername", query = "SELECT m FROM Memberpass m WHERE m.username = :username"),
    @NamedQuery(name = "Memberpass.findByCustomerName", query = "SELECT m FROM Memberpass m WHERE m.customerName = :customerName"),
    @NamedQuery(name = "Memberpass.findBySurname", query = "SELECT m FROM Memberpass m WHERE m.surname = :surname"),
    @NamedQuery(name = "Memberpass.findByCategory", query = "SELECT m FROM Memberpass m WHERE m.category = :category"),
    @NamedQuery(name = "Memberpass.findByLastname", query = "SELECT m FROM Memberpass m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "Memberpass.findByGsmNo", query = "SELECT m FROM Memberpass m WHERE m.gsmNo = :gsmNo"),
    @NamedQuery(name = "Memberpass.findByIdNo", query = "SELECT m FROM Memberpass m WHERE m.idNo = :idNo"),
    @NamedQuery(name = "Memberpass.findByPasswrd", query = "SELECT m FROM Memberpass m WHERE m.passwrd = :passwrd"),
    @NamedQuery(name = "Memberpass.findByCode", query = "SELECT m FROM Memberpass m WHERE m.code = :code"),
    @NamedQuery(name = "Memberpass.findByQuestion", query = "SELECT m FROM Memberpass m WHERE m.question = :question"),
    @NamedQuery(name = "Memberpass.findByAns", query = "SELECT m FROM Memberpass m WHERE m.ans = :ans"),
    @NamedQuery(name = "Memberpass.findByActivemem", query = "SELECT m FROM Memberpass m WHERE m.activemem = :activemem"),
    @NamedQuery(name = "Memberpass.findByReplied", query = "SELECT m FROM Memberpass m WHERE m.replied = :replied"),
    @NamedQuery(name = "Memberpass.findByClosedate", query = "SELECT m FROM Memberpass m WHERE m.closedate = :closedate"),
    @NamedQuery(name = "Memberpass.findByOriginal", query = "SELECT m FROM Memberpass m WHERE m.original = :original"),
    @NamedQuery(name = "Memberpass.findByCreateddate", query = "SELECT m FROM Memberpass m WHERE m.createddate = :createddate"),
    @NamedQuery(name = "Memberpass.findByStaff", query = "SELECT m FROM Memberpass m WHERE m.staff = :staff"),
    @NamedQuery(name = "Memberpass.findByAgent", query = "SELECT m FROM Memberpass m WHERE m.agent = :agent"),
    @NamedQuery(name = "Memberpass.findByMember", query = "SELECT m FROM Memberpass m WHERE m.member = :member"),
    @NamedQuery(name = "Memberpass.findByPasswrdm", query = "SELECT m FROM Memberpass m WHERE m.passwrdm = :passwrdm")})
public class Memberpass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "REFNO")
    private String refno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "E_MAIL")
    private String eMail;
    @Size(max = 12)
    @Column(name = "MEMBERNO")
    private String memberno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Size(max = 20)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 15)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 20)
    @Column(name = "GSM_NO")
    private String gsmNo;
    @Size(max = 15)
    @Column(name = "ID_NO")
    private String idNo;
    @Size(max = 50)
    @Column(name = "PASSWRD")
    private String passwrd;
    @Size(max = 20)
    @Column(name = "CODE")
    private String code;
    @Size(max = 50)
    @Column(name = "QUESTION")
    private String question;
    @Size(max = 50)
    @Column(name = "ANS")
    private String ans;
    @Column(name = "ACTIVEMEM")
    private Integer activemem;
    @Column(name = "REPLIED")
    private Integer replied;
    @Column(name = "CLOSEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedate;
    @Size(max = 50)
    @Column(name = "ORIGINAL")
    private String original;
    @Column(name = "CREATEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "STAFF")
    private Integer staff;
    @Column(name = "AGENT")
    private Integer agent;
    @Column(name = "MEMBER")
    private Integer member;
    @Size(max = 10)
    @Column(name = "PASSWRDM")
    private String passwrdm;

    public Memberpass() {
    }

    public Memberpass(String username) {
        this.username = username;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(String gsmNo) {
        this.gsmNo = gsmNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Integer getActivemem() {
        return activemem;
    }

    public void setActivemem(Integer activemem) {
        this.activemem = activemem;
    }

    public Integer getReplied() {
        return replied;
    }

    public void setReplied(Integer replied) {
        this.replied = replied;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public String getPasswrdm() {
        return passwrdm;
    }

    public void setPasswrdm(String passwrdm) {
        this.passwrdm = passwrdm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memberpass)) {
            return false;
        }
        Memberpass other = (Memberpass) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Memberpass[ username=" + username + " ]";
    }
    
}
