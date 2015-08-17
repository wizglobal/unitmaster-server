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
@Table(name = "I_RATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IRates.findAll", query = "SELECT i FROM IRates i"),
    @NamedQuery(name = "IRates.findByRateId", query = "SELECT i FROM IRates i WHERE i.rateId = :rateId"),
    @NamedQuery(name = "IRates.findByRateDate", query = "SELECT i FROM IRates i WHERE i.rateDate = :rateDate"),
    @NamedQuery(name = "IRates.findByRate", query = "SELECT i FROM IRates i WHERE i.rate = :rate"),
    @NamedQuery(name = "IRates.findBySecurityCode", query = "SELECT i FROM IRates i WHERE i.securityCode = :securityCode"),
    @NamedQuery(name = "IRates.findByRemarks", query = "SELECT i FROM IRates i WHERE i.remarks = :remarks"),
    @NamedQuery(name = "IRates.findByEntrydate", query = "SELECT i FROM IRates i WHERE i.entrydate = :entrydate"),
    @NamedQuery(name = "IRates.findByEntrytime", query = "SELECT i FROM IRates i WHERE i.entrytime = :entrytime"),
    @NamedQuery(name = "IRates.findByStaffname", query = "SELECT i FROM IRates i WHERE i.staffname = :staffname"),
    @NamedQuery(name = "IRates.findByStaffcategory", query = "SELECT i FROM IRates i WHERE i.staffcategory = :staffcategory"),
    @NamedQuery(name = "IRates.findByEdited", query = "SELECT i FROM IRates i WHERE i.edited = :edited"),
    @NamedQuery(name = "IRates.findByEdate", query = "SELECT i FROM IRates i WHERE i.edate = :edate"),
    @NamedQuery(name = "IRates.findByEuser", query = "SELECT i FROM IRates i WHERE i.euser = :euser"),
    @NamedQuery(name = "IRates.findBySecname", query = "SELECT i FROM IRates i WHERE i.secname = :secname"),
    @NamedQuery(name = "IRates.findByConfirmd", query = "SELECT i FROM IRates i WHERE i.confirmd = :confirmd"),
    @NamedQuery(name = "IRates.findByConfyuser", query = "SELECT i FROM IRates i WHERE i.confyuser = :confyuser"),
    @NamedQuery(name = "IRates.findByConfydate", query = "SELECT i FROM IRates i WHERE i.confydate = :confydate"),
    @NamedQuery(name = "IRates.findByConfyremk", query = "SELECT i FROM IRates i WHERE i.confyremk = :confyremk"),
    @NamedQuery(name = "IRates.findByUsed", query = "SELECT i FROM IRates i WHERE i.used = :used"),
    @NamedQuery(name = "IRates.findByRunname", query = "SELECT i FROM IRates i WHERE i.runname = :runname"),
    @NamedQuery(name = "IRates.findByRundate", query = "SELECT i FROM IRates i WHERE i.rundate = :rundate")})
public class IRates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATE_ID")
    private Integer rateId;
    @Column(name = "RATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rateDate;
    @Size(max = 15)
    @Column(name = "RATE")
    private String rate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SECURITY_CODE")
    private String securityCode;
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
    @Size(max = 100)
    @Column(name = "SECNAME")
    private String secname;
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
    @Column(name = "USED")
    private Integer used;
    @Size(max = 30)
    @Column(name = "RUNNAME")
    private String runname;
    @Column(name = "RUNDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rundate;

    public IRates() {
    }

    public IRates(Integer rateId) {
        this.rateId = rateId;
    }

    public IRates(Integer rateId, String securityCode) {
        this.rateId = rateId;
        this.securityCode = securityCode;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
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

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public String getRunname() {
        return runname;
    }

    public void setRunname(String runname) {
        this.runname = runname;
    }

    public Date getRundate() {
        return rundate;
    }

    public void setRundate(Date rundate) {
        this.rundate = rundate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateId != null ? rateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IRates)) {
            return false;
        }
        IRates other = (IRates) object;
        if ((this.rateId == null && other.rateId != null) || (this.rateId != null && !this.rateId.equals(other.rateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.IRates[ rateId=" + rateId + " ]";
    }
    
}
