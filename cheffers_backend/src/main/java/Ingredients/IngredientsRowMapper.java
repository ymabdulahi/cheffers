package Ingredients;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientsRowMapper implements RowMapper<Ingredients> {

    @Override
    public Ingredients mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredients(
                resultSet.getInt("id"),
                resultSet.getString("iname"),
                resultSet.getString("allergy_category")
        );
    }
}
