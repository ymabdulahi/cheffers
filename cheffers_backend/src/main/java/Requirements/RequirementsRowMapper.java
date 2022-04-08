package Requirements;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequirementsRowMapper implements RowMapper(Requirements){
    @Override
    public Requirements mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Requirements(

                resultSet.getInt("id"),
                resultSet.getInt("recipe_id"),
                resultSet.getInt("ingredient_id")
        );
    }
