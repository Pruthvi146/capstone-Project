package com.info.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.info.model.Coupon;


public interface CouponService {
	List<Coupon> getAllProducts();
	void saveCoupon(Coupon coupon);
	Coupon getCouponById(long id);
	void deleteCouponById(long id);
	Page<Coupon> findPaginated1(int pageNo, int pageSize, String sortField, String sortDirection);
	}
