package org.jsp.merchantproduct.service;


import java.util.List;
import java.util.Optional;

import org.jsp.merchantproduct.dao.MerchantDao;
import org.jsp.merchantproduct.dao.ProductDao;
import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.Product;
import org.jsp.merchantproduct.dto.ResponseStructure;
import org.jsp.merchantproduct.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
	private MerchantDao mdao;
    @Autowired
    private ProductDao pdao;
    
    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int id){
    	Optional<Merchant> recmer = mdao.findById(id);
    	ResponseStructure<Product> structure = new ResponseStructure<>();
    	if(recmer.isPresent()) {
    		 Merchant m = recmer.get();
    		m.getProduct().add(product);
    	    product.setMerchant(m);
    	    mdao.updateMerchant(m);
    	    pdao.saveProduct(product);
    	    structure.setData(product);
    	    structure.setMessage("Product added with Id "+ product.getId());
    	    structure.setStatusCode(HttpStatus.CREATED.value());
    	    return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
    	}
    	throw new IdNotFoundException();
    }
    
  
    
    public ResponseEntity<ResponseStructure<Product>> findById(int id){
    	ResponseStructure<Product> structure = new ResponseStructure<>();
    	Optional<Product> recProduct = pdao.findById(id);
    	if(recProduct.isPresent()) {
    		structure.setData(recProduct.get());
    		structure.setMessage("Product Found");
    		structure.setStatusCode(HttpStatus.OK.value());
    	    return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
    	}
    	throw new IdNotFoundException();
    }
    
    public ResponseEntity<ResponseStructure<String>>deleteProduct(int id){
    	ResponseStructure<String> structure = new ResponseStructure<>();
    	Optional<Product> recProduct = pdao.findById(id);
    	if(recProduct.isPresent()) {
    		pdao.deleteProduct(id);
    		structure.setData("product deleted");
    		structure.setMessage("Product Found");
    		structure.setStatusCode(HttpStatus.OK.value());
    	    return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
    	}
    	throw new IdNotFoundException();
    }
    
    public ResponseEntity<ResponseStructure<List<Product>>> findProductByUserId(int id){
    	ResponseStructure<List<Product>> structure = new ResponseStructure<>();
    	structure.setData(pdao.findProductByUserId(id));
    	structure.setMessage("Products found for userId");
    	structure.setStatusCode(HttpStatus.OK.value());
    	return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
    }
    
    public ResponseEntity<ResponseStructure<Product>> findByBrand(String Brand){
    	ResponseStructure<Product> structure = new ResponseStructure<>();
    	structure.setData(pdao.findByBrand(Brand));
    	structure.setMessage("Products found for Brand");
    	structure.setStatusCode(HttpStatus.OK.value());
    	return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
    }
    
    public ResponseEntity<ResponseStructure<Product>> findByCategory(String Category){
    	ResponseStructure<Product> structure = new ResponseStructure<>();
    	structure.setData(pdao.findByCategory(Category));
    	structure.setMessage("Products found for Brand");
    	structure.setStatusCode(HttpStatus.OK.value());
    	return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
    }
}

