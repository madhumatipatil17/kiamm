package com.materialmanagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.materialmanagement.DTO.ProductResponse;
import com.materialmanagement.Model.EntityData;

@Repository
public interface EntityDataRepository extends JpaRepository<EntityData, Integer> {

	@Query(value = "SELECT e FROM EntityData e WHERE e.entityType =:entityType AND e.code=:code AND e.isActive =:isActive")
	public EntityData findByEntityTypeAndCode(@Param(value = "entityType") String entityType,
			@Param(value = "code") String code, @Param(value = "isActive") char isActive);

	@Query(value = "SELECT e FROM EntityData e WHERE e.entityType =:entityType AND e.isActive =:isActive ORDER BY e.entityDataId DESC")
	public List<EntityData> findByEntityTypeAndIsActive(@Param(value = "entityType") String entityType,
			@Param(value = "isActive") int isActive);

	@Query("select new com.materialmanagement.DTO.ProductResponse(p.prodMasterId,p.imgLocation, p.prodName, e.code as category, "
			+ "p.description,p.partNumber,prdtype.name as productType) from EntityData e join MmProductMaster p on p.prodCategoryId = e.entityDataId "
			+ "join EntityData prdtype on p.prodTypeId=prdtype.entityDataId and e.code = :code") // FOR DROP DOWN
	public List<ProductResponse> join_Data(@Param(value = "code") String code);

	@Query("select new com.materialmanagement.DTO.ProductResponse(p.prodMasterId,p.imgLocation, p.prodName,e.code as category, "
			+ "p.description,p.partNumber,prdtype.name as productType) from EntityData e join MmProductMaster p on p.prodCategoryId = e.entityDataId "
			+ "join EntityData prdtype on p.prodTypeId=prdtype.entityDataId and e.code =?1 and p.prodName like %?2%") // FOR DROP DOWN AND SEARCH COMBO
	public List<ProductResponse> searchProductWithCategory(@Param(value = "code") String code,
			@Param(value = "prodName") String prodName);

	@Query("select e.entityDataId from EntityData e where e.code = ?1")
	public Integer findEntityDataIdByCode(String code);

}
