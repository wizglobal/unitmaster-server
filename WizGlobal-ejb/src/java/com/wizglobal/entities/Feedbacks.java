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
@Table(name = "FEEDBACKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedbacks.findAll", query = "SELECT f FROM Feedbacks f"),
    @NamedQuery(name = "Feedbacks.findById", query = "SELECT f FROM Feedbacks f WHERE f.id = :id"),
    @NamedQuery(name = "Feedbacks.findByMemberNo", query = "SELECT f FROM Feedbacks f WHERE f.memberNo = :memberNo"),
    @NamedQuery(name = "Feedbacks.findBySubject", query = "SELECT f FROM Feedbacks f WHERE f.subject = :subject"),
    @NamedQuery(name = "Feedbacks.findByRespondedTo", query = "SELECT f FROM Feedbacks f WHERE f.respondedTo = :respondedTo"),
    @NamedQuery(name = "Feedbacks.findByResponcedate", query = "SELECT f FROM Feedbacks f WHERE f.responcedate = :responcedate"),
    @NamedQuery(name = "Feedbacks.findByRespondedBy", query = "SELECT f FROM Feedbacks f WHERE f.respondedBy = :respondedBy"),
    @NamedQuery(name = "Feedbacks.findByResponce", query = "SELECT f FROM Feedbacks f WHERE f.responce = :responce"),
    @NamedQuery(name = "Feedbacks.findBySubmissionDate", query = "SELECT f FROM Feedbacks f WHERE f.submissionDate = :submissionDate"),
    @NamedQuery(name = "Feedbacks.findByDescription", query = "SELECT f FROM Feedbacks f WHERE f.description = :description"),
    @NamedQuery(name = "Feedbacks.findByCategory", query = "SELECT f FROM Feedbacks f WHERE f.category = :category"),
    @NamedQuery(name = "Feedbacks.findByResponseDate", query = "SELECT f FROM Feedbacks f WHERE f.responseDate = :responseDate"),
    @NamedQuery(name = "Feedbacks.findByResponse", query = "SELECT f FROM Feedbacks f WHERE f.response = :response")})
public class Feedbacks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Size(max = 100)
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "RESPONDED_TO")
    private Integer respondedTo;
    @Size(max = 15)
    @Column(name = "RESPONCEDATE")
    private String responcedate;
    @Size(max = 30)
    @Column(name = "RESPONDED_BY")
    private String respondedBy;
    @Size(max = 200)
    @Column(name = "RESPONCE")
    private String responce;
    @Column(name = "SUBMISSION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "RESPONSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseDate;
    @Size(max = 200)
    @Column(name = "RESPONSE")
    private String response;

    public Feedbacks() {
    }

    public Feedbacks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getRespondedTo() {
        return respondedTo;
    }

    public void setRespondedTo(Integer respondedTo) {
        this.respondedTo = respondedTo;
    }

    public String getResponcedate() {
        return responcedate;
    }

    public void setResponcedate(String responcedate) {
        this.responcedate = responcedate;
    }

    public String getRespondedBy() {
        return respondedBy;
    }

    public void setRespondedBy(String respondedBy) {
        this.respondedBy = respondedBy;
    }

    public String getResponce() {
        return responce;
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedbacks)) {
            return false;
        }
        Feedbacks other = (Feedbacks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wizglobal.entities.Feedbacks[ id=" + id + " ]";
    }
    
}
