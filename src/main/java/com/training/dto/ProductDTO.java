package com.training.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductDTO {
		
		@Id
		@Column(name = "prodid")
		private String productId;
		@NotNull(message = "{Product.name.absent}")
		@Pattern(regexp ="(?=^[A-Za-z])(?=.*[A-Za-z]$)(?=[ A-Za-z]).{2,100}", message = "{Product.name.invalid}")
		private String productname;
		@NotNull(message = "{Product.price.absent}")
		@Min(value = 10, message = "Price should be minimum of 10")
		private Integer price;
		@NotNull(message = "{Product.stock.absent}")
		@Min(value = 10, message = "stock should be minimum of 10")
	    private Integer stock;
		@NotNull(message = "{Product.description.absent}")
		@Pattern(regexp ="^.{1,500}$", message = "{Product.description.invalid}")
		private String description;
		@NotNull(message = "{Product.sellerid.absent}")
	    private String sellerid;
		private String category;
		private String subcategory;
		private Double productrating;
		
		public ProductDTO()
		{
			
		}
		
		public ProductDTO(String productId, String poductname, Integer price, Integer stock, String description,
				String sellerid, String category, String subcategory, Double productrating) {
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

		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
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
		public String getSellerid() {
			return sellerid;
		}
		public void setSellerid(String sellerid) {
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
		public Double getProductrating() {
			return productrating;
		}
		public void setProductrating(Double productrating) {
			this.productrating = productrating;
		}
	}

