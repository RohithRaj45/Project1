package com.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public ResponseEntity<Iterable<Product>>getAllProducts() throws Exception {
		logger.info("Searching all products");
		Iterable<Product> products = productService.getProducts();
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		logger.info("Fetched all products Successfully...!");
		return response;
	}
	@RequestMapping("/subproducts")
	public ResponseEntity<Iterable<SubscribedProduct>>getAllsubProducts() throws Exception {
		logger.info("Searching subscribed products");
		Iterable<SubscribedProduct> products = productService.getSProducts();
		ResponseEntity<Iterable<SubscribedProduct>> response = new ResponseEntity<Iterable<SubscribedProduct>>(products,HttpStatus.OK);
		logger.info("Found subscribed products Successfully...!");
		return response;
	}
	
	@RequestMapping("/products/{category}")
	public ResponseEntity<Iterable<Product>> getProductsbyCategory(@PathVariable String category) throws Exception {
		logger.info("Searching products categorically");
		Iterable<Product> products = productService.getProductsbyCategory(category);
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		logger.info("Fetched products categorically...!");
		return response;
	}
	@RequestMapping("/products/{productname}/{category}")
	public ResponseEntity<Iterable<Product>> fetchproducts(@PathVariable String productname,@PathVariable String category) throws Exception {
		logger.info("Searching products through product Name and category");
		Iterable<Product> products = productService.fetchProducts(productname,category);
		ResponseEntity<Iterable<Product>> response = new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
		logger.info("Fetched products through product Name and category...!");
		return response;
	}
	
	@RequestMapping(value = "/products/seller/{productId}")
	public ResponseEntity<String> getSellerId(@PathVariable String productId) throws Exception {
		logger.info("Getting sellerid");
		String product = productService.getSellerId(productId);
		String successMessage = "Seller Id is : "+product;
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("Fetched sellerId and "+successMessage);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public ResponseEntity<String> addProduct(@RequestBody Product product) throws Exception {
		logger.info("Ready to Add Product");
		productService.addProduct(product);
		String successMessage = "Product added Successfully with ID:"+product.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("Added Product...!!");
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/subproducts")
	public ResponseEntity<String> addProducttoWish(@RequestBody SubscribedProduct product) throws Exception {
		logger.info("Ready to Add Subscribed Product");
		productService.addProducttoWish(product);
		String successMessage = "Product added Successfully with ID:"+product.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info(" Added Product into subscribed product Successfully...!!!");
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{productId}")
	public ResponseEntity<String> updateProductStock(@RequestBody ProductDTO product, @PathVariable String productId) throws Exception {
		logger.info("Ready to update Product Stock");
		Product products=productService.updateProduct(product, productId);
		String successMessage = "Product Stock Updated Successfully with ID:"+products.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("updated Product Stock Successfully...!!! ");
		return response;	
	}
	//ENTER BUYERID IN PLACE OF PRODUCTID
	@RequestMapping(method=RequestMethod.PUT, value="/subproducts/{productId}")
	public ResponseEntity<String> updateSProduct(@RequestBody SubscribedProductDTO product, @PathVariable String productId) throws Exception {
		logger.info("Ready to update Subscribed Product Quantity");
		SubscribedProduct products=productService.updateSProduct(product, productId);
		String successMessage = "Product Quantity Updated Successfully with ID:"+products.getProductId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("Updated Subscribed Product Quantity Successfully...!!!");
		return response;	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productId) throws Exception {
		logger.info("!!!...Ready to Delete Product...!!!");
		productService.deleteProduct(productId);
		String successMessage = "Product Deleted Successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("!!!...Deleted Product...!!!");
		return response;	
}
	//ENTER BUYERID IN PLACE OF PRODUCTID
	@RequestMapping(method=RequestMethod.DELETE, value="/subproducts/{productId}")
	public ResponseEntity<String> deleteSProduct(@PathVariable String productId) throws Exception {
		logger.info("!!!...Ready to Remove Subscribed Product...!!!");
		productService.deleteSProduct(productId);
		String successMessage = "Subscribed Product Deleted Successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage,HttpStatus.OK);
		logger.info("!!!...Removed Subscribed Product...!!! ");
		return response;
}
}