package com.example.shopping.repository;

import com.example.shopping.entity.Cart.CartItem;
import com.example.shopping.entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem,Integer> {
}