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
import javax.persistence.Lob;
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
@Table(name = "BENEFICIARIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficiaries.findAll", query = "SELECT b FROM Beneficiaries b"),
    @NamedQuery(name = "Beneficiaries.findByTransno", query = "SELECT b FROM Beneficiaries b WHERE b.transno = :transno"),
    @NamedQuery(name = "Beneficiaries.findByFullnames", query = "SELECT b FROM Beneficiaries b WHERE b.fullnames = :fullnames"),
    @NamedQuery(name = "Beneficiaries.findByMemberNo", query = "SELECT b FROM Beneficiaries b WHERE b.memberNo = :memberNo"),
    @NamedQuery(name = "Beneficiaries.findByTitle", query = "SELECT b FROM Beneficiaries b WHERE b.title = :title"),
    @NamedQuery(name = "Beneficiaries.findByFName", query = "SELECT b FROM Beneficiaries b WHERE b.fName = :fName"),
    @NamedQuery(name = "Beneficiaries.findBySurname", query = "SELECT b FROM Beneficiaries b WHERE b.surname = :surname"),
    @NamedQuery(name = "Beneficiaries.findByLastname", query = "SELECT b FROM Beneficiaries b WHERE b.lastname = :lastname"),
    @NamedQuery(name = "Beneficiaries.findByOthernames", query = "SELECT b FROM Beneficiaries b WHERE b.othernames = :othernames"),
    @NamedQuery(name = "Beneficiaries.findByAllnames", query = "SELECT b FROM Beneficiaries b WHERE b.allnames = :allnames"),
    @NamedQuery(name = "Beneficiaries.findByPostAddress", query = "SELECT b FROM Beneficiaries b WHERE b.postAddress = :postAddress"),
    @NamedQuery(name = "Beneficiaries.findByTelNo", query = "SELECT b FROM Beneficiaries b WHERE b.telNo = :telNo"),
    @NamedQuery(name = "Beneficiaries.findByPhysAddress", query = "SELECT b FROM Beneficiaries b WHERE b.physAddress = :physAddress"),
    @NamedQuery(name = "Beneficiaries.findByEstate", query = "SELECT b FROM Beneficiaries b WHERE b.estate = :estate"),
    @NamedQuery(name = "Beneficiaries.findByRegDate", query = "SELECT b FROM Beneficiaries b WHERE b.regDate = :regDate"),
    @NamedQuery(name = "Beneficiaries.findByGsmNo", query = "SELECT b FROM Beneficiaries b WHERE b.gsmNo = :gsmNo"),
    @NamedQuery(name = "Beneficiaries.findByEMail", query = "SELECT b FROM Beneficiaries b WHERE b.eMail = :eMail"),
    @NamedQuery(name = "Beneficiaries.findByIdNo", query = "SELECT b FROM Beneficiaries b WHERE b.idNo = :idNo"),
    @NamedQuery(name = "Beneficiaries.findByRelationship", query = "SELECT b FROM Beneficiaries b WHERE b.relationship = :relationship"),
    @NamedQuery(name = "Beneficiaries.findByPercentage", query = "SELECT b FROM Beneficiaries b WHERE b.percentage = :percentage"),
    @NamedQuery(name = "Beneficiaries.findByDob", query = "SELECT b FROM Beneficiaries b WHERE b.dob = :dob"),
    @NamedQuery(name = "Beneficiaries.findByUname", query = "SELECT b FROM Beneficiaries b WHERE b.uname = :uname"),
    @NamedQuery(name = "Beneficiaries.findByComp", query = "SELECT b FROM Beneficiaries b WHERE b.comp = :comp"),
    @NamedQuery(name = "Beneficiaries.findByEntrydate", query = "SELECT b FROM Beneficiaries b WHERE b.entrydate = :entrydate"),
    @NamedQuery(name = "Beneficiaries.findByGuardianid", query = "SELECT b FROM Beneficiaries b WHERE b.guardianid = :guardianid"),
    @NamedQuery(name = "Beneficiaries.findByGuardianname", query = "SELECT b FROM Beneficiaries b WHERE b.guardianname = :guardianname"),
    @NamedQuery(name = "Beneficiaries.findBySignposition", query = "SELECT b FROM Beneficiaries b WHERE b.signposition = :signposition"),
    @NamedQuery(name = "Beneficiaries.findByCountry", query = "SELECT b FROM Beneficiaries b WHERE b.country = :country"),
    @NamedQuery(name = "Beneficiaries.findByTown", query = "SELECT b FROM Beneficiaries b WHERE b.town = :town"),
    @NamedQuery(name = "Beneficiaries.findByContactperson", query = "SELECT b FROM Beneficiaries b WHERE b.contactperson = :contactperson"),
    @NamedQuery(name = "Beneficiaries.findByVerified", query = "SELECT b FROM Beneficiaries b WHERE b.verified = :verified"),
    @NamedQuery(name = "Beneficiaries.findByVerifydate", query = "SELECT b FROM Beneficiaries b WHERE b.verifydate = :verifydate"),
    @NamedQuery(name = "Beneficiaries.findByVerifyuser", query = "SELECT b FROM Beneficiaries b WHERE b.verifyuser = :verifyuser")})
public class Beneficiaries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSNO")
    private Integer transno;
    @Size(max = 30)
    @Column(name = "FULLNAMES")
    private String fullnames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Size(max = 8)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 20)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 50)
    @Column(name = "OTHERNAMES")
    private String othernames;
    @Size(max = 200)
    @Column(name = "ALLNAMES")
    private String allnames;
    @Size(max = 70)
    @Column(name = "POST_ADDRESS")
    private String postAddress;
    @Size(max = 20)
    @Column(name = "TEL_NO")
    private String telNo;
    @Size(max = 50)
    @Column(name = "PHYS_ADDRESS")
    private String physAddress;
    @Size(max = 40)
    @Column(name = "ESTATE")
    private String estate;
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Size(max = 20)
    @Column(name = "GSM_NO")
    private String gsmNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "E_MAIL")
    private String eMail;
    @Size(max = 12)
    @Column(name = "ID_NO")
    private String idNo;
    @Lob
    @Column(name = "SIGNATURE")
    private byte[] signature;
    @Lob
    @Column(name = "PICTURE")
    private byte[] picture;
    @Size(max = 20)
    @Column(name = "RELATIONSHIP")
    private String relationship;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PERCENTAGE")
    private Double percentage;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Size(max = 20)
    @Column(name = "UNAME")
    private String uname;
    @Size(max = 15)
    @Column(name = "COMP")
    private String comp;
    @Column(name = "ENTRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrydate;
    @Column(name = "GUARDIANID")
    private Integer guardianid;
    @Size(max = 30)
    @Column(name = "GUARDIANNAME")
    private String guardianname;
    @Size(max = 50)
    @Column(name = "SIGNPOSITION")
    private String signposition;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "TOWN")
    @Temporal(TemporalType.TIME)
    private Date town;
    @Column(name = "CONTACTPERSON")
    private Integer contactperson;
    @Column(name = "VERIFIED")
    private Integer verified;
    @Column(name = "VERIFYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verifydate;
    @Size(max = 50)
    @Column(name = "VERIFYUSER")
    private String verifyuser;

    public Beneficiaries() {
    }

    public Beneficiaries(Integer transno) {
        this.transno = transno;
    }

    public Beneficiaries(Integer transno, String memberNo, String fName) {
        this.transno = transno;
        this.memberNo = memberNo;
        this.fName = fName;
    }

    public Integer getTransno() {
        return transno;
    }

    public void setTransno(Integer transno) {
        this.transno = transno;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getAllnames() {
        return allnames;
    }

    public void setAllnames(String allnames) {
        this.allnames = allnames;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getPhysAddress() {
        return physAddress;
    }

    public void setPhysAddress(String physAddress) {
        this.physAddress = physAddress;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(String gsmNo) {
        this.gsmNo = gsmNo;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Integer getGuardianid() {
        return guardianid;
    }

    public void setGuardianid(Integer guardianid) {
        this.guardianid = guardianid;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    public String getSignposition() {
        return signposition;
    }

    public void setSignposition(String signposition) {
        this.signposition = signposition;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getTown() {
        return town;
    }

    public void setTown(Date town) {
        this.town = town;
    }

    public Integer getContactperson() {
        return contactperson;
    }

    public void setContactperson(Integer contactperson) {
        this.contactperson = contactperson;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
    }

    public String getVerifyuser() {
        return verifyuser;
    }

    public void setVerifyuser(String verifyuser) {
        this.verifyuser = verifyuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transno != null ? transno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiaries)) {
            return false;
        }
        Beneficiaries other = (Beneficiaries) object;
        if ((this.transno == null && other.transno != null) || (this.transno != null && !this.transno.equals(other.transno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Beneficiaries[ transno=" + transno + " ]";
    }
    
}
