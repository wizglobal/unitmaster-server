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
@Table(name = "MEMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m"),
    @NamedQuery(name = "Members.findByMemberNo", query = "SELECT m FROM Members m WHERE m.memberNo = :memberNo"),
    @NamedQuery(name = "Members.findByTelNo", query = "SELECT m FROM Members m WHERE m.telNo = :telNo"),
    @NamedQuery(name = "Members.findByGsmNo", query = "SELECT m FROM Members m WHERE m.gsmNo = :gsmNo"),
    @NamedQuery(name = "Members.findByEMail", query = "SELECT m FROM Members m WHERE m.eMail = :eMail"),
    @NamedQuery(name = "Members.findByIdNo", query = "SELECT m FROM Members m WHERE m.idNo = :idNo"),
    @NamedQuery(name = "Members.findByUname", query = "SELECT m FROM Members m WHERE m.uname = :uname"),
    @NamedQuery(name = "Members.findBySuspenseMember", query = "SELECT m FROM Members m WHERE m.suspenseMember = :suspenseMember")})
public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Size(max = 8)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
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
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Size(max = 20)
    @Column(name = "TEL_NO")
    private String telNo;
    @Size(max = 50)
    @Column(name = "PHYS_ADDRESS")
    private String physAddress;
    @Size(max = 40)
    @Column(name = "TOWN")
    private String town;
    @Size(max = 20)
    @Column(name = "STREET")
    private String street;
    @Size(max = 20)
    @Column(name = "HSE_NO")
    private String hseNo;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 1)
    @Column(name = "SMS_NTFY")
    private String smsNtfy;
    @Size(max = 1)
    @Column(name = "SMSQRY_ACCEPT")
    private String smsqryAccept;
    @Size(max = 200)
    @Column(name = "GSM_NO")
    private String gsmNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "E_MAIL")
    private String eMail;
    @Size(max = 12)
    @Column(name = "ID_NO")
    private String idNo;
    @Size(max = 15)
    @Column(name = "PIN_NO")
    private String pinNo;
    @Lob
    @Column(name = "SIGNATURE")
    private byte[] signature;
    @Lob
    @Column(name = "PICTURE")
    private byte[] picture;
    @Column(name = "TERMINATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationdate;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 6)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 30)
    @Column(name = "EMPLOYER")
    private String employer;
    @Size(max = 15)
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Column(name = "RETAGE")
    private Integer retage;
    @Size(max = 20)
    @Column(name = "UNAME")
    private String uname;
    @Size(max = 20)
    @Column(name = "COMP")
    private String comp;
    @Size(max = 9)
    @Column(name = "COMPANY_NO")
    private String companyNo;
    @Size(max = 50)
    @Column(name = "COMPANYNAME")
    private String companyname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMT")
    private Double amt;
    @Column(name = "CONTRIBUTIONTYPE")
    private Integer contributiontype;
    @Size(max = 50)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "EXPTRETYR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exptretyr;
    @Column(name = "EMPLOYMENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date employmentdate;
    @Column(name = "SALARY")
    private Double salary;
    @Size(max = 20)
    @Column(name = "OCCUPATION")
    private String occupation;
    @Size(max = 10)
    @Column(name = "PAYROLID")
    private String payrolid;
    @Column(name = "PREVIOUSBENEFITS")
    private Double previousbenefits;
    @Column(name = "EMPLOYED")
    private Integer employed;
    @Column(name = "DATEJOINEDP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datejoinedp;
    @Size(max = 15)
    @Column(name = "MEMTYPE")
    private String memtype;
    @Column(name = "CONFIRMED")
    private Integer confirmed;
    @Column(name = "CONFIRMEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmeddate;
    @Size(max = 40)
    @Column(name = "CONFIRMEDBY")
    private String confirmedby;
    @Lob
    @Column(name = "SIGNATURE1")
    private byte[] signature1;
    @Lob
    @Column(name = "PICTURE1")
    private byte[] picture1;
    @Column(name = "TAXEXEMPT")
    private Integer taxexempt;
    @Column(name = "RESIDENT")
    private Integer resident;
    @Column(name = "STATEMENTTYPE")
    private Integer statementtype;
    @Column(name = "PREVIOUSMEMBER")
    private Integer previousmember;
    @Column(name = "STAFF")
    private Integer staff;
    @Column(name = "HOWDIDUKNOW")
    private Integer howdiduknow;
    @Size(max = 50)
    @Column(name = "OTHERKNOW")
    private String otherknow;
    @Column(name = "VERIFIED")
    private Integer verified;
    @Column(name = "VERIFYMANID")
    private Integer verifymanid;
    @Size(max = 70)
    @Column(name = "VERIFYMANAGER")
    private String verifymanager;
    @Column(name = "IDPASS")
    private Integer idpass;
    @Size(max = 50)
    @Column(name = "FUNDSSOURCE")
    private String fundssource;
    @Size(max = 200)
    @Column(name = "OTHERSOURCE")
    private String othersource;
    @Column(name = "WEBPASS")
    private Integer webpass;
    @Size(max = 100)
    @Column(name = "REFFERAL")
    private String refferal;
    @Column(name = "BRANCHID")
    private Integer branchid;
    @Size(max = 200)
    @Column(name = "BRANCHNAME")
    private String branchname;
    @Column(name = "SUSPENSE_MEMBER")
    private Integer suspenseMember;

    public Members() {
    }

    public Members(String memberNo) {
        this.memberNo = memberNo;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHseNo() {
        return hseNo;
    }

    public void setHseNo(String hseNo) {
        this.hseNo = hseNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSmsNtfy() {
        return smsNtfy;
    }

    public void setSmsNtfy(String smsNtfy) {
        this.smsNtfy = smsNtfy;
    }

    public String getSmsqryAccept() {
        return smsqryAccept;
    }

    public void setSmsqryAccept(String smsqryAccept) {
        this.smsqryAccept = smsqryAccept;
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

    public Date getTerminationdate() {
        return terminationdate;
    }

    public void setTerminationdate(Date terminationdate) {
        this.terminationdate = terminationdate;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public Integer getRetage() {
        return retage;
    }

    public void setRetage(Integer retage) {
        this.retage = retage;
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

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Integer getContributiontype() {
        return contributiontype;
    }

    public void setContributiontype(Integer contributiontype) {
        this.contributiontype = contributiontype;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getExptretyr() {
        return exptretyr;
    }

    public void setExptretyr(Date exptretyr) {
        this.exptretyr = exptretyr;
    }

    public Date getEmploymentdate() {
        return employmentdate;
    }

    public void setEmploymentdate(Date employmentdate) {
        this.employmentdate = employmentdate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPayrolid() {
        return payrolid;
    }

    public void setPayrolid(String payrolid) {
        this.payrolid = payrolid;
    }

    public Double getPreviousbenefits() {
        return previousbenefits;
    }

    public void setPreviousbenefits(Double previousbenefits) {
        this.previousbenefits = previousbenefits;
    }

    public Integer getEmployed() {
        return employed;
    }

    public void setEmployed(Integer employed) {
        this.employed = employed;
    }

    public Date getDatejoinedp() {
        return datejoinedp;
    }

    public void setDatejoinedp(Date datejoinedp) {
        this.datejoinedp = datejoinedp;
    }

    public String getMemtype() {
        return memtype;
    }

    public void setMemtype(String memtype) {
        this.memtype = memtype;
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

    public byte[] getSignature1() {
        return signature1;
    }

    public void setSignature1(byte[] signature1) {
        this.signature1 = signature1;
    }

    public byte[] getPicture1() {
        return picture1;
    }

    public void setPicture1(byte[] picture1) {
        this.picture1 = picture1;
    }

    public Integer getTaxexempt() {
        return taxexempt;
    }

    public void setTaxexempt(Integer taxexempt) {
        this.taxexempt = taxexempt;
    }

    public Integer getResident() {
        return resident;
    }

    public void setResident(Integer resident) {
        this.resident = resident;
    }

    public Integer getStatementtype() {
        return statementtype;
    }

    public void setStatementtype(Integer statementtype) {
        this.statementtype = statementtype;
    }

    public Integer getPreviousmember() {
        return previousmember;
    }

    public void setPreviousmember(Integer previousmember) {
        this.previousmember = previousmember;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getHowdiduknow() {
        return howdiduknow;
    }

    public void setHowdiduknow(Integer howdiduknow) {
        this.howdiduknow = howdiduknow;
    }

    public String getOtherknow() {
        return otherknow;
    }

    public void setOtherknow(String otherknow) {
        this.otherknow = otherknow;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Integer getVerifymanid() {
        return verifymanid;
    }

    public void setVerifymanid(Integer verifymanid) {
        this.verifymanid = verifymanid;
    }

    public String getVerifymanager() {
        return verifymanager;
    }

    public void setVerifymanager(String verifymanager) {
        this.verifymanager = verifymanager;
    }

    public Integer getIdpass() {
        return idpass;
    }

    public void setIdpass(Integer idpass) {
        this.idpass = idpass;
    }

    public String getFundssource() {
        return fundssource;
    }

    public void setFundssource(String fundssource) {
        this.fundssource = fundssource;
    }

    public String getOthersource() {
        return othersource;
    }

    public void setOthersource(String othersource) {
        this.othersource = othersource;
    }

    public Integer getWebpass() {
        return webpass;
    }

    public void setWebpass(Integer webpass) {
        this.webpass = webpass;
    }

    public String getRefferal() {
        return refferal;
    }

    public void setRefferal(String refferal) {
        this.refferal = refferal;
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

    public Integer getSuspenseMember() {
        return suspenseMember;
    }

    public void setSuspenseMember(Integer suspenseMember) {
        this.suspenseMember = suspenseMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberNo != null ? memberNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.memberNo == null && other.memberNo != null) || (this.memberNo != null && !this.memberNo.equals(other.memberNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Members[ memberNo=" + memberNo + " ]";
    }
    
}
