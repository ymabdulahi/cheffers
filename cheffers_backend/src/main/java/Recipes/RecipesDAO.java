package Recipes;

import java.util.List;
import java.util.Optional;

public interface RecipesDAO {
    List<Recipes> selectRecipes();
    int insertRecipes(Recipes recipes);
    int deleteRecipe(int id);
    Optional<Recipes> selectRecipeById(int id);
    int updateRecipe( Recipes recipes, Integer id);
}
