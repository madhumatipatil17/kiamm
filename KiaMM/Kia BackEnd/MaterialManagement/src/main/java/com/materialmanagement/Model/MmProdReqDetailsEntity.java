package com.materialmanagement.Model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "mm_prod_req_details")
public class MmProdReqDetailsEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "PROD_REQ_DTLS_ID")
	private int prodReqDtlsId;

	@Column(name = "PROD_REQ_HDR_ID")
	private Integer prodReqHdrId;

	@Positive(message = "Invalid Product Master Id")
	@NotNull(message = "Product Master Id not be a null value")
	@Column(name = "PROD_MASTER_ID")
	private Integer prodMasterId;

	@Positive(message = "Invalid Order Quantity")
	@NotNull(message = "Order Quantity not be a null value")
	@Column(name = "ORDERED_QTY")
	private Integer orderedQty;

	@Column(name = "APPRVD_QTY")
	private Integer apprvdQty;

	@Positive(message = "Invalid UOM Id")
	@NotNull(message = "UOM Id not be a null value")
	@Column(name = "UOM_ID")
	private Integer uomId;

	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	@Positive(message = "Invalid Status Id")
	@NotNull(message = "Status Id not be a null value")
	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Positive(message = "Invalid Created By")
	@NotNull(message = "Created By not be a null value")
	@Column(name = "CREATED_BY")
	private int createdBy;

	@NotNull(message = "Created On not be a null value")
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	@Column(name = "UPDATED_BY")
	private Integer updatedBy;

	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;

	public int getProdReqDtlsId() {
		return prodReqDtlsId;
	}

	public void setProdReqDtlsId(int prodReqDtlsId) {
		this.prodReqDtlsId = prodReqDtlsId;
	}

	public Integer getProdReqHdrId() {
		return prodReqHdrId;
	}

	public void setProdReqHdrId(Integer prodReqHdrId) {
		this.prodReqHdrId = prodReqHdrId;
	}

	public Integer getProdMasterId() {
		return prodMasterId;
	}

	public void setProdMasterId(Integer prodMasterId) {
		this.prodMasterId = prodMasterId;
	}

	public Integer getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}

	public Integer getApprvdQty() {
		return apprvdQty;
	}

	public void setApprvdQty(Integer apprvdQty) {
		this.apprvdQty = apprvdQty;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
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

	@Override
	public String toString() {
		return "MmProdReqDetailsEntity [prodReqDtlsId=" + prodReqDtlsId + ", prodReqHdrId=" + prodReqHdrId
				+ ", prodMasterId=" + prodMasterId + ", orderedQty=" + orderedQty + ", apprvdQty=" + apprvdQty
				+ ", uomId=" + uomId + ", expiryDate=" + expiryDate + ", statusId=" + statusId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}

	public MmProdReqDetailsEntity(int prodReqDtlsId, Integer prodReqHdrId,
			@Positive(message = "Invalid Product Master Id") @NotNull(message = "Product Master Id not be a null value") Integer prodMasterId,
			@Positive(message = "Invalid Order Quantity") @NotNull(message = "Order Quantity not be a null value") Integer orderedQty,
			Integer apprvdQty,
			@Positive(message = "Invalid UOM Id") @NotNull(message = "UOM Id not be a null value") Integer uomId,
			Date expiryDate,
			@Positive(message = "Invalid Status Id") @NotNull(message = "Status Id not be a null value") Integer statusId,
			@Positive(message = "Invalid Created By") @NotNull(message = "Created By not be a null value") int createdBy,
			@NotNull(message = "Created On not be a null value") Timestamp createdOn, Integer updatedBy,
			Timestamp updatedOn) {
		super();
		this.prodReqDtlsId = prodReqDtlsId;
		this.prodReqHdrId = prodReqHdrId;
		this.prodMasterId = prodMasterId;
		this.orderedQty = orderedQty;
		this.apprvdQty = apprvdQty;
		this.uomId = uomId;
		this.expiryDate = expiryDate;
		this.statusId = statusId;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public MmProdReqDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
