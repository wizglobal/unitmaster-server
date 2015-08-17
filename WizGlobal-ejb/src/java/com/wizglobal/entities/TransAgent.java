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
@Table(name = "TRANS_AGENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransAgent.findAll", query = "SELECT t FROM TransAgent t"),
    @NamedQuery(name = "TransAgent.findByTransNo", query = "SELECT t FROM TransAgent t WHERE t.transNo = :transNo"),
    @NamedQuery(name = "TransAgent.findByTransId", query = "SELECT t FROM TransAgent t WHERE t.transId = :transId"),
    @NamedQuery(name = "TransAgent.findByTransType", query = "SELECT t FROM TransAgent t WHERE t.transType = :transType"),
    @NamedQuery(name = "TransAgent.findByTransDate", query = "SELECT t FROM TransAgent t WHERE t.transDate = :transDate"),
    @NamedQuery(name = "TransAgent.findByMemberNo", query = "SELECT t FROM TransAgent t WHERE t.memberNo = :memberNo"),
    @NamedQuery(name = "TransAgent.findByFullName", query = "SELECT t FROM TransAgent t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TransAgent.findByAccountNo", query = "SELECT t FROM TransAgent t WHERE t.accountNo = :accountNo"),
    @NamedQuery(name = "TransAgent.findByPortfolio", query = "SELECT t FROM TransAgent t WHERE t.portfolio = :portfolio"),
    @NamedQuery(name = "TransAgent.findByMop", query = "SELECT t FROM TransAgent t WHERE t.mop = :mop"),
    @NamedQuery(name = "TransAgent.findByAmount", query = "SELECT t FROM TransAgent t WHERE t.amount = :amount"),
    @NamedQuery(name = "TransAgent.findByNetamount", query = "SELECT t FROM TransAgent t WHERE t.netamount = :netamount"),
    @NamedQuery(name = "TransAgent.findByNoofshares", query = "SELECT t FROM TransAgent t WHERE t.noofshares = :noofshares"),
    @NamedQuery(name = "TransAgent.findByNav", query = "SELECT t FROM TransAgent t WHERE t.nav = :nav"),
    @NamedQuery(name = "TransAgent.findByAdminFee", query = "SELECT t FROM TransAgent t WHERE t.adminFee = :adminFee"),
    @NamedQuery(name = "TransAgent.findByPrice", query = "SELECT t FROM TransAgent t WHERE t.price = :price"),
    @NamedQuery(name = "TransAgent.findBySysdate", query = "SELECT t FROM TransAgent t WHERE t.sysdate = :sysdate"),
    @NamedQuery(name = "TransAgent.findByDrawerpayee", query = "SELECT t FROM TransAgent t WHERE t.drawerpayee = :drawerpayee"),
    @NamedQuery(name = "TransAgent.findByDocNo", query = "SELECT t FROM TransAgent t WHERE t.docNo = :docNo"),
    @NamedQuery(name = "TransAgent.findByBnkcode", query = "SELECT t FROM TransAgent t WHERE t.bnkcode = :bnkcode"),
    @NamedQuery(name = "TransAgent.findByBankaccdets", query = "SELECT t FROM TransAgent t WHERE t.bankaccdets = :bankaccdets"),
    @NamedQuery(name = "TransAgent.findByEdited", query = "SELECT t FROM TransAgent t WHERE t.edited = :edited"),
    @NamedQuery(name = "TransAgent.findByUName", query = "SELECT t FROM TransAgent t WHERE t.uName = :uName"),
    @NamedQuery(name = "TransAgent.findBySystime", query = "SELECT t FROM TransAgent t WHERE t.systime = :systime"),
    @NamedQuery(name = "TransAgent.findByRemarks", query = "SELECT t FROM TransAgent t WHERE t.remarks = :remarks"),
    @NamedQuery(name = "TransAgent.findByWithfee", query = "SELECT t FROM TransAgent t WHERE t.withfee = :withfee"),
    @NamedQuery(name = "TransAgent.findByReason", query = "SELECT t FROM TransAgent t WHERE t.reason = :reason"),
    @NamedQuery(name = "TransAgent.findByCompname", query = "SELECT t FROM TransAgent t WHERE t.compname = :compname"),
    @NamedQuery(name = "TransAgent.findByReconciled", query = "SELECT t FROM TransAgent t WHERE t.reconciled = :reconciled"),
    @NamedQuery(name = "TransAgent.findByShift", query = "SELECT t FROM TransAgent t WHERE t.shift = :shift"),
    @NamedQuery(name = "TransAgent.findByRedone", query = "SELECT t FROM TransAgent t WHERE t.redone = :redone"),
    @NamedQuery(name = "TransAgent.findByDrawername", query = "SELECT t FROM TransAgent t WHERE t.drawername = :drawername"),
    @NamedQuery(name = "TransAgent.findByDatedrafted", query = "SELECT t FROM TransAgent t WHERE t.datedrafted = :datedrafted"),
    @NamedQuery(name = "TransAgent.findByAcctno", query = "SELECT t FROM TransAgent t WHERE t.acctno = :acctno"),
    @NamedQuery(name = "TransAgent.findByDepodate", query = "SELECT t FROM TransAgent t WHERE t.depodate = :depodate"),
    @NamedQuery(name = "TransAgent.findByRecowithbabk", query = "SELECT t FROM TransAgent t WHERE t.recowithbabk = :recowithbabk"),
    @NamedQuery(name = "TransAgent.findByComments", query = "SELECT t FROM TransAgent t WHERE t.comments = :comments"),
    @NamedQuery(name = "TransAgent.findByCurrage", query = "SELECT t FROM TransAgent t WHERE t.currage = :currage"),
    @NamedQuery(name = "TransAgent.findByInitdepo", query = "SELECT t FROM TransAgent t WHERE t.initdepo = :initdepo"),
    @NamedQuery(name = "TransAgent.findByTranstype", query = "SELECT t FROM TransAgent t WHERE t.transtype = :transtype"),
    @NamedQuery(name = "TransAgent.findByDescript", query = "SELECT t FROM TransAgent t WHERE t.descript = :descript"),
    @NamedQuery(name = "TransAgent.findByTMode", query = "SELECT t FROM TransAgent t WHERE t.tMode = :tMode"),
    @NamedQuery(name = "TransAgent.findByAmtvalue", query = "SELECT t FROM TransAgent t WHERE t.amtvalue = :amtvalue"),
    @NamedQuery(name = "TransAgent.findByPervalue", query = "SELECT t FROM TransAgent t WHERE t.pervalue = :pervalue"),
    @NamedQuery(name = "TransAgent.findByServertime", query = "SELECT t FROM TransAgent t WHERE t.servertime = :servertime"),
    @NamedQuery(name = "TransAgent.findByAgentCode", query = "SELECT t FROM TransAgent t WHERE t.agentCode = :agentCode"),
    @NamedQuery(name = "TransAgent.findByAgentName", query = "SELECT t FROM TransAgent t WHERE t.agentName = :agentName"),
    @NamedQuery(name = "TransAgent.findByMngmtfee", query = "SELECT t FROM TransAgent t WHERE t.mngmtfee = :mngmtfee"),
    @NamedQuery(name = "TransAgent.findByTraillingfee", query = "SELECT t FROM TransAgent t WHERE t.traillingfee = :traillingfee"),
    @NamedQuery(name = "TransAgent.findByAdminfee", query = "SELECT t FROM TransAgent t WHERE t.adminfee = :adminfee"),
    @NamedQuery(name = "TransAgent.findByTax", query = "SELECT t FROM TransAgent t WHERE t.tax = :tax"),
    @NamedQuery(name = "TransAgent.findByTaxamt", query = "SELECT t FROM TransAgent t WHERE t.taxamt = :taxamt"),
    @NamedQuery(name = "TransAgent.findByExcempt", query = "SELECT t FROM TransAgent t WHERE t.excempt = :excempt"),
    @NamedQuery(name = "TransAgent.findByWithholdingamt", query = "SELECT t FROM TransAgent t WHERE t.withholdingamt = :withholdingamt"),
    @NamedQuery(name = "TransAgent.findByConfirmed", query = "SELECT t FROM TransAgent t WHERE t.confirmed = :confirmed"),
    @NamedQuery(name = "TransAgent.findByConfirmedby", query = "SELECT t FROM TransAgent t WHERE t.confirmedby = :confirmedby"),
    @NamedQuery(name = "TransAgent.findByConfirmeddate", query = "SELECT t FROM TransAgent t WHERE t.confirmeddate = :confirmeddate")})
public class TransAgent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TRANS_NO")
    private String transNo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_ID")
    private Integer transId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TRANS_TYPE")
    private String transType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Size(max = 9)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Size(max = 50)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PORTFOLIO")
    private String portfolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MOP")
    private String mop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private double amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NETAMOUNT")
    private Double netamount;
    @Size(max = 10)
    @Column(name = "NOOFSHARES")
    private String noofshares;
    @Column(name = "NAV")
    private Double nav;
    @Column(name = "ADMIN_FEE")
    private Double adminFee;
    @Column(name = "PRICE")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysdate;
    @Size(max = 70)
    @Column(name = "DRAWERPAYEE")
    private String drawerpayee;
    @Size(max = 30)
    @Column(name = "DOC_NO")
    private String docNo;
    @Size(max = 6)
    @Column(name = "BNKCODE")
    private String bnkcode;
    @Size(max = 70)
    @Column(name = "BANKACCDETS")
    private String bankaccdets;
    @Column(name = "EDITED")
    private Integer edited;
    @Size(max = 10)
    @Column(name = "U_NAME")
    private String uName;
    @Column(name = "SYSTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systime;
    @Size(max = 70)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "WITHFEE")
    private Double withfee;
    @Size(max = 50)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 20)
    @Column(name = "COMPNAME")
    private String compname;
    @Column(name = "RECONCILED")
    private Integer reconciled;
    @Size(max = 8)
    @Column(name = "SHIFT")
    private String shift;
    @Column(name = "REDONE")
    private Integer redone;
    @Size(max = 30)
    @Column(name = "DRAWERNAME")
    private String drawername;
    @Column(name = "DATEDRAFTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedrafted;
    @Size(max = 15)
    @Column(name = "ACCTNO")
    private String acctno;
    @Column(name = "DEPODATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depodate;
    @Column(name = "RECOWITHBABK")
    private Integer recowithbabk;
    @Size(max = 50)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "CURRAGE")
    private Integer currage;
    @Column(name = "INITDEPO")
    private Double initdepo;
    @Size(max = 10)
    @Column(name = "TRANSTYPE")
    private String transtype;
    @Size(max = 20)
    @Column(name = "DESCRIPT")
    private String descript;
    @Size(max = 15)
    @Column(name = "T_MODE")
    private String tMode;
    @Column(name = "AMTVALUE")
    private Double amtvalue;
    @Column(name = "PERVALUE")
    private Double pervalue;
    @Column(name = "SERVERTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servertime;
    @Size(max = 10)
    @Column(name = "AGENT_CODE")
    private String agentCode;
    @Size(max = 50)
    @Column(name = "AGENT_NAME")
    private String agentName;
    @Column(name = "MNGMTFEE")
    private Double mngmtfee;
    @Column(name = "TRAILLINGFEE")
    private Double traillingfee;
    @Column(name = "ADMINFEE")
    private Double adminfee;
    @Column(name = "TAX")
    private Double tax;
    @Column(name = "TAXAMT")
    private Double taxamt;
    @Column(name = "EXCEMPT")
    private Double excempt;
    @Column(name = "WITHHOLDINGAMT")
    private Double withholdingamt;
    @Column(name = "CONFIRMED")
    private Integer confirmed;
    @Size(max = 30)
    @Column(name = "CONFIRMEDBY")
    private String confirmedby;
    @Column(name = "CONFIRMEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmeddate;

    public TransAgent() {
    }

    public TransAgent(Integer transId) {
        this.transId = transId;
    }

    public TransAgent(Integer transId, String transNo, String transType, Date transDate, String accountNo, String portfolio, String mop, double amount, Date sysdate) {
        this.transId = transId;
        this.transNo = transNo;
        this.transType = transType;
        this.transDate = transDate;
        this.accountNo = accountNo;
        this.portfolio = portfolio;
        this.mop = mop;
        this.amount = amount;
        this.sysdate = sysdate;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Double getNetamount() {
        return netamount;
    }

    public void setNetamount(Double netamount) {
        this.netamount = netamount;
    }

    public String getNoofshares() {
        return noofshares;
    }

    public void setNoofshares(String noofshares) {
        this.noofshares = noofshares;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public Double getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(Double adminFee) {
        this.adminFee = adminFee;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getSysdate() {
        return sysdate;
    }

    public void setSysdate(Date sysdate) {
        this.sysdate = sysdate;
    }

    public String getDrawerpayee() {
        return drawerpayee;
    }

    public void setDrawerpayee(String drawerpayee) {
        this.drawerpayee = drawerpayee;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getBnkcode() {
        return bnkcode;
    }

    public void setBnkcode(String bnkcode) {
        this.bnkcode = bnkcode;
    }

    public String getBankaccdets() {
        return bankaccdets;
    }

    public void setBankaccdets(String bankaccdets) {
        this.bankaccdets = bankaccdets;
    }

    public Integer getEdited() {
        return edited;
    }

    public void setEdited(Integer edited) {
        this.edited = edited;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getWithfee() {
        return withfee;
    }

    public void setWithfee(Double withfee) {
        this.withfee = withfee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public Integer getReconciled() {
        return reconciled;
    }

    public void setReconciled(Integer reconciled) {
        this.reconciled = reconciled;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Integer getRedone() {
        return redone;
    }

    public void setRedone(Integer redone) {
        this.redone = redone;
    }

    public String getDrawername() {
        return drawername;
    }

    public void setDrawername(String drawername) {
        this.drawername = drawername;
    }

    public Date getDatedrafted() {
        return datedrafted;
    }

    public void setDatedrafted(Date datedrafted) {
        this.datedrafted = datedrafted;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public Date getDepodate() {
        return depodate;
    }

    public void setDepodate(Date depodate) {
        this.depodate = depodate;
    }

    public Integer getRecowithbabk() {
        return recowithbabk;
    }

    public void setRecowithbabk(Integer recowithbabk) {
        this.recowithbabk = recowithbabk;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCurrage() {
        return currage;
    }

    public void setCurrage(Integer currage) {
        this.currage = currage;
    }

    public Double getInitdepo() {
        return initdepo;
    }

    public void setInitdepo(Double initdepo) {
        this.initdepo = initdepo;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getTMode() {
        return tMode;
    }

    public void setTMode(String tMode) {
        this.tMode = tMode;
    }

    public Double getAmtvalue() {
        return amtvalue;
    }

    public void setAmtvalue(Double amtvalue) {
        this.amtvalue = amtvalue;
    }

    public Double getPervalue() {
        return pervalue;
    }

    public void setPervalue(Double pervalue) {
        this.pervalue = pervalue;
    }

    public Date getServertime() {
        return servertime;
    }

    public void setServertime(Date servertime) {
        this.servertime = servertime;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Double getMngmtfee() {
        return mngmtfee;
    }

    public void setMngmtfee(Double mngmtfee) {
        this.mngmtfee = mngmtfee;
    }

    public Double getTraillingfee() {
        return traillingfee;
    }

    public void setTraillingfee(Double traillingfee) {
        this.traillingfee = traillingfee;
    }

    public Double getAdminfee() {
        return adminfee;
    }

    public void setAdminfee(Double adminfee) {
        this.adminfee = adminfee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(Double taxamt) {
        this.taxamt = taxamt;
    }

    public Double getExcempt() {
        return excempt;
    }

    public void setExcempt(Double excempt) {
        this.excempt = excempt;
    }

    public Double getWithholdingamt() {
        return withholdingamt;
    }

    public void setWithholdingamt(Double withholdingamt) {
        this.withholdingamt = withholdingamt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransAgent)) {
            return false;
        }
        TransAgent other = (TransAgent) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.TransAgent[ transId=" + transId + " ]";
    }
    
}
