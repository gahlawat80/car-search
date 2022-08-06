package com.learn2code.mycar.search.app.repository.rowmapper;

import com.learn2code.mycar.search.app.entity.CarMaker;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMakerRowMapper implements RowMapper<CarMaker> {
    @Override
    public CarMaker mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarMaker brand = new CarMaker();
        brand.setId(rs.getInt("id"));
        brand.setManufacturerName(rs.getString("name"));
        return brand;
    }
}
