package Ingredients;

import cheffers.cheffers_backend.Recipes.Recipes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IngredientsDAO {
    List<Ingredients> selectIngredients();
    int insertIngredients(Ingredients ingredients);
    int deleteIngredients(int id);
    Optional<Ingredients> selectIngredientsById(int id);
    int updateIngredients(Ingredients ingredient, Integer id);
}
