package com.learn2code.mycar.search.app.repository.rowmapper;

import com.learn2code.mycar.search.app.entity.CarModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarModelRowMapper implements RowMapper<CarModel> {
    @Override
    public CarModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarModel model = CarModel.builder()
                .id(rs.getInt("id"))
                .modelName(rs.getString("model"))
                .brandId(rs.getInt("brand_id"))
                .build();
        return model;
    }
}
