package com.learn2code.mycar.search.app.repository.rowmapper;

import com.learn2code.mycar.search.app.entity.CarDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDetailsRowMapper implements RowMapper<CarDetails> {
    @Override
    public CarDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarDetails carDetails = CarDetails.builder()
                .id(rs.getInt("id"))
                .modelYear(rs.getInt("model_year"))
                .brandId(rs.getInt("brand_id"))
                .modelId(rs.getInt("model_id"))
                .price(rs.getDouble("car_price"))
                .miles(rs.getLong("miles"))
                .location(rs.getString("car_location"))
                .dealType(rs.getString("car_deal_type"))
                .seller(rs.getString("car_seller"))
                .sellerPhone(rs.getString("seller_phone"))
                .build();
        return carDetails;
    }
}
