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
@Table(catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agents.findAll", query = "SELECT a FROM Agents a"),
    @NamedQuery(name = "Agents.findByAgentNo", query = "SELECT a FROM Agents a WHERE a.agentNo = :agentNo"),
    @NamedQuery(name = "Agents.findByAgentName", query = "SELECT a FROM Agents a WHERE a.agentName = :agentName"),
    @NamedQuery(name = "Agents.findByPostAddress", query = "SELECT a FROM Agents a WHERE a.postAddress = :postAddress"),
    @NamedQuery(name = "Agents.findByTelNo", query = "SELECT a FROM Agents a WHERE a.telNo = :telNo"),
    @NamedQuery(name = "Agents.findByPhysAddress", query = "SELECT a FROM Agents a WHERE a.physAddress = :physAddress"),
    @NamedQuery(name = "Agents.findByEstate", query = "SELECT a FROM Agents a WHERE a.estate = :estate"),
    @NamedQuery(name = "Agents.findByStreet", query = "SELECT a FROM Agents a WHERE a.street = :street"),
    @NamedQuery(name = "Agents.findByLrNo", query = "SELECT a FROM Agents a WHERE a.lrNo = :lrNo"),
    @NamedQuery(name = "Agents.findByRegDate", query = "SELECT a FROM Agents a WHERE a.regDate = :regDate"),
    @NamedQuery(name = "Agents.findByGsmNo", query = "SELECT a FROM Agents a WHERE a.gsmNo = :gsmNo"),
    @NamedQuery(name = "Agents.findByEMail", query = "SELECT a FROM Agents a WHERE a.eMail = :eMail"),
    @NamedQuery(name = "Agents.findByIdNo", query = "SELECT a FROM Agents a WHERE a.idNo = :idNo"),
    @NamedQuery(name = "Agents.findByPinNo", query = "SELECT a FROM Agents a WHERE a.pinNo = :pinNo"),
    @NamedQuery(name = "Agents.findByPer", query = "SELECT a FROM Agents a WHERE a.per = :per"),
    @NamedQuery(name = "Agents.findByBankcode", query = "SELECT a FROM Agents a WHERE a.bankcode = :bankcode"),
    @NamedQuery(name = "Agents.findByBankdesc", query = "SELECT a FROM Agents a WHERE a.bankdesc = :bankdesc"),
    @NamedQuery(name = "Agents.findByBanklocation", query = "SELECT a FROM Agents a WHERE a.banklocation = :banklocation"),
    @NamedQuery(name = "Agents.findByBanktown", query = "SELECT a FROM Agents a WHERE a.banktown = :banktown"),
    @NamedQuery(name = "Agents.findByAccountno", query = "SELECT a FROM Agents a WHERE a.accountno = :accountno"),
    @NamedQuery(name = "Agents.findByConfirmed", query = "SELECT a FROM Agents a WHERE a.confirmed = :confirmed"),
    @NamedQuery(name = "Agents.findByConfirmedby", query = "SELECT a FROM Agents a WHERE a.confirmedby = :confirmedby"),
    @NamedQuery(name = "Agents.findByConfirmeddate", query = "SELECT a FROM Agents a WHERE a.confirmeddate = :confirmeddate"),
    @NamedQuery(name = "Agents.findByBranchid", query = "SELECT a FROM Agents a WHERE a.branchid = :branchid"),
    @NamedQuery(name = "Agents.findByBranchnane", query = "SELECT a FROM Agents a WHERE a.branchnane = :branchnane"),
    @NamedQuery(name = "Agents.findByCatid", query = "SELECT a FROM Agents a WHERE a.catid = :catid"),
    @NamedQuery(name = "Agents.findByCatname", query = "SELECT a FROM Agents a WHERE a.catname = :catname"),
    @NamedQuery(name = "Agents.findByCountry", query = "SELECT a FROM Agents a WHERE a.country = :country"),
    @NamedQuery(name = "Agents.findByTown", query = "SELECT a FROM Agents a WHERE a.town = :town"),
    @NamedQuery(name = "Agents.findByTypeid", query = "SELECT a FROM Agents a WHERE a.typeid = :typeid"),
    @NamedQuery(name = "Agents.findByTypename", query = "SELECT a FROM Agents a WHERE a.typename = :typename"),
    @NamedQuery(name = "Agents.findByContactperson", query = "SELECT a FROM Agents a WHERE a.contactperson = :contactperson"),
    @NamedQuery(name = "Agents.findByBankid", query = "SELECT a FROM Agents a WHERE a.bankid = :bankid"),
    @NamedQuery(name = "Agents.findByWebpass", query = "SELECT a FROM Agents a WHERE a.webpass = :webpass"),
    @NamedQuery(name = "Agents.findByAgentold", query = "SELECT a FROM Agents a WHERE a.agentold = :agentold")})
public class Agents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "AGENT_NO")
    private String agentNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AGENT_NAME")
    private String agentName;
    @Size(max = 100)
    @Column(name = "POST_ADDRESS")
    private String postAddress;
    @Size(max = 20)
    @Column(name = "TEL_NO")
    private String telNo;
    @Size(max = 50)
    @Column(name = "PHYS_ADDRESS")
    private String physAddress;
    @Size(max = 20)
    private String estate;
    @Size(max = 20)
    private String street;
    @Size(max = 30)
    @Column(name = "LR_NO")
    private String lrNo;
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
    @Size(max = 100)
    @Column(name = "ID_NO")
    private String idNo;
    @Size(max = 15)
    @Column(name = "PIN_NO")
    private String pinNo;
    @Lob
    private byte[] signature;
    @Lob
    private byte[] picture;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double per;
    @Size(max = 10)
    private String bankcode;
    @Size(max = 20)
    private String bankdesc;
    @Size(max = 20)
    private String banklocation;
    @Size(max = 15)
    private String banktown;
    @Size(max = 18)
    private String accountno;
    private Integer confirmed;
    @Size(max = 50)
    private String confirmedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmeddate;
    private Integer branchid;
    @Size(max = 80)
    private String branchnane;
    private Integer catid;
    @Size(max = 70)
    private String catname;
    @Size(max = 20)
    private String country;
    @Size(max = 20)
    private String town;
    private Integer typeid;
    @Size(max = 30)
    private String typename;
    @Size(max = 30)
    private String contactperson;
    @Size(max = 5)
    private String bankid;
    private Integer webpass;
    private Integer agentold;

    public Agents() {
    }

    public Agents(String agentNo) {
        this.agentNo = agentNo;
    }

    public Agents(String agentNo, String agentName) {
        this.agentNo = agentNo;
        this.agentName = agentName;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLrNo() {
        return lrNo;
    }

    public void setLrNo(String lrNo) {
        this.lrNo = lrNo;
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

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
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

    public Double getPer() {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankdesc() {
        return bankdesc;
    }

    public void setBankdesc(String bankdesc) {
        this.bankdesc = bankdesc;
    }

    public String getBanklocation() {
        return banklocation;
    }

    public void setBanklocation(String banklocation) {
        this.banklocation = banklocation;
    }

    public String getBanktown() {
        return banktown;
    }

    public void setBanktown(String banktown) {
        this.banktown = banktown;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public String getConfirmedby() {
        return confirmedby;
    }

    public void setConfirmedby(String confirmedby) {
        this.confirmedby = confirmedby;
    }

    public Date getConfirmeddate() {
        return confirmeddate;
    }

    public void setConfirmeddate(Date confirmeddate) {
        this.confirmeddate = confirmeddate;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchnane() {
        return branchnane;
    }

    public void setBranchnane(String branchnane) {
        this.branchnane = branchnane;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public Integer getWebpass() {
        return webpass;
    }

    public void setWebpass(Integer webpass) {
        this.webpass = webpass;
    }

    public Integer getAgentold() {
        return agentold;
    }

    public void setAgentold(Integer agentold) {
        this.agentold = agentold;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentNo != null ? agentNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agents)) {
            return false;
        }
        Agents other = (Agents) object;
        if ((this.agentNo == null && other.agentNo != null) || (this.agentNo != null && !this.agentNo.equals(other.agentNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Agents[ agentNo=" + agentNo + " ]";
    }
    
}
