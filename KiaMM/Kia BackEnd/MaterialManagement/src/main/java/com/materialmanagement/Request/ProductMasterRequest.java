package com.materialmanagement.Request;

import org.springframework.web.multipart.MultipartFile;

public class ProductMasterRequest {
	private int prodMasterId;
	private int prodCategoryId;
	private int prodTypeId;
	private String prodCode;
	private String prodName;
	private String partNumber;
	private String description;
	private String lenght;
	private String diaMM;
	private String driveSize;
	private int uom;
	private int minQty;
	private int maxQty;
	private int totalQty;
	private MultipartFile imgFile;
	private String imgLocation;
	private int createdBy;
	private int updatedBy;
	
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
	public String getLenght() {
		return lenght;
	}
	public void setLenght(String lenght) {
		this.lenght = lenght;
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
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getImgLocation() {
		return imgLocation;
	}
	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}	
