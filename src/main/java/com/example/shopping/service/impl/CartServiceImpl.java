package com.example.shopping.service.impl;

import com.example.shopping.repository.CartDetailRepository;
import com.example.shopping.repository.CartItemRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
CartDetailRepository cartDetailRepository;
CartItemRepository cartItemRepository;
ProductRepository productRepository;

}
