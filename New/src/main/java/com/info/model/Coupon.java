package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long cid;
	
	@Column(name = "coupon_name")
	private String couponName;
	
	@Column(name = "coupon_discount")
	private int couponDiscount;
	
	@Column(name = "category_id")
	private String categoryId;
	
	@Column(name = "coupon_description")
	private String couponDis;
	
	@Column(name = "event_Id")
	private long eventId;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(int couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCouponDis() {
		return couponDis;
	}

	public void setCouponDis(String couponDis) {
		this.couponDis = couponDis;
	}
	
	
	

}
