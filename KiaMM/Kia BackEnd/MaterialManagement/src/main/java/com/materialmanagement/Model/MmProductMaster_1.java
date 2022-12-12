package com.materialmanagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MM_PRODUCT_MASTER")
public class MmProductMaster extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_MASTER_ID")
	private int prodMasterId;

	@Positive(message = "Invalid Product Id")
	@Column(name = "PROD_CATEGORY_ID")
	private int prodCategoryId;

	@Positive(message = "Invalid ProductType Id")
	@Column(name = "PROD_TYPE_ID", length = 11)
	private int prodTypeId;

	@NotNull(message = "ProductCode not be a null value")
	@NotBlank(message = "Invalid Product Code")
	@NotEmpty(message = "Invalid Product Code")
	@Size(min = 5, max = 50, message = "Product Code Range Should be 5 To 50 Character")
	@Column(name = "PROD_CODE", length = 75)
	private String prodCode;

	@NotNull(message = "ProductName not be a null value")
	@NotBlank(message = "Invalid Product Name")
	@NotEmpty(message = "Invalid Product Name")
	@Size(min = 5, max = 100, message = "Product Name Range Should be 5 To 100 Character")
	@Column(name = "PROD_NAME", length = 150)
	private String prodName;

	@NotNull(message = "PartNumber not be a null value")
	@NotBlank(message = "Invalid Part Number")
	@NotEmpty(message = "Invalid Part Number")
	@Size(min = 5, max = 70, message = "PartNumber Range Should be 5 To 70 Character")
	@Column(name = "PART_NBR", length = 150)
	private String partNumber;

	@NotNull(message = "Description not be null")
	@NotBlank(message = "Invalid Description")
	@NotEmpty(message = "Invalid Description")
	@Size(min = 30, max = 700, message = "Description Should be 30 To 700 Character")
	@Column(name = "DESCRIPTION", length = 1000)
	private String description;

	@NotNull(message = "Length not be a null value")
	@NotBlank(message = "Invalid Length")
	@NotEmpty(message = "Invalid Length")
	@Size(min = 1, max = 40, message = "Length Should be 1 To 40 Character")
	@Column(name = "Length", length = 45)
	private String length;

	@NotNull(message = "Daimeter not be a null value")
	@NotBlank(message = "Invalid Daimeter")
	@NotEmpty(message = "Invalid Daimeter")
	@Size(min = 1, max = 40, message = "DiaMM Should be 1 To 40 Character")
	@Column(name = "DIA_MM", length = 45)
	private String diaMM;

	@NotNull(message = "DriverSize not be a null value")
	@NotBlank(message = "Invalid Daimeter")
	@NotEmpty(message = "Invalid Daimeter")
	@Size(min = 1, max = 40, message = "DriveSize Should be 1 To 40 Character")
	@Column(name = "DRIVE_SIZE", length = 45)
	private String driveSize;

	@Positive(message = "Invalid Data")
	@Column(name = "UOM", length = 11)
	private int uom;

	@Positive(message = "Invalid Data")
	@Column(name = "MIN_QTY")
	private int minQty;

	@Positive(message = "Invalid Data")
	@Column(name = "MAX_QTY")
	private int maxQty;

	@Positive(message = "Invalid Data")
	@Column(name = "TOT_QTY")
	private int totalQty;

	@Column(name = "IS_ACTIVE", length = 1)
	private String isActive;

//	@NotNull(message = "NULL value not allowed")
//	@NotBlank(message = "Invalid Image Location")
//	@NotEmpty(message = "Invalid Image Location")
//	@Min(value = 1)
	@Column(name = "IMG_LOCATION", length = 1000)
	private String imgLocation;

//	@NotNull(message = "NULL value not allowed")
//	@NotBlank(message = "Invalid Image Name")
//	@NotEmpty(message = "Invalid Image Name")
//	@Size(min = 1, max = 40, message = "Image Name To Large")
	@Column(name = "IMG_NAME", length = 150)
	private String imgName;

	public MmProductMaster() {

	}

	

	public MmProductMaster(int prodMasterId, @Positive(message = "Invalid Product Id") int prodCategoryId,
			@Positive(message = "Invalid ProductType Id") int prodTypeId,
			@NotNull(message = "ProductCode not be a null value") @NotBlank(message = "Invalid Product Code") @NotEmpty(message = "Invalid Product Code") @Size(min = 5, max = 50, message = "Product Code Range Should be 5 To 50 Character") String prodCode,
			@NotNull(message = "ProductName not be a null value") @NotBlank(message = "Invalid Product Name") @NotEmpty(message = "Invalid Product Name") @Size(min = 5, max = 100, message = "Product Name Range Should be 5 To 100 Character") String prodName,
			@NotNull(message = "PartNumber not be a null value") @NotBlank(message = "Invalid Part Number") @NotEmpty(message = "Invalid Part Number") @Size(min = 5, max = 70, message = "PartNumber Range Should be 5 To 70 Character") String partNumber,
			@NotNull(message = "Description not be null") @NotBlank(message = "Invalid Description") @NotEmpty(message = "Invalid Description") @Size(min = 30, max = 700, message = "Description Should be 30 To 700 Character") String description,
			@NotNull(message = "Length not be a null value") @NotBlank(message = "Invalid Length") @NotEmpty(message = "Invalid Length") @Size(min = 1, max = 40, message = "Length Should be 1 To 40 Character") String length,
			@NotNull(message = "Daimeter not be a null value") @NotBlank(message = "Invalid Daimeter") @NotEmpty(message = "Invalid Daimeter") @Size(min = 1, max = 40, message = "DiaMM Should be 1 To 40 Character") String diaMM,
			@NotNull(message = "DriverSize not be a null value") @NotBlank(message = "Invalid Daimeter") @NotEmpty(message = "Invalid Daimeter") @Size(min = 1, max = 40, message = "DriveSize Should be 1 To 40 Character") String driveSize,
			@Positive(message = "Invalid Data") int uom, @Positive(message = "Invalid Data") int minQty,
			@Positive(message = "Invalid Data") int maxQty, @Positive(message = "Invalid Data") int totalQty,
			String isActive, String imgLocation, String imgName) {
		super();
		this.prodMasterId = prodMasterId;
		this.prodCategoryId = prodCategoryId;
		this.prodTypeId = prodTypeId;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.partNumber = partNumber;
		this.description = description;
		this.length = length;
		this.diaMM = diaMM;
		this.driveSize = driveSize;
		this.uom = uom;
		this.minQty = minQty;
		this.maxQty = maxQty;
		this.totalQty = totalQty;
		this.isActive = isActive;
		this.imgLocation = imgLocation;
		this.imgName = imgName;
	}



	public int getProdMasterId() {
		return prodMasterId;
	}

	public void setProdMasterId(int prodMasterId) {
		this.prodMasterId = prodMasterId;
	}

	public int getProdCategoryId() {
		return prodCategoryId;
	}

	public void setProdCategoryId(int prodCategoryId) {
		this.prodCategoryId = prodCategoryId;
	}

	public int getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(int prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDiaMM() {
		return diaMM;
	}

	public void setDiaMM(String diaMM) {
		this.diaMM = diaMM;
	}

	public String getDriveSize() {
		return driveSize;
	}

	public void setDriveSize(String driveSize) {
		this.driveSize = driveSize;
	}

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		return "MmProductMaster [prodMasterId=" + prodMasterId + ", prodCategoryId=" + prodCategoryId + ", prodTypeId="
				+ prodTypeId + ", prodCode=" + prodCode + ", prodName=" + prodName + ", partNumber=" + partNumber
				+ ", description=" + description + ", length=" + length + ", diaMM=" + diaMM + ", driveSize="
				+ driveSize + ", uom=" + uom + ", minQty=" + minQty + ", maxQty=" + maxQty + ", totalQty=" + totalQty
				+ ", isActive=" + isActive + ", imgLocation=" + imgLocation + ", imgName=" + imgName + "]";
	}

}
