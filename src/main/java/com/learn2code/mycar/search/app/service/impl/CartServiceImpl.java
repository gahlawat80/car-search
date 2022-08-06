package com.learn2code.mycar.search.app.service.impl;

import com.learn2code.mycar.search.app.dto.CheckoutRequest;
import com.learn2code.mycar.search.app.dto.Order;
import com.learn2code.mycar.search.app.entity.Cart;
import com.learn2code.mycar.search.app.repository.CartRepository;
import com.learn2code.mycar.search.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int saveToCart(Cart cart) {
        int res = cartRepository.saveCart(cart);
        return res;
    }

    @Override
    public List<Cart> getCartItems() {
        return cartRepository.fetchAllCartItems();
    }

    @Override
    public Order checkoutItem(CheckoutRequest checkoutRequest) {
        Order orderResponse = restTemplate.postForObject("http://localhost:8081/api/v1/payment",checkoutRequest,Order.class);
        if(orderResponse !=null){
            return orderResponse;
        }
        return null;
    }
}
