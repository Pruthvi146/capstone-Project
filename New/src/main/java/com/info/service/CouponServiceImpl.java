package com.info.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.info.model.Coupon;
import com.info.dao.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public List<Coupon> getAllProducts() {
		// TODO Auto-generated method stub
		return couponRepository.findAll();
	}

	@Override
	public void saveCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
		
		this.couponRepository.save(coupon);
	}

	@Override
	public Coupon getCouponById(long id) {
		// TODO Auto-generated method stub
		Optional<Coupon> optional = couponRepository.findById(id);
		Coupon coupon = null;
		if (optional.isPresent()) {
			coupon = optional.get();
		} else {
			throw new RuntimeException(" Coupon not found for id :: " + id);
		}
		return coupon;
	}

	@Override
	public void deleteCouponById(long id) {
		// TODO Auto-generated method stub
		this.couponRepository.deleteById(id);
	}

	@Override
	public Page<Coupon> findPaginated1(int pageNo1, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo1 - 1, pageSize, sort);
		return this.couponRepository.findAll(pageable);
	}
	
}
