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


@Entity
@Table(catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountNo", query = "SELECT a FROM Accounts a WHERE a.accountNo = :accountNo"),
    @NamedQuery(name = "Accounts.findByAgentNo", query = "SELECT a FROM Accounts a WHERE a.agentNo = :agentNo"),
    @NamedQuery(name = "Accounts.findBySecurityCode", query = "SELECT a FROM Accounts a WHERE a.securityCode = :securityCode"),
    @NamedQuery(name = "Accounts.findByCatname", query = "SELECT a FROM Accounts a WHERE a.catname = :catname"),
    @NamedQuery(name = "Accounts.findByMemberNo", query = "SELECT a FROM Accounts a WHERE a.memberNo = :memberNo"),
    @NamedQuery(name = "Accounts.findByRegDate", query = "SELECT a FROM Accounts a WHERE a.regDate = :regDate"),
    @NamedQuery(name = "Accounts.findByTransact", query = "SELECT a FROM Accounts a WHERE a.transact = :transact"),
    @NamedQuery(name = "Accounts.findByAcctype", query = "SELECT a FROM Accounts a WHERE a.acctype = :acctype"),
    @NamedQuery(name = "Accounts.findBySuspended", query = "SELECT a FROM Accounts a WHERE a.suspended = :suspended"),
    @NamedQuery(name = "Accounts.findByAmt", query = "SELECT a FROM Accounts a WHERE a.amt = :amt"),
    @NamedQuery(name = "Accounts.findByPercentage", query = "SELECT a FROM Accounts a WHERE a.percentage = :percentage"),
    @NamedQuery(name = "Accounts.findByFmancode", query = "SELECT a FROM Accounts a WHERE a.fmancode = :fmancode"),
    @NamedQuery(name = "Accounts.findByFmanager", query = "SELECT a FROM Accounts a WHERE a.fmanager = :fmanager"),
    @NamedQuery(name = "Accounts.findByMode", query = "SELECT a FROM Accounts a WHERE a.mode = :mode"),
    @NamedQuery(name = "Accounts.findByUname", query = "SELECT a FROM Accounts a WHERE a.uname = :uname"),
    @NamedQuery(name = "Accounts.findByComp", query = "SELECT a FROM Accounts a WHERE a.comp = :comp"),
    @NamedQuery(name = "Accounts.findByClosedate", query = "SELECT a FROM Accounts a WHERE a.closedate = :closedate"),
    @NamedQuery(name = "Accounts.findByReason", query = "SELECT a FROM Accounts a WHERE a.reason = :reason"),
    @NamedQuery(name = "Accounts.findByFrequency", query = "SELECT a FROM Accounts a WHERE a.frequency = :frequency"),
    @NamedQuery(name = "Accounts.findByStartdate", query = "SELECT a FROM Accounts a WHERE a.startdate = :startdate"),
    @NamedQuery(name = "Accounts.findByNextdate", query = "SELECT a FROM Accounts a WHERE a.nextdate = :nextdate"),
    @NamedQuery(name = "Accounts.findByAlerty", query = "SELECT a FROM Accounts a WHERE a.alerty = :alerty"),
    @NamedQuery(name = "Accounts.findByAlertdate", query = "SELECT a FROM Accounts a WHERE a.alertdate = :alertdate"),
    @NamedQuery(name = "Accounts.findByConttype", query = "SELECT a FROM Accounts a WHERE a.conttype = :conttype"),
    @NamedQuery(name = "Accounts.findByReg", query = "SELECT a FROM Accounts a WHERE a.reg = :reg"),
    @NamedQuery(name = "Accounts.findByCredits", query = "SELECT a FROM Accounts a WHERE a.credits = :credits"),
    @NamedQuery(name = "Accounts.findByDebits", query = "SELECT a FROM Accounts a WHERE a.debits = :debits"),
    @NamedQuery(name = "Accounts.findByCreditUnits", query = "SELECT a FROM Accounts a WHERE a.creditUnits = :creditUnits"),
    @NamedQuery(name = "Accounts.findByDebitUnits", query = "SELECT a FROM Accounts a WHERE a.debitUnits = :debitUnits"),
    @NamedQuery(name = "Accounts.findByCurrTotval", query = "SELECT a FROM Accounts a WHERE a.currTotval = :currTotval"),
    @NamedQuery(name = "Accounts.findByCurrTotunits", query = "SELECT a FROM Accounts a WHERE a.currTotunits = :currTotunits"),
    @NamedQuery(name = "Accounts.findByWithdrawdividents", query = "SELECT a FROM Accounts a WHERE a.withdrawdividents = :withdrawdividents"),
    @NamedQuery(name = "Accounts.findByWithdrawinterest", query = "SELECT a FROM Accounts a WHERE a.withdrawinterest = :withdrawinterest"),
    @NamedQuery(name = "Accounts.findByPrivatewealth", query = "SELECT a FROM Accounts a WHERE a.privatewealth = :privatewealth"),
    @NamedQuery(name = "Accounts.findByMaturitydate", query = "SELECT a FROM Accounts a WHERE a.maturitydate = :maturitydate")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "AGENT_NO")
    private String agentNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SECURITY_CODE")
    private String securityCode;
    @Size(max = 20)
    private String catname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    private Integer transact;
    @Size(max = 15)
    private String acctype;
    private Integer suspended;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double amt;
    private Double percentage;
    private Integer fmancode;
    @Size(max = 70)
    private String fmanager;
    private Integer mode;
    @Size(max = 15)
    private String uname;
    @Size(max = 15)
    private String comp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedate;
    @Size(max = 30)
    private String reason;
    private Integer frequency;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextdate;
    private Integer alerty;
    @Temporal(TemporalType.TIMESTAMP)
    private Date alertdate;
    @Size(max = 15)
    private String conttype;
    private Integer reg;
    private Double credits;
    private Double debits;
    @Column(name = "CREDIT_UNITS")
    private Double creditUnits;
    @Column(name = "DEBIT_UNITS")
    private Double debitUnits;
    @Column(name = "CURR_TOTVAL")
    private Double currTotval;
    @Column(name = "CURR_TOTUNITS")
    private Double currTotunits;
    private Integer withdrawdividents;
    private Integer withdrawinterest;
    private Integer privatewealth;
    @Temporal(TemporalType.TIMESTAMP)
    private Date maturitydate;

    public Accounts() {
    }

    public Accounts(String accountNo) {
        this.accountNo = accountNo;
    }

    public Accounts(String accountNo, String agentNo, String securityCode, String memberNo, Date regDate) {
        this.accountNo = accountNo;
        this.agentNo = agentNo;
        this.securityCode = securityCode;
        this.memberNo = memberNo;
        this.regDate = regDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getTransact() {
        return transact;
    }

    public void setTransact(Integer transact) {
        this.transact = transact;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public Integer getSuspended() {
        return suspended;
    }

    public void setSuspended(Integer suspended) {
        this.suspended = suspended;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Integer getFmancode() {
        return fmancode;
    }

    public void setFmancode(Integer fmancode) {
        this.fmancode = fmancode;
    }

    public String getFmanager() {
        return fmanager;
    }

    public void setFmanager(String fmanager) {
        this.fmanager = fmanager;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
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

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getNextdate() {
        return nextdate;
    }

    public void setNextdate(Date nextdate) {
        this.nextdate = nextdate;
    }

    public Integer getAlerty() {
        return alerty;
    }

    public void setAlerty(Integer alerty) {
        this.alerty = alerty;
    }

    public Date getAlertdate() {
        return alertdate;
    }

    public void setAlertdate(Date alertdate) {
        this.alertdate = alertdate;
    }

    public String getConttype() {
        return conttype;
    }

    public void setConttype(String conttype) {
        this.conttype = conttype;
    }

    public Integer getReg() {
        return reg;
    }

    public void setReg(Integer reg) {
        this.reg = reg;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Double getDebits() {
        return debits;
    }

    public void setDebits(Double debits) {
        this.debits = debits;
    }

    public Double getCreditUnits() {
        return creditUnits;
    }

    public void setCreditUnits(Double creditUnits) {
        this.creditUnits = creditUnits;
    }

    public Double getDebitUnits() {
        return debitUnits;
    }

    public void setDebitUnits(Double debitUnits) {
        this.debitUnits = debitUnits;
    }

    public Double getCurrTotval() {
        return currTotval;
    }

    public void setCurrTotval(Double currTotval) {
        this.currTotval = currTotval;
    }

    public Double getCurrTotunits() {
        return currTotunits;
    }

    public void setCurrTotunits(Double currTotunits) {
        this.currTotunits = currTotunits;
    }

    public Integer getWithdrawdividents() {
        return withdrawdividents;
    }

    public void setWithdrawdividents(Integer withdrawdividents) {
        this.withdrawdividents = withdrawdividents;
    }

    public Integer getWithdrawinterest() {
        return withdrawinterest;
    }

    public void setWithdrawinterest(Integer withdrawinterest) {
        this.withdrawinterest = withdrawinterest;
    }

    public Integer getPrivatewealth() {
        return privatewealth;
    }

    public void setPrivatewealth(Integer privatewealth) {
        this.privatewealth = privatewealth;
    }

    public Date getMaturitydate() {
        return maturitydate;
    }

    public void setMaturitydate(Date maturitydate) {
        this.maturitydate = maturitydate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNo != null ? accountNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountNo == null && other.accountNo != null) || (this.accountNo != null && !this.accountNo.equals(other.accountNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Accounts[ accountNo=" + accountNo + " ]";
    }
    
}
