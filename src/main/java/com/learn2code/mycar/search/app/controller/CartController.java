package com.learn2code.mycar.search.app.controller;

import com.learn2code.mycar.search.app.dto.CartRequest;
import com.learn2code.mycar.search.app.dto.CheckoutRequest;
import com.learn2code.mycar.search.app.dto.Order;
import com.learn2code.mycar.search.app.entity.CarDetails;
import com.learn2code.mycar.search.app.entity.Cart;
import com.learn2code.mycar.search.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart-details")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> saveCart(@RequestBody CartRequest cartRequest){
        Cart cart = Cart.builder()
                .carDesc(cartRequest.getModelYear()+" "+cartRequest.getBrand()+" "+cartRequest.getModel())
                .miles(cartRequest.getMiles())
                .basePrice(cartRequest.getBasePrice())
                .taxRate(6.5)
                .totalTax(0.065*cartRequest.getBasePrice())
                .totalPrice(cartRequest.getBasePrice()+(0.065*cartRequest.getBasePrice()))
                .dealerFee(200)
                .build();
        int recordsInserted = cartService.saveToCart(cart);
        if(recordsInserted>0){
            return ResponseEntity.status(HttpStatus.CREATED).body("Record inserted successfully into DB!");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("NO record inserted into DB!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Cart>> displayCartItems(){
        List<Cart> cartList = cartService.getCartItems();
        return new ResponseEntity<>(cartList,HttpStatus.OK);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> buyVehicle(@RequestBody CheckoutRequest checkoutRequest){
        Order order = cartService.checkoutItem(checkoutRequest);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
}
