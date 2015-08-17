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
@Table(name = "USERSETUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersetup.findAll", query = "SELECT u FROM Usersetup u"),
    @NamedQuery(name = "Usersetup.findByUserId", query = "SELECT u FROM Usersetup u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usersetup.findByUsername", query = "SELECT u FROM Usersetup u WHERE u.username = :username"),
    @NamedQuery(name = "Usersetup.findBySurname", query = "SELECT u FROM Usersetup u WHERE u.surname = :surname"),
    @NamedQuery(name = "Usersetup.findByPassy", query = "SELECT u FROM Usersetup u WHERE u.passy = :passy"),
    @NamedQuery(name = "Usersetup.findByUserType", query = "SELECT u FROM Usersetup u WHERE u.userType = :userType"),
    @NamedQuery(name = "Usersetup.findByCompname", query = "SELECT u FROM Usersetup u WHERE u.compname = :compname"),
    @NamedQuery(name = "Usersetup.findByMonn", query = "SELECT u FROM Usersetup u WHERE u.monn = :monn"),
    @NamedQuery(name = "Usersetup.findByTuee", query = "SELECT u FROM Usersetup u WHERE u.tuee = :tuee"),
    @NamedQuery(name = "Usersetup.findByWedd", query = "SELECT u FROM Usersetup u WHERE u.wedd = :wedd"),
    @NamedQuery(name = "Usersetup.findByThurr", query = "SELECT u FROM Usersetup u WHERE u.thurr = :thurr"),
    @NamedQuery(name = "Usersetup.findByFrii", query = "SELECT u FROM Usersetup u WHERE u.frii = :frii"),
    @NamedQuery(name = "Usersetup.findBySatt", query = "SELECT u FROM Usersetup u WHERE u.satt = :satt"),
    @NamedQuery(name = "Usersetup.findBySunn", query = "SELECT u FROM Usersetup u WHERE u.sunn = :sunn"),
    @NamedQuery(name = "Usersetup.findByFdate", query = "SELECT u FROM Usersetup u WHERE u.fdate = :fdate"),
    @NamedQuery(name = "Usersetup.findByLdate", query = "SELECT u FROM Usersetup u WHERE u.ldate = :ldate"),
    @NamedQuery(name = "Usersetup.findByHin", query = "SELECT u FROM Usersetup u WHERE u.hin = :hin"),
    @NamedQuery(name = "Usersetup.findByHout", query = "SELECT u FROM Usersetup u WHERE u.hout = :hout"),
    @NamedQuery(name = "Usersetup.findByRegdate", query = "SELECT u FROM Usersetup u WHERE u.regdate = :regdate"),
    @NamedQuery(name = "Usersetup.findByUname", query = "SELECT u FROM Usersetup u WHERE u.uname = :uname"),
    @NamedQuery(name = "Usersetup.findByWebpass", query = "SELECT u FROM Usersetup u WHERE u.webpass = :webpass"),
    @NamedQuery(name = "Usersetup.findByEmail", query = "SELECT u FROM Usersetup u WHERE u.email = :email"),
    @NamedQuery(name = "Usersetup.findByActivey", query = "SELECT u FROM Usersetup u WHERE u.activey = :activey"),
    @NamedQuery(name = "Usersetup.findByConfirmed", query = "SELECT u FROM Usersetup u WHERE u.confirmed = :confirmed"),
    @NamedQuery(name = "Usersetup.findByConfirmeddate", query = "SELECT u FROM Usersetup u WHERE u.confirmeddate = :confirmeddate"),
    @NamedQuery(name = "Usersetup.findByConfirmedby", query = "SELECT u FROM Usersetup u WHERE u.confirmedby = :confirmedby"),
    @NamedQuery(name = "Usersetup.findByBranchid", query = "SELECT u FROM Usersetup u WHERE u.branchid = :branchid"),
    @NamedQuery(name = "Usersetup.findByBranchname", query = "SELECT u FROM Usersetup u WHERE u.branchname = :branchname"),
    @NamedQuery(name = "Usersetup.findByEmpcode", query = "SELECT u FROM Usersetup u WHERE u.empcode = :empcode"),
    @NamedQuery(name = "Usersetup.findByWebPass", query = "SELECT u FROM Usersetup u WHERE u.webPass = :webPass"),
    @NamedQuery(name = "Usersetup.findByDeleted", query = "SELECT u FROM Usersetup u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "Usersetup.findByDeletedate", query = "SELECT u FROM Usersetup u WHERE u.deletedate = :deletedate"),
    @NamedQuery(name = "Usersetup.findByDeletedby", query = "SELECT u FROM Usersetup u WHERE u.deletedby = :deletedby"),
    @NamedQuery(name = "Usersetup.findByDisabled", query = "SELECT u FROM Usersetup u WHERE u.disabled = :disabled"),
    @NamedQuery(name = "Usersetup.findByDisabledby", query = "SELECT u FROM Usersetup u WHERE u.disabledby = :disabledby"),
    @NamedQuery(name = "Usersetup.findByDisableddate", query = "SELECT u FROM Usersetup u WHERE u.disableddate = :disableddate"),
    @NamedQuery(name = "Usersetup.findByDisabledreason", query = "SELECT u FROM Usersetup u WHERE u.disabledreason = :disabledreason")})
public class Usersetup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 30)
    @Column(name = "PASSY")
    private String passy;
    @Size(max = 20)
    @Column(name = "USER_TYPE")
    private String userType;
    @Size(max = 20)
    @Column(name = "COMPNAME")
    private String compname;
    @Column(name = "MONN")
    private Integer monn;
    @Column(name = "TUEE")
    private Integer tuee;
    @Column(name = "WEDD")
    private Integer wedd;
    @Column(name = "THURR")
    private Integer thurr;
    @Column(name = "FRII")
    private Integer frii;
    @Column(name = "SATT")
    private Integer satt;
    @Column(name = "SUNN")
    private Integer sunn;
    @Column(name = "FDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fdate;
    @Column(name = "LDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ldate;
    @Column(name = "HIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hin;
    @Column(name = "HOUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hout;
    @Column(name = "REGDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;
    @Size(max = 20)
    @Column(name = "UNAME")
    private String uname;
    @Size(max = 20)
    @Column(name = "WEBPASS")
    private String webpass;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ACTIVEY")
    private Integer activey;
    @Column(name = "CONFIRMED")
    private Integer confirmed;
    @Column(name = "CONFIRMEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmeddate;
    @Size(max = 30)
    @Column(name = "CONFIRMEDBY")
    private String confirmedby;
    @Column(name = "BRANCHID")
    private Integer branchid;
    @Size(max = 80)
    @Column(name = "BRANCHNAME")
    private String branchname;
    @Column(name = "EMPCODE")
    private Integer empcode;
    @Size(max = 20)
    @Column(name = "WEB_PASS")
    private String webPass;
    @Column(name = "DELETED")
    private Integer deleted;
    @Column(name = "DELETEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedate;
    @Size(max = 70)
    @Column(name = "DELETEDBY")
    private String deletedby;
    @Column(name = "DISABLED")
    private Integer disabled;
    @Size(max = 70)
    @Column(name = "DISABLEDBY")
    private String disabledby;
    @Column(name = "DISABLEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date disableddate;
    @Size(max = 200)
    @Column(name = "DISABLEDREASON")
    private String disabledreason;

    public Usersetup() {
    }

    public Usersetup(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassy() {
        return passy;
    }

    public void setPassy(String passy) {
        this.passy = passy;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public Integer getMonn() {
        return monn;
    }

    public void setMonn(Integer monn) {
        this.monn = monn;
    }

    public Integer getTuee() {
        return tuee;
    }

    public void setTuee(Integer tuee) {
        this.tuee = tuee;
    }

    public Integer getWedd() {
        return wedd;
    }

    public void setWedd(Integer wedd) {
        this.wedd = wedd;
    }

    public Integer getThurr() {
        return thurr;
    }

    public void setThurr(Integer thurr) {
        this.thurr = thurr;
    }

    public Integer getFrii() {
        return frii;
    }

    public void setFrii(Integer frii) {
        this.frii = frii;
    }

    public Integer getSatt() {
        return satt;
    }

    public void setSatt(Integer satt) {
        this.satt = satt;
    }

    public Integer getSunn() {
        return sunn;
    }

    public void setSunn(Integer sunn) {
        this.sunn = sunn;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public Date getHin() {
        return hin;
    }

    public void setHin(Date hin) {
        this.hin = hin;
    }

    public Date getHout() {
        return hout;
    }

    public void setHout(Date hout) {
        this.hout = hout;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getWebpass() {
        return webpass;
    }

    public void setWebpass(String webpass) {
        this.webpass = webpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getActivey() {
        return activey;
    }

    public void setActivey(Integer activey) {
        this.activey = activey;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Date getConfirmeddate() {
        return confirmeddate;
    }

    public void setConfirmeddate(Date confirmeddate) {
        this.confirmeddate = confirmeddate;
    }

    public String getConfirmedby() {
        return confirmedby;
    }

    public void setConfirmedby(String confirmedby) {
        this.confirmedby = confirmedby;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public Integer getEmpcode() {
        return empcode;
    }

    public void setEmpcode(Integer empcode) {
        this.empcode = empcode;
    }

    public String getWebPass() {
        return webPass;
    }

    public void setWebPass(String webPass) {
        this.webPass = webPass;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedate() {
        return deletedate;
    }

    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public String getDisabledby() {
        return disabledby;
    }

    public void setDisabledby(String disabledby) {
        this.disabledby = disabledby;
    }

    public Date getDisableddate() {
        return disableddate;
    }

    public void setDisableddate(Date disableddate) {
        this.disableddate = disableddate;
    }

    public String getDisabledreason() {
        return disabledreason;
    }

    public void setDisabledreason(String disabledreason) {
        this.disabledreason = disabledreason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usersetup)) {
            return false;
        }
        Usersetup other = (Usersetup) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Usersetup[ userId=" + userId + " ]";
    }
    
}
