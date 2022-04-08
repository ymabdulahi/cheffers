package Recipes;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipesDataAccessService implements RecipesDAO {

    private final JdbcTemplate jdbcTemplate;

    public RecipesDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipes> selectRecipes() {
        String sql = """
                SELECT id, rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice, cooking_time_mins, instructions
                FROM recipes
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RecipesRowMapper()) ;
    }

    @Override
    public int insertRecipes(Recipes recipes) {
        String sql = """
                INSERT INTO recipes(rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice, cooking_time_mins, instructions)
                VALUES (?, ?::cuisine, ?, ?, ?, ?, ?::meal_type, ?::spice_rating, ?, ?) ON CONFLICT ON CONSTRAINT recipes_rname_key DO NOTHING;
                """;

        return jdbcTemplate.update(
                sql,
                recipes.getName(),
                recipes.getCuisine().toString(),
                recipes.isVegetarian(),
                recipes.isVegan(),
                recipes.isMeatOnly(),
                recipes.isPescatarian(),
                recipes.getMealType().toString(),
                recipes.getSpice().toString(),
                recipes.getCookingTime(),
                recipes.getInstructions()
        );
    }

    @Override
    public int deleteRecipes(int id) {
        String sql = """
                DELETE FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Recipes> selectRecipesById(int id) {

        String sql = """
                SELECT id, rname, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice_rating, cooking_time_mins, instructions
                FROM recipes
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new RecipesRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public int updateRecipe(Recipes recipe, Integer id) {
        String sql = """
                UPDATE recipes
                SET rname = ?, cuisine = ?::cuisine, vegetarian = ?, vegan = ?, meat_only = ?, pescatarian = ?, meal_type = ?::meal_type, spice_rating = ?::spice_rating, cooking_time_mins = ?, instructions = ?
                WHERE id = ?
                """;


        return jdbcTemplate.update(sql,
                recipe.getName(),
                recipe.getCuisine().toString(),
                recipe.isVegetarian(),
                recipe.isVegan(),
                recipe.isMeatOnly(),
                recipe.isPescatarian(),
                recipe.getMealType().toString(),
                recipe.getSpice().toString(),
                recipe.getCookingTime(),
                recipe.getInstructions(), id);
    }
}
