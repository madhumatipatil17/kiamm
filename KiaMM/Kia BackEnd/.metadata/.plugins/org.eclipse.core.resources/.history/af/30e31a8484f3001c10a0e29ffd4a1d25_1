package com.materialmanagement.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.materialmanagement.DAO.ProductMasterRepository;
import com.materialmanagement.Exception.GlobalException;
import com.materialmanagement.Exception.ResourceNotFoundException;
import com.materialmanagement.Model.MmProductMaster;
import com.materialmanagement.Service.ProductMasterService;
import com.materialmanagement.Utility.Util;

@Service
public class ProductMasterServiceImpl implements ProductMasterService {

	private static final Logger logger = LoggerFactory.getLogger(ProductMasterServiceImpl.class);

	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public MmProductMaster addProduct(MmProductMaster productMasterRequest, MultipartFile imgFile) {
		if (!productMasterRepository.existsByProdCodeAndIsActive(productMasterRequest.getProdCode(), "Y")) {
			MmProductMaster product = new MmProductMaster();
			product.setProdCategoryId(productMasterRequest.getProdCategoryId());
			product.setProdTypeId(productMasterRequest.getProdTypeId());
			product.setProdCode(productMasterRequest.getProdCode());
			product.setProdName(productMasterRequest.getProdName());
			product.setPartNumber(productMasterRequest.getPartNumber());
			product.setDescription(productMasterRequest.getDescription());
			product.setLength(productMasterRequest.getLength());
			product.setDiaMM(productMasterRequest.getDiaMM());
			product.setDriveSize(productMasterRequest.getDriveSize());
			product.setUom(productMasterRequest.getUom());
			product.setMinQty(productMasterRequest.getMinQty());
			product.setMaxQty(productMasterRequest.getMaxQty());
			product.setTotalQty(productMasterRequest.getTotalQty());
			product.setIsActive("Y");

			Map<String, String> filelocation = Util.uploadImageFile(imgFile);
			product.setImgLocation(filelocation.get("location"));
			product.setImgName(filelocation.get("filename"));
			product.setCreatedBy(productMasterRequest.getCreatedBy());
			logger.info("Product Detail {}" + product);
			return productMasterRepository.save(product);
		} else {
			throw new GlobalException("Product Details Already Avaliable");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public MmProductMaster updateProduct(String prodCode, MmProductMaster productMasterRequest, MultipartFile imgFile) {
		MmProductMaster product = productMasterRepository.findByProdCodeAndIsActive(prodCode, "Y");
		if (null == product) {
			throw new ResourceNotFoundException("Product Details Not Found");
		} else {
			product.setProdCategoryId(productMasterRequest.getProdCategoryId());
			product.setProdTypeId(productMasterRequest.getProdTypeId());
			product.setProdCode(productMasterRequest.getProdCode());
			product.setProdName(productMasterRequest.getProdName());
			product.setDescription(productMasterRequest.getDescription());
			product.setLength(productMasterRequest.getLength());
			product.setDiaMM(productMasterRequest.getDiaMM());
			product.setDriveSize(productMasterRequest.getDriveSize());
			product.setUom(productMasterRequest.getUom());
			product.setMinQty(productMasterRequest.getMinQty());
			product.setMaxQty(productMasterRequest.getMaxQty());
			product.setTotalQty(productMasterRequest.getTotalQty());
			product.setIsActive("Y");

			Map<String, String> filelocation = Util.uploadImageFile(imgFile);
			product.setImgLocation(filelocation.get("location"));
			product.setImgName(filelocation.get("filename"));
			product.setUpdatedBy(productMasterRequest.getUpdatedBy());
			logger.info("Product Detail {}" + product);
			return productMasterRepository.save(product);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteProduct(String prodCode) {
		boolean status = false;
		MmProductMaster product = productMasterRepository.findByProdCodeAndIsActive(prodCode, "Y");
		if (null == product) {
			throw new ResourceNotFoundException("Product Details Not Found");
		} else {
			logger.info("Product Details {}" + product);
			product.setIsActive("N");
			productMasterRepository.save(product);
			status = true;
		}
		return status;
	}

	public List<MmProductMaster> getAllProducts() {
		List<MmProductMaster> productList = productMasterRepository.findAll();
		if (null == productList || productList.isEmpty()) {
			throw new ResourceNotFoundException("Product List Not Found");
		} else {
			return productList;
		}
	}
}
