package com.materialmanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.materialmanagement.DTO.Order;
import com.materialmanagement.DTO.OrderDetails;
import com.materialmanagement.DTO.OrderSummary;
import com.materialmanagement.Response.Response;
import com.materialmanagement.ServiceImpl.OrderService;
import com.materialmanagement.ServiceImpl.ProductReqHeaderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@Autowired
	ProductReqHeaderService productReqHeaderService;

	@PostMapping("/orderSummary")
	public ResponseEntity<Response> orderSummary(@RequestBody List<Integer> prodMasterId) {
		List<OrderSummary> orderSummary = orderService.getOrderSummary(prodMasterId);
		logger.info("Order Summary{} " + orderSummary);
		if (null != orderSummary && !orderSummary.isEmpty()) {
			return new ResponseEntity<>(new Response(true, "Order Summary Fetched", orderSummary), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Fetch Order Summary", orderSummary),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/placeOrder")
	public ResponseEntity<Response> placeOrder(@Valid @RequestBody Order order) {
		logger.info("Place Order Request Parameter " + order);
		Response response;
		response = orderService.placeOrder(order);
		if (null != response) {
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Save Product Details", response),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<Response> getOrderDetailsByHeaderId(@PathVariable("id") int prodReqHdrId) {
		List<OrderDetails> orderDetails = orderService.getOrderDetailsByHeaderID(prodReqHdrId);
		logger.info("Order Details{} " + orderDetails);
		if (null != orderDetails && !orderDetails.isEmpty()) {
			return new ResponseEntity<>(new Response(true, "Order Details Fetched", orderDetails), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Fetch Order Details", orderDetails),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getBySequenceType")
	public ResponseEntity<?> getBySequenceType() {
		String seqnumber = productReqHeaderService.getRequestNumber();
		return new ResponseEntity<Object>(seqnumber, HttpStatus.OK);
	}

}
