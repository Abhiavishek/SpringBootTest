package org.jsp.merchantproduct.dao;


import java.util.List;
import java.util.Optional;

import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;
	
	public Merchant saveMerchant(Merchant u) {
		return repository.save(u);
	}
	
	public Merchant updateMerchant(Merchant u) {
		return repository.save(u);
	}
	
	public Optional<Merchant>findById(int id){
		return repository.findById(id);
	}
	
	
	public Optional<Merchant>verifyMerchant(long phone, String password){
		return repository.verifyMerchant(phone, password);
	}
	

}

