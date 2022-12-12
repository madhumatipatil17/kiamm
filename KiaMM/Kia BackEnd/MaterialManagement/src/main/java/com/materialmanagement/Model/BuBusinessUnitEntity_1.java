package com.materialmanagement.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bu_business_unit")

public class BuBusinessUnitEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_ID")
    private Integer parentId;

    @Column(name = "BU_TYPE_ID")
    private Integer buTypeId;

    @Column(name = "USER_TYPE_ID")
    private Integer userTypeId;

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

    @Column(name = "APPROVAL_STATUS_ID")
    private Integer approvalStatusId;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "GROUP_EMAIL_ID")
    private String groupEmailId;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "WORKING_CODE")
    private String workingCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getBuTypeId() {
		return buTypeId;
	}

	public void setBuTypeId(Integer buTypeId) {
		this.buTypeId = buTypeId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
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

	public String getGroupEmailId() {
		return groupEmailId;
	}

	public void setGroupEmailId(String groupEmailId) {
		this.groupEmailId = groupEmailId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getWorkingCode() {
		return workingCode;
	}

	public void setWorkingCode(String workingCode) {
		this.workingCode = workingCode;
	}

	public BuBusinessUnitEntity(int id, String code, String name, String description, Integer parentId,
			Integer buTypeId, Integer userTypeId, Byte isActive, Integer createdBy, Timestamp createdOn,
			Integer updatedBy, Timestamp updatedOn, Integer approvalStatusId, String comments, String groupEmailId,
			String shortName, String workingCode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.buTypeId = buTypeId;
		this.userTypeId = userTypeId;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.approvalStatusId = approvalStatusId;
		this.comments = comments;
		this.groupEmailId = groupEmailId;
		this.shortName = shortName;
		this.workingCode = workingCode;
	}

	@Override
	public String toString() {
		return "BuBusinessUnitEntity [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", parentId=" + parentId + ", buTypeId=" + buTypeId + ", userTypeId=" + userTypeId + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + ", approvalStatusId=" + approvalStatusId + ", comments=" + comments
				+ ", groupEmailId=" + groupEmailId + ", shortName=" + shortName + ", workingCode=" + workingCode + "]";
	}



}
