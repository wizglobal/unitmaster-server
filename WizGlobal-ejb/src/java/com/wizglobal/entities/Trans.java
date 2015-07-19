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
@Table(name = "TRANS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trans.findAll", query = "SELECT t FROM Trans t"),
    @NamedQuery(name = "Trans.findByTransNo", query = "SELECT t FROM Trans t WHERE t.transNo = :transNo"),
    @NamedQuery(name = "Trans.findByTransId", query = "SELECT t FROM Trans t WHERE t.transId = :transId"),
    @NamedQuery(name = "Trans.findByTransType", query = "SELECT t FROM Trans t WHERE t.transType = :transType"),
    @NamedQuery(name = "Trans.findByTransDate", query = "SELECT t FROM Trans t WHERE t.transDate = :transDate"),
    @NamedQuery(name = "Trans.findByMemberNo", query = "SELECT t FROM Trans t WHERE t.memberNo = :memberNo"),
    @NamedQuery(name = "Trans.findByFullName", query = "SELECT t FROM Trans t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "Trans.findByAccountNo", query = "SELECT t FROM Trans t WHERE t.accountNo = :accountNo"),
    @NamedQuery(name = "Trans.findByPortfolio", query = "SELECT t FROM Trans t WHERE t.portfolio = :portfolio"),
    @NamedQuery(name = "Trans.findByMop", query = "SELECT t FROM Trans t WHERE t.mop = :mop"),
    @NamedQuery(name = "Trans.findByAmount", query = "SELECT t FROM Trans t WHERE t.amount = :amount"),
    @NamedQuery(name = "Trans.findByNetamount", query = "SELECT t FROM Trans t WHERE t.netamount = :netamount"),
    @NamedQuery(name = "Trans.findByNoofshares", query = "SELECT t FROM Trans t WHERE t.noofshares = :noofshares"),
    @NamedQuery(name = "Trans.findByNav", query = "SELECT t FROM Trans t WHERE t.nav = :nav"),
    @NamedQuery(name = "Trans.findByAdminFee", query = "SELECT t FROM Trans t WHERE t.adminFee = :adminFee"),
    @NamedQuery(name = "Trans.findByPrice", query = "SELECT t FROM Trans t WHERE t.price = :price"),
    @NamedQuery(name = "Trans.findBySysdate", query = "SELECT t FROM Trans t WHERE t.sysdate = :sysdate"),
    @NamedQuery(name = "Trans.findByDrawerpayee", query = "SELECT t FROM Trans t WHERE t.drawerpayee = :drawerpayee"),
    @NamedQuery(name = "Trans.findByDocNo", query = "SELECT t FROM Trans t WHERE t.docNo = :docNo"),
    @NamedQuery(name = "Trans.findByBnkcode", query = "SELECT t FROM Trans t WHERE t.bnkcode = :bnkcode"),
    @NamedQuery(name = "Trans.findByBankaccdets", query = "SELECT t FROM Trans t WHERE t.bankaccdets = :bankaccdets"),
    @NamedQuery(name = "Trans.findByEdited", query = "SELECT t FROM Trans t WHERE t.edited = :edited"),
    @NamedQuery(name = "Trans.findByUName", query = "SELECT t FROM Trans t WHERE t.uName = :uName"),
    @NamedQuery(name = "Trans.findBySystime", query = "SELECT t FROM Trans t WHERE t.systime = :systime"),
    @NamedQuery(name = "Trans.findByRemarks", query = "SELECT t FROM Trans t WHERE t.remarks = :remarks"),
    @NamedQuery(name = "Trans.findByWithfee", query = "SELECT t FROM Trans t WHERE t.withfee = :withfee"),
    @NamedQuery(name = "Trans.findByReason", query = "SELECT t FROM Trans t WHERE t.reason = :reason"),
    @NamedQuery(name = "Trans.findByCompname", query = "SELECT t FROM Trans t WHERE t.compname = :compname"),
    @NamedQuery(name = "Trans.findByReconciled", query = "SELECT t FROM Trans t WHERE t.reconciled = :reconciled"),
    @NamedQuery(name = "Trans.findByShift", query = "SELECT t FROM Trans t WHERE t.shift = :shift"),
    @NamedQuery(name = "Trans.findByRedone", query = "SELECT t FROM Trans t WHERE t.redone = :redone"),
    @NamedQuery(name = "Trans.findByDrawername", query = "SELECT t FROM Trans t WHERE t.drawername = :drawername"),
    @NamedQuery(name = "Trans.findByDatedrafted", query = "SELECT t FROM Trans t WHERE t.datedrafted = :datedrafted"),
    @NamedQuery(name = "Trans.findByAcctno", query = "SELECT t FROM Trans t WHERE t.acctno = :acctno"),
    @NamedQuery(name = "Trans.findByDepodate", query = "SELECT t FROM Trans t WHERE t.depodate = :depodate"),
    @NamedQuery(name = "Trans.findByRecowithbabk", query = "SELECT t FROM Trans t WHERE t.recowithbabk = :recowithbabk"),
    @NamedQuery(name = "Trans.findByComments", query = "SELECT t FROM Trans t WHERE t.comments = :comments"),
    @NamedQuery(name = "Trans.findByContrtype", query = "SELECT t FROM Trans t WHERE t.contrtype = :contrtype"),
    @NamedQuery(name = "Trans.findByCurrage", query = "SELECT t FROM Trans t WHERE t.currage = :currage"),
    @NamedQuery(name = "Trans.findByInitdepo", query = "SELECT t FROM Trans t WHERE t.initdepo = :initdepo"),
    @NamedQuery(name = "Trans.findByPerval", query = "SELECT t FROM Trans t WHERE t.perval = :perval"),
    @NamedQuery(name = "Trans.findByEmployeramt", query = "SELECT t FROM Trans t WHERE t.employeramt = :employeramt"),
    @NamedQuery(name = "Trans.findByEmployerunits", query = "SELECT t FROM Trans t WHERE t.employerunits = :employerunits"),
    @NamedQuery(name = "Trans.findByEmployeeamt", query = "SELECT t FROM Trans t WHERE t.employeeamt = :employeeamt"),
    @NamedQuery(name = "Trans.findByEmployeeunits", query = "SELECT t FROM Trans t WHERE t.employeeunits = :employeeunits"),
    @NamedQuery(name = "Trans.findByTranstype", query = "SELECT t FROM Trans t WHERE t.transtype = :transtype"),
    @NamedQuery(name = "Trans.findByDescript", query = "SELECT t FROM Trans t WHERE t.descript = :descript"),
    @NamedQuery(name = "Trans.findByTMode", query = "SELECT t FROM Trans t WHERE t.tMode = :tMode"),
    @NamedQuery(name = "Trans.findByEmpregamt", query = "SELECT t FROM Trans t WHERE t.empregamt = :empregamt"),
    @NamedQuery(name = "Trans.findByEmpregunit", query = "SELECT t FROM Trans t WHERE t.empregunit = :empregunit"),
    @NamedQuery(name = "Trans.findByEmpunregamt", query = "SELECT t FROM Trans t WHERE t.empunregamt = :empunregamt"),
    @NamedQuery(name = "Trans.findByEmpunregunit", query = "SELECT t FROM Trans t WHERE t.empunregunit = :empunregunit"),
    @NamedQuery(name = "Trans.findByEmplregamt", query = "SELECT t FROM Trans t WHERE t.emplregamt = :emplregamt"),
    @NamedQuery(name = "Trans.findByEmplregunit", query = "SELECT t FROM Trans t WHERE t.emplregunit = :emplregunit"),
    @NamedQuery(name = "Trans.findByEmplunregamt", query = "SELECT t FROM Trans t WHERE t.emplunregamt = :emplunregamt"),
    @NamedQuery(name = "Trans.findByEmplunregunit", query = "SELECT t FROM Trans t WHERE t.emplunregunit = :emplunregunit"),
    @NamedQuery(name = "Trans.findByTyear", query = "SELECT t FROM Trans t WHERE t.tyear = :tyear"),
    @NamedQuery(name = "Trans.findByTmonth", query = "SELECT t FROM Trans t WHERE t.tmonth = :tmonth"),
    @NamedQuery(name = "Trans.findByIRate", query = "SELECT t FROM Trans t WHERE t.iRate = :iRate"),
    @NamedQuery(name = "Trans.findByConfirmed", query = "SELECT t FROM Trans t WHERE t.confirmed = :confirmed"),
    @NamedQuery(name = "Trans.findByConfirmeddate", query = "SELECT t FROM Trans t WHERE t.confirmeddate = :confirmeddate"),
    @NamedQuery(name = "Trans.findByConfirmedby", query = "SELECT t FROM Trans t WHERE t.confirmedby = :confirmedby"),
    @NamedQuery(name = "Trans.findByValueno", query = "SELECT t FROM Trans t WHERE t.valueno = :valueno"),
    @NamedQuery(name = "Trans.findByDeleted", query = "SELECT t FROM Trans t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "Trans.findByDeletedby", query = "SELECT t FROM Trans t WHERE t.deletedby = :deletedby"),
    @NamedQuery(name = "Trans.findByDeldate", query = "SELECT t FROM Trans t WHERE t.deldate = :deldate"),
    @NamedQuery(name = "Trans.findByReversedby", query = "SELECT t FROM Trans t WHERE t.reversedby = :reversedby"),
    @NamedQuery(name = "Trans.findByReverseddate", query = "SELECT t FROM Trans t WHERE t.reverseddate = :reverseddate"),
    @NamedQuery(name = "Trans.findByTaxamt", query = "SELECT t FROM Trans t WHERE t.taxamt = :taxamt"),
    @NamedQuery(name = "Trans.findByTaxunits", query = "SELECT t FROM Trans t WHERE t.taxunits = :taxunits"),
    @NamedQuery(name = "Trans.findByServertime", query = "SELECT t FROM Trans t WHERE t.servertime = :servertime"),
    @NamedQuery(name = "Trans.findByChequefee", query = "SELECT t FROM Trans t WHERE t.chequefee = :chequefee"),
    @NamedQuery(name = "Trans.findByBouncefee", query = "SELECT t FROM Trans t WHERE t.bouncefee = :bouncefee"),
    @NamedQuery(name = "Trans.findByPaymentscheduled", query = "SELECT t FROM Trans t WHERE t.paymentscheduled = :paymentscheduled"),
    @NamedQuery(name = "Trans.findByPaymentscheduleddate", query = "SELECT t FROM Trans t WHERE t.paymentscheduleddate = :paymentscheduleddate"),
    @NamedQuery(name = "Trans.findByPaymentscheduledby", query = "SELECT t FROM Trans t WHERE t.paymentscheduledby = :paymentscheduledby"),
    @NamedQuery(name = "Trans.findByPaymentscheduledbatch", query = "SELECT t FROM Trans t WHERE t.paymentscheduledbatch = :paymentscheduledbatch"),
    @NamedQuery(name = "Trans.findByReversed", query = "SELECT t FROM Trans t WHERE t.reversed = :reversed"),
    @NamedQuery(name = "Trans.findByRunningunits", query = "SELECT t FROM Trans t WHERE t.runningunits = :runningunits"),
    @NamedQuery(name = "Trans.findByNewdbcolum", query = "SELECT t FROM Trans t WHERE t.newdbcolum = :newdbcolum"),
    @NamedQuery(name = "Trans.findByAdminfee", query = "SELECT t FROM Trans t WHERE t.adminfee = :adminfee"),
    @NamedQuery(name = "Trans.findByCurrency", query = "SELECT t FROM Trans t WHERE t.currency = :currency"),
    @NamedQuery(name = "Trans.findByCurrencyname", query = "SELECT t FROM Trans t WHERE t.currencyname = :currencyname"),
    @NamedQuery(name = "Trans.findByBasecurrency", query = "SELECT t FROM Trans t WHERE t.basecurrency = :basecurrency")})
public class Trans implements Serializable {
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
    @Size(max = 200)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "NETAMOUNT")
    private double netamount;
    @Size(max = 50)
    @Column(name = "NOOFSHARES")
    private String noofshares;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Size(max = 20)
    @Column(name = "CONTRTYPE")
    private String contrtype;
    @Column(name = "CURRAGE")
    private Integer currage;
    @Column(name = "INITDEPO")
    private Double initdepo;
    @Column(name = "PERVAL")
    private Double perval;
    @Column(name = "EMPLOYERAMT")
    private Double employeramt;
    @Column(name = "EMPLOYERUNITS")
    private Double employerunits;
    @Column(name = "EMPLOYEEAMT")
    private Double employeeamt;
    @Column(name = "EMPLOYEEUNITS")
    private Double employeeunits;
    @Size(max = 10)
    @Column(name = "TRANSTYPE")
    private String transtype;
    @Size(max = 20)
    @Column(name = "DESCRIPT")
    private String descript;
    @Size(max = 50)
    @Column(name = "T_MODE")
    private String tMode;
    @Column(name = "EMPREGAMT")
    private Double empregamt;
    @Column(name = "EMPREGUNIT")
    private Double empregunit;
    @Column(name = "EMPUNREGAMT")
    private Double empunregamt;
    @Column(name = "EMPUNREGUNIT")
    private Double empunregunit;
    @Column(name = "EMPLREGAMT")
    private Double emplregamt;
    @Column(name = "EMPLREGUNIT")
    private Double emplregunit;
    @Column(name = "EMPLUNREGAMT")
    private Double emplunregamt;
    @Column(name = "EMPLUNREGUNIT")
    private Double emplunregunit;
    @Column(name = "TYEAR")
    private Integer tyear;
    @Column(name = "TMONTH")
    private Integer tmonth;
    @Column(name = "I_RATE")
    private Double iRate;
    @Column(name = "CONFIRMED")
    private Integer confirmed;
    @Column(name = "CONFIRMEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmeddate;
    @Size(max = 40)
    @Column(name = "CONFIRMEDBY")
    private String confirmedby;
    @Column(name = "VALUENO")
    private Integer valueno;
    @Column(name = "DELETED")
    private Integer deleted;
    @Size(max = 30)
    @Column(name = "DELETEDBY")
    private String deletedby;
    @Column(name = "DELDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deldate;
    @Size(max = 30)
    @Column(name = "REVERSEDBY")
    private String reversedby;
    @Column(name = "REVERSEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reverseddate;
    @Column(name = "TAXAMT")
    private Double taxamt;
    @Column(name = "TAXUNITS")
    private Double taxunits;
    @Column(name = "SERVERTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servertime;
    @Column(name = "CHEQUEFEE")
    private Double chequefee;
    @Column(name = "BOUNCEFEE")
    private Double bouncefee;
    @Column(name = "PAYMENTSCHEDULED")
    private Integer paymentscheduled;
    @Column(name = "PAYMENTSCHEDULEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentscheduleddate;
    @Size(max = 50)
    @Column(name = "PAYMENTSCHEDULEDBY")
    private String paymentscheduledby;
    @Column(name = "PAYMENTSCHEDULEDBATCH")
    private Integer paymentscheduledbatch;
    @Column(name = "REVERSED")
    private Integer reversed;
    @Column(name = "RUNNINGUNITS")
    private Double runningunits;
    @Column(name = "NEWDBCOLUM")
    private Integer newdbcolum;
    @Column(name = "ADMINFEE")
    private Double adminfee;
    @Column(name = "CURRENCY")
    private Integer currency;
    @Size(max = 30)
    @Column(name = "CURRENCYNAME")
    private String currencyname;
    @Column(name = "BASECURRENCY")
    private Integer basecurrency;

    public Trans() {
    }

    public Trans(Integer transId) {
        this.transId = transId;
    }

    public Trans(Integer transId, String transNo, String transType, Date transDate, String accountNo, String portfolio, String mop, double amount, double netamount, Date sysdate) {
        this.transId = transId;
        this.transNo = transNo;
        this.transType = transType;
        this.transDate = transDate;
        this.accountNo = accountNo;
        this.portfolio = portfolio;
        this.mop = mop;
        this.amount = amount;
        this.netamount = netamount;
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

    public double getNetamount() {
        return netamount;
    }

    public void setNetamount(double netamount) {
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

    public String getContrtype() {
        return contrtype;
    }

    public void setContrtype(String contrtype) {
        this.contrtype = contrtype;
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

    public Double getPerval() {
        return perval;
    }

    public void setPerval(Double perval) {
        this.perval = perval;
    }

    public Double getEmployeramt() {
        return employeramt;
    }

    public void setEmployeramt(Double employeramt) {
        this.employeramt = employeramt;
    }

    public Double getEmployerunits() {
        return employerunits;
    }

    public void setEmployerunits(Double employerunits) {
        this.employerunits = employerunits;
    }

    public Double getEmployeeamt() {
        return employeeamt;
    }

    public void setEmployeeamt(Double employeeamt) {
        this.employeeamt = employeeamt;
    }

    public Double getEmployeeunits() {
        return employeeunits;
    }

    public void setEmployeeunits(Double employeeunits) {
        this.employeeunits = employeeunits;
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

    public Double getEmpregamt() {
        return empregamt;
    }

    public void setEmpregamt(Double empregamt) {
        this.empregamt = empregamt;
    }

    public Double getEmpregunit() {
        return empregunit;
    }

    public void setEmpregunit(Double empregunit) {
        this.empregunit = empregunit;
    }

    public Double getEmpunregamt() {
        return empunregamt;
    }

    public void setEmpunregamt(Double empunregamt) {
        this.empunregamt = empunregamt;
    }

    public Double getEmpunregunit() {
        return empunregunit;
    }

    public void setEmpunregunit(Double empunregunit) {
        this.empunregunit = empunregunit;
    }

    public Double getEmplregamt() {
        return emplregamt;
    }

    public void setEmplregamt(Double emplregamt) {
        this.emplregamt = emplregamt;
    }

    public Double getEmplregunit() {
        return emplregunit;
    }

    public void setEmplregunit(Double emplregunit) {
        this.emplregunit = emplregunit;
    }

    public Double getEmplunregamt() {
        return emplunregamt;
    }

    public void setEmplunregamt(Double emplunregamt) {
        this.emplunregamt = emplunregamt;
    }

    public Double getEmplunregunit() {
        return emplunregunit;
    }

    public void setEmplunregunit(Double emplunregunit) {
        this.emplunregunit = emplunregunit;
    }

    public Integer getTyear() {
        return tyear;
    }

    public void setTyear(Integer tyear) {
        this.tyear = tyear;
    }

    public Integer getTmonth() {
        return tmonth;
    }

    public void setTmonth(Integer tmonth) {
        this.tmonth = tmonth;
    }

    public Double getIRate() {
        return iRate;
    }

    public void setIRate(Double iRate) {
        this.iRate = iRate;
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

    public Integer getValueno() {
        return valueno;
    }

    public void setValueno(Integer valueno) {
        this.valueno = valueno;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    public Date getDeldate() {
        return deldate;
    }

    public void setDeldate(Date deldate) {
        this.deldate = deldate;
    }

    public String getReversedby() {
        return reversedby;
    }

    public void setReversedby(String reversedby) {
        this.reversedby = reversedby;
    }

    public Date getReverseddate() {
        return reverseddate;
    }

    public void setReverseddate(Date reverseddate) {
        this.reverseddate = reverseddate;
    }

    public Double getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(Double taxamt) {
        this.taxamt = taxamt;
    }

    public Double getTaxunits() {
        return taxunits;
    }

    public void setTaxunits(Double taxunits) {
        this.taxunits = taxunits;
    }

    public Date getServertime() {
        return servertime;
    }

    public void setServertime(Date servertime) {
        this.servertime = servertime;
    }

    public Double getChequefee() {
        return chequefee;
    }

    public void setChequefee(Double chequefee) {
        this.chequefee = chequefee;
    }

    public Double getBouncefee() {
        return bouncefee;
    }

    public void setBouncefee(Double bouncefee) {
        this.bouncefee = bouncefee;
    }

    public Integer getPaymentscheduled() {
        return paymentscheduled;
    }

    public void setPaymentscheduled(Integer paymentscheduled) {
        this.paymentscheduled = paymentscheduled;
    }

    public Date getPaymentscheduleddate() {
        return paymentscheduleddate;
    }

    public void setPaymentscheduleddate(Date paymentscheduleddate) {
        this.paymentscheduleddate = paymentscheduleddate;
    }

    public String getPaymentscheduledby() {
        return paymentscheduledby;
    }

    public void setPaymentscheduledby(String paymentscheduledby) {
        this.paymentscheduledby = paymentscheduledby;
    }

    public Integer getPaymentscheduledbatch() {
        return paymentscheduledbatch;
    }

    public void setPaymentscheduledbatch(Integer paymentscheduledbatch) {
        this.paymentscheduledbatch = paymentscheduledbatch;
    }

    public Integer getReversed() {
        return reversed;
    }

    public void setReversed(Integer reversed) {
        this.reversed = reversed;
    }

    public Double getRunningunits() {
        return runningunits;
    }

    public void setRunningunits(Double runningunits) {
        this.runningunits = runningunits;
    }

    public Integer getNewdbcolum() {
        return newdbcolum;
    }

    public void setNewdbcolum(Integer newdbcolum) {
        this.newdbcolum = newdbcolum;
    }

    public Double getAdminfee() {
        return adminfee;
    }

    public void setAdminfee(Double adminfee) {
        this.adminfee = adminfee;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    public Integer getBasecurrency() {
        return basecurrency;
    }

    public void setBasecurrency(Integer basecurrency) {
        this.basecurrency = basecurrency;
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
        if (!(object instanceof Trans)) {
            return false;
        }
        Trans other = (Trans) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Trans[ transId=" + transId + " ]";
    }
    
}
