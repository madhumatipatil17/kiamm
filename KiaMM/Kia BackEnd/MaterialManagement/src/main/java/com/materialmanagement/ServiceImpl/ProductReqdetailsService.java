package com.materialmanagement.ServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.materialmanagement.DAO.ProdReqDetailsRepository;
import com.materialmanagement.Exception.ResourceNotFoundException;
import com.materialmanagement.Model.MmProdReqDetailsEntity;

@Service
public class ProductReqdetailsService {

	private static final Logger logger = LoggerFactory.getLogger(ProductReqdetailsService.class);

	@Autowired
	ProdReqDetailsRepository reqDetailsRepository;

	@Transactional(rollbackFor = Exception.class)
	public void saveProductReqDetails(ArrayList<MmProdReqDetailsEntity> productList) {
		int length = productList.size();
		if (length == 0 || productList.isEmpty() || productList == null) {
			throw new ResourceNotFoundException("Product List Not Available");
		} else {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			for (MmProdReqDetailsEntity product : productList) {
				MmProdReqDetailsEntity mmProdReqDetailsEntity = new MmProdReqDetailsEntity();
				mmProdReqDetailsEntity.setProdReqHdrId(product.getProdReqHdrId());
				mmProdReqDetailsEntity.setProdMasterId(product.getProdMasterId());
				mmProdReqDetailsEntity.setOrderedQty(product.getOrderedQty());
				mmProdReqDetailsEntity.setUomId(product.getUomId());
				mmProdReqDetailsEntity.setStatusId(1);
				mmProdReqDetailsEntity.setCreatedBy(1);
				mmProdReqDetailsEntity.setCreatedOn(timestamp);
				logger.info("Product Request Details {}" + mmProdReqDetailsEntity);
				reqDetailsRepository.save(mmProdReqDetailsEntity);
			}
		}
	}

}
