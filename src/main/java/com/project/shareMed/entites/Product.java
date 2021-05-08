package com.project.shareMed.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long productId;
	private String productName;
	private String productDesc;
	private String productImageUrl;
	private String tags;
	private float donationRecived;
	private int doationCount;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String productName, String productDesc, String productImageUrl, String tags,
			float donationRecived, int doationCount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productImageUrl = productImageUrl;
		this.tags = tags;
		this.donationRecived = donationRecived;
		this.doationCount = doationCount;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public float getDonationRecived() {
		return donationRecived;
	}

	public void setDonationRecived(float donationRecived) {
		this.donationRecived = donationRecived;
	}

	public int getDoationCount() {
		return doationCount;
	}

	public void setDoationCount(int doationCount) {
		this.doationCount = doationCount;
	}
	
	
	
}
