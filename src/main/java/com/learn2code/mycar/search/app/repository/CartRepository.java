package com.learn2code.mycar.search.app.repository;

import com.learn2code.mycar.search.app.entity.Cart;
import com.learn2code.mycar.search.app.repository.rowmapper.CartRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveCart(Cart cart) {
        String sql = "INSERT INTO cart(image_path,car_desc,miles,base_price,tax_rate,total_tax,total_price,dealer_fee) VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,"C:\\Personal\\Pardeep\\Java Path\\RealProjects\\car.jfif",cart.getCarDesc(),cart.getMiles(), cart.getBasePrice(),cart.getTaxRate(),cart.getTotalTax(),cart.getTotalPrice(),cart.getDealerFee());
    }

    public List<Cart> fetchAllCartItems() {
        String sql = "SELECT * FROM cart";
        return jdbcTemplate.query(sql,new CartRowMapper());
    }
}
