package com.materialmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.materialmanagement.DTO.Myorders;
import com.materialmanagement.ServiceImpl.ProductReqHeaderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/MmProdReqHeaderEntity")
public class ProdReqHeaderController {

	@Autowired
	ProductReqHeaderService productReqHeaderService;
	
	@GetMapping(value = "/mmprrprocess", produces = "application/json")
	public ResponseEntity<?> findpendingorders() {
		List<Myorders> headerwithdetails = productReqHeaderService.findallPendingorders();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(headerwithdetails);
	}

	@GetMapping(value = "/mmprrecived", produces = "application/json")
	public ResponseEntity<?> findRecivedOrders() {
		List<Myorders> headerwithdetails = productReqHeaderService.findallRecivedorders();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(headerwithdetails);
	}

	@GetMapping(value = "/mmprrrejected", produces = "application/json")
	public ResponseEntity<?> findRejectedOrders() {
		List<Myorders> headerwithdetails = productReqHeaderService.findallRejectedorders();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(headerwithdetails);
	}
}
