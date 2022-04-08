package Recipes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sun.tools.classfile.Attribute.Exceptions;

@Service
public class RecipesService {

    private final RecipesDAO recipesDAO;

    public RecipesService(RecipesDAO recipesDAO) {
        this.recipesDAO = recipesDAO;
    }

    public List<Recipes> getRecipes() {
        return recipesDAO.selectRecipes();
    }

    public void addNewRecipes(Recipes recipes) {
        int result = recipesDAO.insertRecipes(recipes);
        if (result != 1) {
            throw new IllegalStateException("Recipe can not be added");
        }
    }

    public Recipes getRecipes(int id) {
        return recipesDAO.selectRecipeById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id not found", id)));
    }

    public void updateRecipes( Recipes recipes, Integer id) {
        int result = recipesDAO.updateRecipe(recipes, id);
        if (result != 1) {
            throw new IllegalStateException("Can not update recipe");
        }

    public void deleteRecipes(Integer id) {
        Optional<Recipes> recipes = recipesDAO.selectRecipeById(id);
        recipes.ifPresentOrElse(recipe -> {
            int result = recipesDAO.deleteRecipe(id);
            if (result != 1) {
                throw new IllegalStateException("Recipe does not exist");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id not found", id));
        });
        }
    }
}
