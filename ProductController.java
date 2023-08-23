package org.jsp.merchantproduct.controller;

import java.util.List;

import org.jsp.merchantproduct.dto.Product;
import org.jsp.merchantproduct.dto.ResponseStructure;
import org.jsp.merchantproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService pservice;
	@PostMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product p , @PathVariable int id) {
		return pservice.saveProduct(p, id);
	}
	@GetMapping("/products/userid/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByUserId(@PathVariable int id) {
		return pservice.findProductByUserId(id);
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id) {
		return pservice.deleteProduct(id);
	}
	@GetMapping("/products/brand")
	public ResponseEntity<ResponseStructure<Product>> findByBrand(@RequestParam String brand) {
		return pservice.findByBrand(brand);
	}
	
	@GetMapping("/products/category")
	public ResponseEntity<ResponseStructure<Product>> findByCategory(@RequestParam String category) {
		return pservice.findByCategory(category);
	}

}
