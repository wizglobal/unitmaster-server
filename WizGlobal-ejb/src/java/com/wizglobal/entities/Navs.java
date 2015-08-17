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
@Table(name = "NAVS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navs.findAll", query = "SELECT n FROM Navs n"),
    @NamedQuery(name = "Navs.findByNavId", query = "SELECT n FROM Navs n WHERE n.navId = :navId"),
    @NamedQuery(name = "Navs.findByNavDate", query = "SELECT n FROM Navs n WHERE n.navDate = :navDate"),
    @NamedQuery(name = "Navs.findBySecurityCode", query = "SELECT n FROM Navs n WHERE n.securityCode = :securityCode"),
    @NamedQuery(name = "Navs.findByAmount", query = "SELECT n FROM Navs n WHERE n.amount = :amount"),
    @NamedQuery(name = "Navs.findByAdmFee", query = "SELECT n FROM Navs n WHERE n.admFee = :admFee"),
    @NamedQuery(name = "Navs.findByPPrice", query = "SELECT n FROM Navs n WHERE n.pPrice = :pPrice"),
    @NamedQuery(name = "Navs.findByRemarks", query = "SELECT n FROM Navs n WHERE n.remarks = :remarks"),
    @NamedQuery(name = "Navs.findByEntrydate", query = "SELECT n FROM Navs n WHERE n.entrydate = :entrydate"),
    @NamedQuery(name = "Navs.findByEntrytime", query = "SELECT n FROM Navs n WHERE n.entrytime = :entrytime"),
    @NamedQuery(name = "Navs.findByStaffname", query = "SELECT n FROM Navs n WHERE n.staffname = :staffname"),
    @NamedQuery(name = "Navs.findByStaffcategory", query = "SELECT n FROM Navs n WHERE n.staffcategory = :staffcategory"),
    @NamedQuery(name = "Navs.findByEdited", query = "SELECT n FROM Navs n WHERE n.edited = :edited"),
    @NamedQuery(name = "Navs.findByEdate", query = "SELECT n FROM Navs n WHERE n.edate = :edate"),
    @NamedQuery(name = "Navs.findByEuser", query = "SELECT n FROM Navs n WHERE n.euser = :euser"),
    @NamedQuery(name = "Navs.findBySecname", query = "SELECT n FROM Navs n WHERE n.secname = :secname"),
    @NamedQuery(name = "Navs.findByFundcode", query = "SELECT n FROM Navs n WHERE n.fundcode = :fundcode"),
    @NamedQuery(name = "Navs.findByFundname", query = "SELECT n FROM Navs n WHERE n.fundname = :fundname"),
    @NamedQuery(name = "Navs.findByConfirmd", query = "SELECT n FROM Navs n WHERE n.confirmd = :confirmd"),
    @NamedQuery(name = "Navs.findByConfyuser", query = "SELECT n FROM Navs n WHERE n.confyuser = :confyuser"),
    @NamedQuery(name = "Navs.findByConfydate", query = "SELECT n FROM Navs n WHERE n.confydate = :confydate"),
    @NamedQuery(name = "Navs.findByConfyremk", query = "SELECT n FROM Navs n WHERE n.confyremk = :confyremk"),
    @NamedQuery(name = "Navs.findByNavtype", query = "SELECT n FROM Navs n WHERE n.navtype = :navtype"),
    @NamedQuery(name = "Navs.findByAsas", query = "SELECT n FROM Navs n WHERE n.asas = :asas")})
public class Navs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAV_ID")
    private Integer navId;
    @Column(name = "NAV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date navDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SECURITY_CODE")
    private String securityCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "ADM_FEE")
    private Double admFee;
    @Column(name = "P_PRICE")
    private Double pPrice;
    @Size(max = 100)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ENTRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrydate;
    @Column(name = "ENTRYTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrytime;
    @Size(max = 30)
    @Column(name = "STAFFNAME")
    private String staffname;
    @Size(max = 20)
    @Column(name = "STAFFCATEGORY")
    private String staffcategory;
    @Column(name = "EDITED")
    private Integer edited;
    @Column(name = "EDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edate;
    @Size(max = 20)
    @Column(name = "EUSER")
    private String euser;
    @Size(max = 50)
    @Column(name = "SECNAME")
    private String secname;
    @Size(max = 6)
    @Column(name = "FUNDCODE")
    private String fundcode;
    @Size(max = 40)
    @Column(name = "FUNDNAME")
    private String fundname;
    @Column(name = "CONFIRMD")
    private Integer confirmd;
    @Size(max = 30)
    @Column(name = "CONFYUSER")
    private String confyuser;
    @Column(name = "CONFYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confydate;
    @Size(max = 100)
    @Column(name = "CONFYREMK")
    private String confyremk;
    @Column(name = "NAVTYPE")
    private Integer navtype;
    @Size(max = 15)
    @Column(name = "ASAS")
    private String asas;

    public Navs() {
    }

    public Navs(Integer navId) {
        this.navId = navId;
    }

    public Navs(Integer navId, String securityCode) {
        this.navId = navId;
        this.securityCode = securityCode;
    }

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public Date getNavDate() {
        return navDate;
    }

    public void setNavDate(Date navDate) {
        this.navDate = navDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAdmFee() {
        return admFee;
    }

    public void setAdmFee(Double admFee) {
        this.admFee = admFee;
    }

    public Double getPPrice() {
        return pPrice;
    }

    public void setPPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffcategory() {
        return staffcategory;
    }

    public void setStaffcategory(String staffcategory) {
        this.staffcategory = staffcategory;
    }

    public Integer getEdited() {
        return edited;
    }

    public void setEdited(Integer edited) {
        this.edited = edited;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getEuser() {
        return euser;
    }

    public void setEuser(String euser) {
        this.euser = euser;
    }

    public String getSecname() {
        return secname;
    }

    public void setSecname(String secname) {
        this.secname = secname;
    }

    public String getFundcode() {
        return fundcode;
    }

    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    public String getFundname() {
        return fundname;
    }

    public void setFundname(String fundname) {
        this.fundname = fundname;
    }

    public Integer getConfirmd() {
        return confirmd;
    }

    public void setConfirmd(Integer confirmd) {
        this.confirmd = confirmd;
    }

    public String getConfyuser() {
        return confyuser;
    }

    public void setConfyuser(String confyuser) {
        this.confyuser = confyuser;
    }

    public Date getConfydate() {
        return confydate;
    }

    public void setConfydate(Date confydate) {
        this.confydate = confydate;
    }

    public String getConfyremk() {
        return confyremk;
    }

    public void setConfyremk(String confyremk) {
        this.confyremk = confyremk;
    }

    public Integer getNavtype() {
        return navtype;
    }

    public void setNavtype(Integer navtype) {
        this.navtype = navtype;
    }

    public String getAsas() {
        return asas;
    }

    public void setAsas(String asas) {
        this.asas = asas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (navId != null ? navId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Navs)) {
            return false;
        }
        Navs other = (Navs) object;
        if ((this.navId == null && other.navId != null) || (this.navId != null && !this.navId.equals(other.navId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Navs[ navId=" + navId + " ]";
    }
    
}
