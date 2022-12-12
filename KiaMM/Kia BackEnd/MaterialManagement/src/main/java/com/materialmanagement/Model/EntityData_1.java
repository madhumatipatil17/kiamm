package com.materialmanagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entity_Data")
public class EntityData extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Entity_Data_Id")
	private int entityDataId;

	@Column(name = "Entity_Type", length = 50)
	private String entityType;

	@Column(name = "CODE", length = 50)
	private String code;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@Column(name = "IS_ACTIVE", length = 1)
	private int isActive;

	public EntityData() {

	}

	public EntityData(int entityDataId, String entityType, String code, String name, String description,
			int isActive) {
		super();
		this.entityDataId = entityDataId;
		this.entityType = entityType;
		this.code = code;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
	}

	public int getEntityDataId() {
		return entityDataId;
	}

	public void setEntityDataId(int entityDataId) {
		this.entityDataId = entityDataId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
