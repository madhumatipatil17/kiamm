package com.materialmanagement.DTO;

public class ProductResponse {

    private int prodMasterId;
    private String imgLocation;
    private String prodName;
    private String category;
    private String description;
    private String partNumber;
    private String productType;
	public int getProdMasterId() {
		return prodMasterId;
	}
	public void setProdMasterId(int prodMasterId) {
		this.prodMasterId = prodMasterId;
	}
	public String getImgLocation() {
		return imgLocation;
	}
	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public ProductResponse(int prodMasterId, String imgLocation, String prodName, String category, String description,
			String partNumber, String productType) {
		super();
		this.prodMasterId = prodMasterId;
		this.imgLocation = imgLocation;
		this.prodName = prodName;
		this.category = category;
		this.description = description;
		this.partNumber = partNumber;
		this.productType = productType;
	}
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductResponse [prodMasterId=" + prodMasterId + ", imgLocation=" + imgLocation + ", prodName="
				+ prodName + ", category=" + category + ", description=" + description + ", partNumber=" + partNumber
				+ ", productType=" + productType + "]";
	}
	
    

}
