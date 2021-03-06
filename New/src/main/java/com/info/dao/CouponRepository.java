package com.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
