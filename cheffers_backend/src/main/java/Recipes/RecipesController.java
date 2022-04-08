package Recipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipesController {

    private RecipesService recipeService;


    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping
    public List<Recipes> listRecipe() {
        return recipeService.getRecipes();
    }

    @GetMapping("{id}")
    public Recipes getRecipeId(@PathVariable("id") Integer id) {
        return recipesService.getRecipes(id);
    }

    @PostMapping
    public void addRecipe(@RequestBody Recipes recipes) {
        recipesService.addNewRecipes(recipes);
    }

    @DeleteMapping("{id}")
    public void deleteRecipes(@PathVariable("id") Integer id) {
        recipesService.deleteRecipes(id);
    }

    @PutMapping("{id}")
    public void updateRecipe( @RequestBody Recipes recipe, @PathVariable("id") Integer id) { recipeService.updateRecipes(recipe,id);}
}
