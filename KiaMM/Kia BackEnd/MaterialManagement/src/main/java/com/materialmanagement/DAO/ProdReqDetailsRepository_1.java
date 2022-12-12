package com.materialmanagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.materialmanagement.DTO.OrderDetails;
import com.materialmanagement.Model.MmProdReqDetailsEntity;

@Repository
public interface ProdReqDetailsRepository extends JpaRepository<MmProdReqDetailsEntity, Integer> {

	@Query(value = "select  h.REQ_NBR reqNbr,h.REQ_DATE reqDate,h.REQ_DEPT reqDept,bu.name reqDeptName,\r\n"
			+ "d.PROD_MASTER_ID prodMasterId,p.PROD_NAME prodName,p.description,d.ORDERED_QTY orderedQty,cat.name as category\r\n"
			+ "from MM_PROD_REQ_HEADER h,MM_PROD_REQ_DETAILS d,bu_business_unit bu,MM_PRODUCT_MASTER p,entity_data cat\r\n"
			+ "where d.PROD_REQ_HDR_ID=?1 \r\n"
			+ "and d.PROD_REQ_HDR_ID=h.PROD_REQ_HDR_ID\r\n"
			+ "and h.REQ_DEPT=bu.ID\r\n"
			+ "and d.PROD_MASTER_ID=p.PROD_MASTER_ID\r\n"
			+ "and cat.entity_data_id=p.prod_category_id", nativeQuery = true)
	public List<OrderDetails> findByProdReqHdrId(@Param(value = "prodReqHdrId") int prodReqHdrId);
}
