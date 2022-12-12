package com.materialmanagement.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseModel {

	@Column(name = "CREATED_BY", length = 11)
	private int createdBy;

	@CreationTimestamp
	@Column(name = "CREATED_ON", updatable = false)
	private Timestamp createdOn;

	@Column(name = "UPDATED_BY", length = 11)
	private int updatedBy;

	@UpdateTimestamp
	@Column(name = "UPDATED_ON", insertable = false)
	private Timestamp updatedOn;

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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

}
