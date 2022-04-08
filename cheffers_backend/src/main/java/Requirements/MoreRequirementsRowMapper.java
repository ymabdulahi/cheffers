package Requirements;

import Recipes.Cuisine;
import Recipes.MealType;
import Recipes.Spice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoreRequirementsRowMapper implements RowMapper<MoreRequirements> {
    @Override
    public MoreRequirements mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new MoreRequirements(


                resultSet.getString("rname"),
                resultSet.getString("iname"),
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
