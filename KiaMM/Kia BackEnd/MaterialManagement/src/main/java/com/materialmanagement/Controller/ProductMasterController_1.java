package com.materialmanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.materialmanagement.DAO.EntityDataRepository;
import com.materialmanagement.DAO.ProductMasterRepository;
import com.materialmanagement.DTO.ProductResponse;
import com.materialmanagement.Exception.ResourceNotFoundException;
import com.materialmanagement.Model.MmProductMaster;
import com.materialmanagement.Response.Response;
import com.materialmanagement.Service.ProductMasterService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/productMaster")
public class ProductMasterController {

	private static final Logger logger = LoggerFactory.getLogger(ProductMasterController.class);

	@Autowired
	private ProductMasterService productMasterService;

	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Autowired
	private EntityDataRepository entityDataRepository;

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ResponseEntity<Response> addProduct(
			@Valid @ModelAttribute(value = "productMasterRequest") MmProductMaster productMasterRequest,
			@RequestParam(value = "imgFile") MultipartFile imgFile) {
		logger.info("Request Parameter " + productMasterRequest);
		MmProductMaster product = productMasterService.addProduct(productMasterRequest, imgFile);
		if (null != product) {
			return new ResponseEntity<>(new Response(true, "Product Details Saved", product), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Save Product Details", product),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateproduct/{prodCode}", method = RequestMethod.PUT)
	public ResponseEntity<Response> updateProduct(
			@Valid @ModelAttribute(value = "productMasterRequest") MmProductMaster productMasterRequest,
			@RequestParam(value = "imgFile") MultipartFile imgFile, @PathVariable(value = "prodCode") String prodCode) {
		logger.info("Request Parameter And productCode {}" + productMasterRequest + " " + prodCode);
		if ((null != prodCode && !prodCode.isEmpty()) && !prodCode.isBlank()) {
			MmProductMaster product = productMasterService.updateProduct(prodCode, productMasterRequest, imgFile);
			if (null != product) {
				return new ResponseEntity<>(new Response(true, "Product Details Updated", product), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new Response(false, "Unable To Process Update Request", product),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(new Response(false, "Invalid ProductCode", null), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteproduct/{prodCode}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteProduct(@Valid @PathVariable(value = "prodCode") String prodCode) {
		logger.info("productCode {}" + prodCode);
		if ((null != prodCode && !prodCode.isEmpty()) && !prodCode.isBlank()) {
			boolean status = productMasterService.deleteProduct(prodCode);
			if (status) {
				return new ResponseEntity<>(new Response(true, "Product Details Removed", null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new Response(false, "Unable To Process Delete Request", null),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(new Response(false, "Invalid ProductCode", null), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<Response> getAllProducts() {
		List<MmProductMaster> productList = productMasterService.getAllProducts();
		logger.info("productList{} " + productList);
		if (null != productList && !productList.isEmpty()) {
			return new ResponseEntity<>(new Response(true, "Product List Fetched", productList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Fetch Product List", productList),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("products/byPartNo-or-byProductName-withFlag") // FETCHING DATA ACCORDING TO PART NUMBER or PRODUCT NAME
																// AND ALSO IS ACTIVE ATTRIBUTE
	private Page<MmProductMaster> getProductByPartNoOrProductName(@RequestParam String prod_name,
			@RequestParam String part_nbr, @RequestParam String is_active) {
		if (is_active == null || is_active.isEmpty()) {
			is_active = "Y";
			System.out.println("Setting default value Flag is_active  " + is_active);
		}
		if (prod_name == null || prod_name.isEmpty()) {
			prod_name = "";
		}
		if (part_nbr == null || part_nbr.isEmpty()) {
			part_nbr = "";
		}
		Page<MmProductMaster> prd = productMasterRepository.getProductByPartNoOrProductName(prod_name, part_nbr,
				is_active, PageRequest.of(0, 4));
		if (prd.isEmpty()) {
			throw new ResourceNotFoundException("Invalid part name or product name and not available :" + prd);
		} else {
			return prd;
		}
	}

	@GetMapping("/join_data/{keyword}") // DROP DOWN DATA RETRIEVAL
	public List<ProductResponse> join_Data(@PathVariable String keyword) {
		return entityDataRepository.join_Data(keyword);
	}

	@GetMapping("/search-products-with-category") // DROP DOWN DATA RETRIEVAL
	public List<ProductResponse> searchProductWithCategory(@RequestParam String category,
			@RequestParam String prod_name) {
		return entityDataRepository.searchProductWithCategory(category, prod_name);
	}

}
