package com.materialmanagement.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.materialmanagement.DAO.EntityDataRepository;
import com.materialmanagement.Exception.ResourceNotFoundException;
import com.materialmanagement.Model.EntityData;
import com.materialmanagement.Service.EntityDataService;

@Repository
public class EntityDataServiceImpl implements EntityDataService {

	@Autowired
	private EntityDataRepository entityDataRepository;

	@Override
	public List<Map<String, Object>> getAllProductCategory() {
		List<EntityData> categoryList = entityDataRepository.findByEntityTypeAndIsActive("product_category", 1);
		if (null == categoryList || categoryList.isEmpty()) {
			throw new ResourceNotFoundException("Product Category List Not Found");
		} else {
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			categoryList.parallelStream().forEach(category -> {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("entityDataId", category.getEntityDataId());
				map.put("entityType", category.getEntityType());
				map.put("code", category.getCode());
				map.put("name", category.getName());
				resultList.add(map);
			});
			return resultList;
		}
	}

	@Override
	public List<Map<String, Object>> getAllProductType() {
		List<EntityData> typeList = entityDataRepository.findByEntityTypeAndIsActive("product_type", 1);
		if (null == typeList || typeList.isEmpty()) {
			throw new ResourceNotFoundException("Product Type List Not Found");
		} else {
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			typeList.parallelStream().forEach(type -> {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("entityDataId", type.getEntityDataId());
				map.put("entityType", type.getEntityType());
				map.put("code", type.getCode());
				map.put("name", type.getName());
				resultList.add(map);
			});
			return resultList;
		}
	}

	@Override
	public List<Map<String, Object>> getVolumn() {
		List<EntityData> uomList = entityDataRepository.findByEntityTypeAndIsActive("uom", 1);
		if (null == uomList || uomList.isEmpty()) {
			throw new ResourceNotFoundException("UOM List Not Found");
		} else {
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			uomList.parallelStream().forEach(uom -> {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("entityDataId", uom.getEntityDataId());
				map.put("entityType", uom.getEntityType());
				map.put("code", uom.getCode());
				map.put("name", uom.getName());
				resultList.add(map);
			});
			return resultList;
		}
	}
	
	public List<Map<String, Object>> getLine() {
		List<EntityData> line = entityDataRepository.findByEntityTypeAndIsActive("line", 1);
		if (null == line || line.isEmpty()) {
			throw new ResourceNotFoundException("Line List Not Found");
		} else {
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			line.parallelStream().forEach(lineData -> {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("entityDataId", lineData.getEntityDataId());
				map.put("entityType", lineData.getEntityType());
				map.put("code", lineData.getCode());
				map.put("name", lineData.getName());
				resultList.add(map);
			});
			return resultList;
		}
	}

//	@Override
//	public Map<String, Object> getProductCategoryByCode(String code) {
//		EntityData entityData = entityDataRepository.findByEntityTypeAndCode("product_category", code, 1);
//		if (null == entityData) {
//			throw new ResourceNotFoundException("Product Category Not Found");
//		} else {
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			resultMap.put("entityDataId", entityData.getEntityDataId());
//			resultMap.put("entityType", entityData.getEntityType());
//			resultMap.put("code", entityData.getCode());
//			resultMap.put("name", entityData.getName());
//			return resultMap;
//		}
//	}
//
//	@Override
//	public Map<String, Object> getProductTypeByCode(String code) {
//		EntityData entityData = entityDataRepository.findByEntityTypeAndCode("product_type", code, 1);
//		if (null == entityData) {
//			throw new ResourceNotFoundException("Product Type Not Found");
//		} else {
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			resultMap.put("entityDataId", entityData.getEntityDataId());
//			resultMap.put("entityType", entityData.getEntityType());
//			resultMap.put("code", entityData.getCode());
//			resultMap.put("name", entityData.getName());
//			return resultMap;
//		}
//	}

}
