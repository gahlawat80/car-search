package com.learn2code.mycar.search.app.service;

import com.learn2code.mycar.search.app.dto.CheckoutRequest;
import com.learn2code.mycar.search.app.dto.Order;
import com.learn2code.mycar.search.app.entity.Cart;

import java.util.List;

public interface CartService {
    int saveToCart(Cart cart);

    List<Cart> getCartItems();

    Order checkoutItem(CheckoutRequest checkoutRequest);
}
