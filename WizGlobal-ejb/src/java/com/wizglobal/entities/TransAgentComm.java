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
@Table(name = "TRANS_AGENT_COMM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransAgentComm.findAll", query = "SELECT t FROM TransAgentComm t"),
    @NamedQuery(name = "TransAgentComm.findByTransNo", query = "SELECT t FROM TransAgentComm t WHERE t.transNo = :transNo"),
    @NamedQuery(name = "TransAgentComm.findByTransId", query = "SELECT t FROM TransAgentComm t WHERE t.transId = :transId"),
    @NamedQuery(name = "TransAgentComm.findByTransType", query = "SELECT t FROM TransAgentComm t WHERE t.transType = :transType"),
    @NamedQuery(name = "TransAgentComm.findByTransDate", query = "SELECT t FROM TransAgentComm t WHERE t.transDate = :transDate"),
    @NamedQuery(name = "TransAgentComm.findByMemberNo", query = "SELECT t FROM TransAgentComm t WHERE t.memberNo = :memberNo"),
    @NamedQuery(name = "TransAgentComm.findByFullName", query = "SELECT t FROM TransAgentComm t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TransAgentComm.findByAccountNo", query = "SELECT t FROM TransAgentComm t WHERE t.accountNo = :accountNo"),
    @NamedQuery(name = "TransAgentComm.findByPortfolio", query = "SELECT t FROM TransAgentComm t WHERE t.portfolio = :portfolio"),
    @NamedQuery(name = "TransAgentComm.findByMop", query = "SELECT t FROM TransAgentComm t WHERE t.mop = :mop"),
    @NamedQuery(name = "TransAgentComm.findByAmount", query = "SELECT t FROM TransAgentComm t WHERE t.amount = :amount"),
    @NamedQuery(name = "TransAgentComm.findByNetamount", query = "SELECT t FROM TransAgentComm t WHERE t.netamount = :netamount"),
    @NamedQuery(name = "TransAgentComm.findByNoofshares", query = "SELECT t FROM TransAgentComm t WHERE t.noofshares = :noofshares"),
    @NamedQuery(name = "TransAgentComm.findByNav", query = "SELECT t FROM TransAgentComm t WHERE t.nav = :nav"),
    @NamedQuery(name = "TransAgentComm.findByAdminFee", query = "SELECT t FROM TransAgentComm t WHERE t.adminFee = :adminFee"),
    @NamedQuery(name = "TransAgentComm.findByPrice", query = "SELECT t FROM TransAgentComm t WHERE t.price = :price"),
    @NamedQuery(name = "TransAgentComm.findBySysdate", query = "SELECT t FROM TransAgentComm t WHERE t.sysdate = :sysdate"),
    @NamedQuery(name = "TransAgentComm.findByDrawerpayee", query = "SELECT t FROM TransAgentComm t WHERE t.drawerpayee = :drawerpayee"),
    @NamedQuery(name = "TransAgentComm.findByDocNo", query = "SELECT t FROM TransAgentComm t WHERE t.docNo = :docNo"),
    @NamedQuery(name = "TransAgentComm.findByBnkcode", query = "SELECT t FROM TransAgentComm t WHERE t.bnkcode = :bnkcode"),
    @NamedQuery(name = "TransAgentComm.findByBankaccdets", query = "SELECT t FROM TransAgentComm t WHERE t.bankaccdets = :bankaccdets"),
    @NamedQuery(name = "TransAgentComm.findByEdited", query = "SELECT t FROM TransAgentComm t WHERE t.edited = :edited"),
    @NamedQuery(name = "TransAgentComm.findByUName", query = "SELECT t FROM TransAgentComm t WHERE t.uName = :uName"),
    @NamedQuery(name = "TransAgentComm.findBySystime", query = "SELECT t FROM TransAgentComm t WHERE t.systime = :systime"),
    @NamedQuery(name = "TransAgentComm.findByRemarks", query = "SELECT t FROM TransAgentComm t WHERE t.remarks = :remarks"),
    @NamedQuery(name = "TransAgentComm.findByWithfee", query = "SELECT t FROM TransAgentComm t WHERE t.withfee = :withfee"),
    @NamedQuery(name = "TransAgentComm.findByReason", query = "SELECT t FROM TransAgentComm t WHERE t.reason = :reason"),
    @NamedQuery(name = "TransAgentComm.findByCompname", query = "SELECT t FROM TransAgentComm t WHERE t.compname = :compname"),
    @NamedQuery(name = "TransAgentComm.findByReconciled", query = "SELECT t FROM TransAgentComm t WHERE t.reconciled = :reconciled"),
    @NamedQuery(name = "TransAgentComm.findByShift", query = "SELECT t FROM TransAgentComm t WHERE t.shift = :shift"),
    @NamedQuery(name = "TransAgentComm.findByRedone", query = "SELECT t FROM TransAgentComm t WHERE t.redone = :redone"),
    @NamedQuery(name = "TransAgentComm.findByDrawername", query = "SELECT t FROM TransAgentComm t WHERE t.drawername = :drawername"),
    @NamedQuery(name = "TransAgentComm.findByDatedrafted", query = "SELECT t FROM TransAgentComm t WHERE t.datedrafted = :datedrafted"),
    @NamedQuery(name = "TransAgentComm.findByAcctno", query = "SELECT t FROM TransAgentComm t WHERE t.acctno = :acctno"),
    @NamedQuery(name = "TransAgentComm.findByDepodate", query = "SELECT t FROM TransAgentComm t WHERE t.depodate = :depodate"),
    @NamedQuery(name = "TransAgentComm.findByRecowithbabk", query = "SELECT t FROM TransAgentComm t WHERE t.recowithbabk = :recowithbabk"),
    @NamedQuery(name = "TransAgentComm.findByComments", query = "SELECT t FROM TransAgentComm t WHERE t.comments = :comments"),
    @NamedQuery(name = "TransAgentComm.findByCurrage", query = "SELECT t FROM TransAgentComm t WHERE t.currage = :currage"),
    @NamedQuery(name = "TransAgentComm.findByInitdepo", query = "SELECT t FROM TransAgentComm t WHERE t.initdepo = :initdepo"),
    @NamedQuery(name = "TransAgentComm.findByTranstype", query = "SELECT t FROM TransAgentComm t WHERE t.transtype = :transtype"),
    @NamedQuery(name = "TransAgentComm.findByDescript", query = "SELECT t FROM TransAgentComm t WHERE t.descript = :descript"),
    @NamedQuery(name = "TransAgentComm.findByTMode", query = "SELECT t FROM TransAgentComm t WHERE t.tMode = :tMode"),
    @NamedQuery(name = "TransAgentComm.findByAmtvalue", query = "SELECT t FROM TransAgentComm t WHERE t.amtvalue = :amtvalue"),
    @NamedQuery(name = "TransAgentComm.findByPervalue", query = "SELECT t FROM TransAgentComm t WHERE t.pervalue = :pervalue"),
    @NamedQuery(name = "TransAgentComm.findByServertime", query = "SELECT t FROM TransAgentComm t WHERE t.servertime = :servertime"),
    @NamedQuery(name = "TransAgentComm.findByAgentCode", query = "SELECT t FROM TransAgentComm t WHERE t.agentCode = :agentCode"),
    @NamedQuery(name = "TransAgentComm.findByAgentName", query = "SELECT t FROM TransAgentComm t WHERE t.agentName = :agentName"),
    @NamedQuery(name = "TransAgentComm.findByMngmtfee", query = "SELECT t FROM TransAgentComm t WHERE t.mngmtfee = :mngmtfee"),
    @NamedQuery(name = "TransAgentComm.findByTraillingfee", query = "SELECT t FROM TransAgentComm t WHERE t.traillingfee = :traillingfee"),
    @NamedQuery(name = "TransAgentComm.findByAdminfee", query = "SELECT t FROM TransAgentComm t WHERE t.adminfee = :adminfee"),
    @NamedQuery(name = "TransAgentComm.findByUsed", query = "SELECT t FROM TransAgentComm t WHERE t.used = :used"),
    @NamedQuery(name = "TransAgentComm.findByUseddate", query = "SELECT t FROM TransAgentComm t WHERE t.useddate = :useddate"),
    @NamedQuery(name = "TransAgentComm.findByUseduser", query = "SELECT t FROM TransAgentComm t WHERE t.useduser = :useduser"),
    @NamedQuery(name = "TransAgentComm.findByMngmtper", query = "SELECT t FROM TransAgentComm t WHERE t.mngmtper = :mngmtper"),
    @NamedQuery(name = "TransAgentComm.findByMainagentcode", query = "SELECT t FROM TransAgentComm t WHERE t.mainagentcode = :mainagentcode")})
public class TransAgentComm implements Serializable {
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
    @Size(max = 30)
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
    @Column(name = "USED")
    private Integer used;
    @Column(name = "USEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date useddate;
    @Size(max = 50)
    @Column(name = "USEDUSER")
    private String useduser;
    @Column(name = "MNGMTPER")
    private Double mngmtper;
    @Size(max = 10)
    @Column(name = "MAINAGENTCODE")
    private String mainagentcode;

    public TransAgentComm() {
    }

    public TransAgentComm(Integer transId) {
        this.transId = transId;
    }

    public TransAgentComm(Integer transId, String transNo, String transType, Date transDate, String accountNo, String portfolio, String mop, double amount, Date sysdate) {
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

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Date getUseddate() {
        return useddate;
    }

    public void setUseddate(Date useddate) {
        this.useddate = useddate;
    }

    public String getUseduser() {
        return useduser;
    }

    public void setUseduser(String useduser) {
        this.useduser = useduser;
    }

    public Double getMngmtper() {
        return mngmtper;
    }

    public void setMngmtper(Double mngmtper) {
        this.mngmtper = mngmtper;
    }

    public String getMainagentcode() {
        return mainagentcode;
    }

    public void setMainagentcode(String mainagentcode) {
        this.mainagentcode = mainagentcode;
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
        if (!(object instanceof TransAgentComm)) {
            return false;
        }
        TransAgentComm other = (TransAgentComm) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.TransAgentComm[ transId=" + transId + " ]";
    }
    
}
