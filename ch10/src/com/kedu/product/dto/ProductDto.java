package com.kedu.product.dto;

public class ProductDto {
	private Integer code;
	private String name;
	private Integer price;
	private String product_img;
	private String product_img_orn;
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_img_orn() {
		return product_img_orn;
	}

	public void setProduct_img_orn(String product_img_orn) {
		this.product_img_orn = product_img_orn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", name=" + name + ", price=" + price + ", product_img=" + product_img
				+ ", product_img_orn=" + product_img_orn + ", description=" + description + "]";
	}

}
