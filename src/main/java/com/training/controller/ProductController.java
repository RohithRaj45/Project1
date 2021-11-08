package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.ProductDTO;
import com.training.dto.SubscribedProductDTO;
import com.training.entity.Product;
import com.training.entity.SubscribedProduct;
import com.training.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public ResponseEntity<Iterable<Product>>getAllProducts() throws Exception {
		Iterable<Product> products = productService.getProducts();
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		return response;
	}
	@RequestMapping("/subproducts")
	public ResponseEntity<Iterable<SubscribedProduct>>getAllsubProducts() throws Exception {
		Iterable<SubscribedProduct> products = productService.getSProducts();
		ResponseEntity<Iterable<SubscribedProduct>> response = new ResponseEntity<Iterable<SubscribedProduct>>(products,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping("/products/{category}")
	public ResponseEntity<Iterable<Product>> getProductsbyCategory(@PathVariable String category) throws Exception {
		Iterable<Product> products = productService.getProductsbyCategory(category);
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		return response;
	}
	@RequestMapping("/products/{productname}/{category}")
	public ResponseEntity<Iterable<Product>> fetchproducts(@PathVariable String productname,@PathVariable String category) throws Exception {
		Iterable<Product> products = productService.fetchProducts(productname,category);
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public ResponseEntity<String> addProduct(@RequestBody Product product) throws Exception {
		productService.addProduct(product);
		String successMessage = "Product added Successfully with ID:"+product.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/subproducts")
	public ResponseEntity<String> addProducttoWish(@RequestBody SubscribedProduct product) throws Exception {
		productService.addProducttoWish(product);
		String successMessage = "Product added Successfully with ID:"+product.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{productId}")
	public ResponseEntity<String> updateProductStock(@RequestBody ProductDTO product, @PathVariable String productId) throws Exception {
		Product products=productService.updateProduct(product, productId);
		String successMessage = "Product Stock Updated Successfully with ID:"+products.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;	
	}
	//ENTER BUYERID IN PLACE OF PRODUCTID
	@RequestMapping(method=RequestMethod.PUT, value="/subproducts/{productId}")
	public ResponseEntity<String> updateSProduct(@RequestBody SubscribedProductDTO product, @PathVariable String productId) throws Exception {
		SubscribedProduct products=productService.updateSProduct(product, productId);
		String successMessage = "Product Stock Updated Successfully with ID:"+products.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productId) throws Exception {
		productService.deleteProduct(productId);
		String successMessage = "Product Deleted Successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;	
}
	//ENTER BUYERID IN PLACE OF PRODUCTID
	@RequestMapping(method=RequestMethod.DELETE, value="/subproducts/{productId}")
	public ResponseEntity<String> deleteSProduct(@PathVariable String productId) throws Exception {
		productService.deleteSProduct(productId);
		String successMessage = "Subscribed Product Deleted Successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		return response;
}
}