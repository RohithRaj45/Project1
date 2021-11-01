package com.training.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Product;
import com.training.repository.ProductRepository;

@Service(value="productService")
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts() throws Exception
	{
		Iterable<Product> products = productRepository.findAll();
		if(products.iterator().hasNext())
		{
			return products;
	}
		else
		{
			throw new Exception("No Products Available!!");
		}
	}
	public Iterable<Product> getProductsbyCategory(String category) throws Exception
	{
		Iterable<Product> products = productRepository.findDistinctBycategory(category);
		if(products.iterator().hasNext())
		{
			return products;
	}
		else
		{
			throw new Exception("No Products Available!!");
		}
	}
	public Iterable<Product> fetchProducts(String productname, String category) throws Exception
	{
		Iterable<Product> products = productRepository.fetchProducts(productname, category);
		if(products.iterator().hasNext())
		{
			return products;
	}
		else
		{
			throw new Exception("No Products Available!!");
		}
	}
	public void addProduct(Product product) throws Exception
	{
		Product products = productRepository.findById(product.getProductId()).orElse(null);
		if(products!=null)
		{
			throw new Exception("Product Already Exists");
		}
		productRepository.save(product);
	}
	
	public Product updateProduct(Product product,Integer productId) throws Exception
	{
		Product existingproduct=productRepository.findById(productId).orElse(null);
		if(existingproduct!=null)
		{
			existingproduct.setStock(product.getStock());
				return productRepository.save(existingproduct);
		}
		else {
			throw new Exception("No Product Found");
		}
		
	}
	public void deleteProduct(Integer productId) throws Exception
	{
		Product product = productRepository.findById(productId).orElse(null);
		if(product==null)
		{
			throw new Exception("No Products available!!");
		}
		productRepository.deleteById(productId);
	}
}
