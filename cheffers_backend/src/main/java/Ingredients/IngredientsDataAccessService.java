package Ingredients;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientsDataAccessService implements IngredientsDAO {

    private final JdbcTemplate jdbcTemplate;

    public IngredientsDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredients> selectIngredients() {
        String sql = """
                SELECT id, iname, allergy_category
                FROM ingredients
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new IngredientsRowMapper()) ;
    }

    @Override
    public int insertIngredients(Ingredients ingredient ) {

        String sql = """
                INSERT INTO ingredients (iname,allergy_category)
                VALUES (?,?) ON CONFLICT ON CONSTRAINT ingredients_iname_key DO NOTHING;
                """;

        return jdbcTemplate.update(
                sql,
                ingredient.getName(),
                ingredient.getAllergyCategory()
        );
    }

    @Override
    public int deleteIngredients(int id) {
        String sql = """
                DELETE FROM ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Ingredients> selectIngredientsById(int id) {

        String sql = """
                SELECT id, iname, allergy_category
                FROM ingredients
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new IngredientsRowMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public int updateIngredients(Ingredients ingredient, Integer id) {
        String sql = """
                UPDATE ingredients
                SET iname = ?, allergy_category = ?
                WHERE id = ?
                """;


        return jdbcTemplate.update(sql,
                ingredient.getName(),
                ingredient.getAllergyCategory(),
                id);
    }
}
