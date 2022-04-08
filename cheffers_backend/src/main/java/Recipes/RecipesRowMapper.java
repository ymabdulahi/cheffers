package Recipes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipesRowMapper implements RowMapper<Recipes> {
    @Override
    public Recipes mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return new Recipes(
                resultSet.getInt("id"),
                resultSet.getString("rname"),
                Cuisine.valueOf(resultSet.getString("cuisine")),
                resultSet.getBoolean("vegetarian"),
                resultSet.getBoolean("vegan"),
                resultSet.getBoolean("meat_only"),
                resultSet.getBoolean("pescatarian"),
                MealType.valueOf(resultSet.getString("meal_type")),
                Spice.valueOf(resultSet.getString("spice")),
                resultSet.getInt("cooking_time_mins"),
                resultSet.getString("instructions")
        );

    }
}
