package org.jsp.merchantproduct.controller;

import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.ResponseStructure;
import org.jsp.merchantproduct.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
	@Autowired
	private MerchantService mservice;
	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant m) {
		return mservice.saveMerchant(m);
	}
	
	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant m) {
		return mservice.updateMerchant(m);
	}
	@GetMapping("/merchants/verifyMerchant")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone, @RequestParam String password) {
		return mservice.verifyMerchant(phone, password);
	}


}
