package com.materialmanagement.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")

public class UserAccountEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BUS_UNIT_ID")
    private Integer busUnitId;

    @Column(name = "SECTION_ID")
    private Integer sectionId;

    @Column(name = "USER_TYPE_ID")
    private Integer userTypeId;

    @Column(name = "LAST_LOGIN_TIME")
    private Timestamp lastLoginTime;

    @Column(name = "IS_ACTIVE")
    private Byte isActive;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATED_ON")
    private Timestamp createdOn;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "UPDATED_ON")
    private Timestamp updatedOn;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "APPROVAL_STATUS_ID")
    private Integer approvalStatusId;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "IS_LOCKED")
    private Byte isLocked;

    @Column(name = "IT_SUPPORT_NO")
    private String itSupportNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getBusUnitId() {
		return busUnitId;
	}

	public void setBusUnitId(Integer busUnitId) {
		this.busUnitId = busUnitId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getApprovalStatusId() {
		return approvalStatusId;
	}

	public void setApprovalStatusId(Integer approvalStatusId) {
		this.approvalStatusId = approvalStatusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Byte getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Byte isLocked) {
		this.isLocked = isLocked;
	}

	public String getItSupportNo() {
		return itSupportNo;
	}

	public void setItSupportNo(String itSupportNo) {
		this.itSupportNo = itSupportNo;
	}

	@Override
	public String toString() {
		return "UserAccountEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", busUnitId="
				+ busUnitId + ", sectionId=" + sectionId + ", userTypeId=" + userTypeId + ", lastLoginTime="
				+ lastLoginTime + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", description=" + description
				+ ", approvalStatusId=" + approvalStatusId + ", comments=" + comments + ", isLocked=" + isLocked
				+ ", itSupportNo=" + itSupportNo + "]";
	}

	public UserAccountEntity(int id, String userName, String password, Integer busUnitId, Integer sectionId,
			Integer userTypeId, Timestamp lastLoginTime, Byte isActive, Integer createdBy, Timestamp createdOn,
			Integer updatedBy, Timestamp updatedOn, String description, Integer approvalStatusId, String comments,
			Byte isLocked, String itSupportNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.busUnitId = busUnitId;
		this.sectionId = sectionId;
		this.userTypeId = userTypeId;
		this.lastLoginTime = lastLoginTime;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.description = description;
		this.approvalStatusId = approvalStatusId;
		this.comments = comments;
		this.isLocked = isLocked;
		this.itSupportNo = itSupportNo;
	}
    
    


}
