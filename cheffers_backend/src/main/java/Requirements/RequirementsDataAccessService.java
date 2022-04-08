package Requirements;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RequirementsDataAccessService implements RequirementsDAO{

    private final JdbcTemplate jdbcTemplate;

    public RequirementsDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MoreRequirements> selectMoreRequirements(User user) {
        String sql = """
                 WITH cte AS (
                   SELECT id, recipes.recipe_name, ingredients_name, allergy, recipes.cuisine, recipes.vegetarian, recipes.vegan, recipes.meat_only, recipes.pescatarian, recipes.meal_type, recipes.spice, recipes.cooking_time_mins, recipes.instructions
                    FROM recipes
                    LEFT JOIN  (
                       SELECT recipes_ingredients.recipe_id AS id, array_agg(ingredients.iname) AS iname, array_agg(ingredients.allergy_category) AS allergy

                       FROM   recipes_ingredients
                       JOIN   ingredients ON recipes_ingredients.ingredient_id = ingredients.id
                       GROUP  BY recipes_ingredients.recipe_id
                       ) ingredients USING (id)
                       )
                    SELECT cte.recipes_name, cte.ingredients_name, cte.cuisine, cte.vegetarian, cte.vegan, cte.meat_only, cte.pescatarian, cte.meal_type, cte.spice, cte.cooking_time_mins, cte.instructions
                    FROM cte
                    WHERE NOT cte.allergy @> string_to_array(?, '') AND (cte.cooking_time_mins < ?);
                """;

        return jdbcTemplate.query(sql, new MoreRequirementsRowMapper(), user.getAllergy(), user.getCookingTime());

    }

    @Override
    public int insertRequirements(Requirements requirements) {
        String sql = """
                INSERT INTO recipes_ingredients(recipe_id, ingredient_id)
                VALUES (?, ?);
                """;

        return jdbcTemplate.update(
                sql,
                requirements.getRecipes_id(),
                requirements.getIngredients_id()
        );
    }

    @Override
    public int deleteRequirements(int id) {
        String sql = """
                DELETE FROM recipes_ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Requirements> selectRequirementsById(int id) {

        String sql = """
                SELECT id, recipe_id, ingredient_id
                FROM recipes_ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RequirementsRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void updateRequirements(Requirements requirements, Integer id) {
        String sql = """
                UPDATE recipes_ingredients
                SET recipe_id = ?, ingredient_id = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sql,
                requirements.getRecipes_id(),
                requirements.getIngredients_id(), id);
        System.out.println("Updated Record with ID = " + id + "with recipes name: " + requirements);

    }
}
