package com.example.shopping.repository;

import com.example.shopping.entity.Cart.CartDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail,Integer>  {
}
