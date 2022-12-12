package com.materialmanagement.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.materialmanagement.DTO.OrderSummary;
import com.materialmanagement.Model.MmProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<MmProductMaster, Integer> {

	@Query(value = "SELECT p FROM MmProductMaster p WHERE p.prodCode =:prodCode AND p.isActive =:isActive")
	public MmProductMaster findByProdCodeAndIsActive(@Param("prodCode") String prodCode,
			@Param("isActive") String isActive);

	public boolean existsByProdCodeAndIsActive(String prodCode, String isActive);

	@Query("select p from MmProductMaster p where (p.prodName like %?1% and p.isActive =?3) or (p.partNumber =?2 and p.isActive =?3)")
	Page<MmProductMaster> getProductByPartNoOrProductName(String prod_name, String part_nbr, String is_active,
			PageRequest pageRequest);

	@Query("select p from MmProductMaster p where p.prodName like %?1% and p.isActive =?2") // FETCHING PRODUCTS
																							// ACCORDING TO PROD_NAME
	List<MmProductMaster> getProductsByProductsName(String prod_name, String is_active);

	@Query("select p from MmProductMaster p where p.prodName like %?1%") // PAGINATION ON PROD_NAME
	Page<MmProductMaster> findPagination(String prod_name, PageRequest pageRequest);

	@Query(value = "select p.prod_master_id prodMasterId,p.prod_name prodName,p.prod_category_id prodCategoryId,catg.name category,p.prod_type_id prodTypeId,ptype.name productType,p.length,p.dia_mm diaMm,p.drive_size driveSize ,p.uom as uomId,uom.name uomName \r\n"
			+ "from MM_PRODUCT_MASTER p,entity_data catg,entity_data ptype,entity_data uom\r\n"
			+ "where p.prod_master_id IN(?1)\r\n" + "and catg.entity_data_id=p.prod_category_id\r\n"
			+ "and ptype.entity_data_id=p.prod_type_id\r\n" + "and uom.entity_data_id=p.uom", nativeQuery = true)
	public List<OrderSummary> findByProdMasterId(@Param(value = "prodMasterId") List<Integer> prodMasterId);
}
