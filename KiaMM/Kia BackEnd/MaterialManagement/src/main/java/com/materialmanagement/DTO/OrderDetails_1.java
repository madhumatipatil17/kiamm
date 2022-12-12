package com.materialmanagement.DTO;

import java.sql.Timestamp;

public interface OrderDetails {

	public String getReqNbr();

	public Timestamp getReqDate();

	public Integer getReqDept();

	public String getReqDeptName();

	public Integer getProdMasterId();

	public String getProdName();

	public String getDescription();

	public int getOrderedQty();

	public String getCategory();

}
