package org.jsp.merchantproduct.service;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import org.jsp.merchantproduct.dao.MerchantDao;
import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.ResponseStructure;
import org.jsp.merchantproduct.exception.IdNotFoundException;
import org.jsp.merchantproduct.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class MerchantService {
	
	@Autowired
	private MerchantDao dao;
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant m) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(dao.saveMerchant(m));
		structure.setMessage("Merchant saved with Id: "+m.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant m){
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(dao.updateMerchant(m));
		structure.setMessage("Merchant Updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> findById(int id){
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.findById(id);
		if(recMerchant.isPresent()) {
			structure.setMessage("Merchant Found");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}

	
		
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone, String password){
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant>recMerchant = dao.verifyMerchant(phone, password);
		if(recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		else {
		    throw new InvalidCredentialException();
		}
	}
	
		

}