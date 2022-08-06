package com.learn2code.mycar.search.app.repository.rowmapper;

import com.learn2code.mycar.search.app.entity.Cart;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {


    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getInt("id"));
        cart.setImagePath(rs.getString("image_path"));
        cart.setCarDesc(rs.getString("car_desc"));
        cart.setMiles(rs.getLong("miles"));
        cart.setBasePrice(rs.getDouble("base_price"));
        cart.setTaxRate(rs.getDouble("tax_rate"));
        cart.setTotalTax(rs.getDouble("total_tax"));
        cart.setTotalPrice(rs.getDouble("total_price"));
        cart.setDealerFee(rs.getInt("dealer_fee"));
        return cart;
    }
}
