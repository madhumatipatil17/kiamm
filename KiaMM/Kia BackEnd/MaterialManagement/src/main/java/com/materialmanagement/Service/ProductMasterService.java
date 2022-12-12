package com.materialmanagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.materialmanagement.Model.MmProductMaster;

@Service
public interface ProductMasterService {

	public MmProductMaster addProduct(MmProductMaster productMasterRequest, MultipartFile imgFile);

	public MmProductMaster updateProduct(String prodCode, MmProductMaster productMasterRequest, MultipartFile imgFile);

	public boolean deleteProduct(String prodCode);

	List<MmProductMaster> getAllProducts();
}
