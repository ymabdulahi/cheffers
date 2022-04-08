package Ingredients;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ingredients")
public class IngredientsController {

    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping
    public List<Ingredients> listIngredient() {
        return ingredientsService.getIngredient();
    }

    @GetMapping("{id}")
    public Ingredients getIngredientsId(@PathVariable("id") Integer id) {
        return ingredientsService.getIngredients(id);
    }

    @PostMapping
    public void addIngredients(@RequestBody Ingredients ingredient) {
        ingredientsService.addNewIngredient(ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredients(@PathVariable("id") Integer id) {
        ingredientsService.deleteIngredients(id);
    }

    @PutMapping("{id}")
    public void updateIngredients( @RequestBody Ingredients ingredient, @PathVariable("id") Integer id) { ingredientsService.updateIngredient(ingredient,id);}
}
