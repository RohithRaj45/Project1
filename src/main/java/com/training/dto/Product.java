package com.training.dto;

public class Product {

		private Integer productId;
		private String productname;
		private Integer price;
	    private Integer stock;
		private String description;
	    private Integer sellerid;
		private String category;
		private String subcategory;
		private Integer productrating;
		
		public Product()
		{
			
		}
		
		public Product(Integer productId, String poductname, Integer price, Integer stock, String description,
				Integer sellerid, String category, String subcategory, Integer productrating) {
			super();
			this.productId = productId;
			this.productname = poductname;
			this.price = price;
			this.stock = stock;
			this.description = description;
			this.sellerid = sellerid;
			this.category = category;
			this.subcategory = subcategory;
			this.productrating = productrating;
		}

		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getSellerid() {
			return sellerid;
		}
		public void setSellerid(Integer sellerid) {
			this.sellerid = sellerid;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSubcategory() {
			return subcategory;
		}
		public void setSubcategory(String subcategory) {
			this.subcategory = subcategory;
		}
		public Integer getProductrating() {
			return productrating;
		}
		public void setProductrating(Integer productrating) {
			this.productrating = productrating;
		}
	}

