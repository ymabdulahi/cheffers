package Ingredients;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sun.tools.classfile.Attribute.Exceptions;

@Service
public class IngredientsService {

    private final IngredientsDAO ingredientDAO;

    public IngredientsService(IngredientsDAO ingredientsDAO) {
        this.ingredientsDAO = ingredientsDAO;
    }

    public List<Ingredients> getIngredient() {
        return ingredientDAO.selectIngredients();
    }

    public void addNewIngredient(Ingredients ingredients) {
        int result = ingredientsDAO.insertIngredients(ingredients);
        if (result != 1) {
            throw new IllegalStateException("Ingredients already exists");
        }
    }

    public void deleteIngredients(Integer id) {
        Optional<Ingredients> ingredients = ingredientDAO.selectIngredientsById(id);
        ingredients.ifPresentOrElse(ingredient -> {
            int result = ingredientDAO.deleteIngredients(id);
            if (result != 1) {
                throw new IllegalStateException("Ingredients can not be deleted");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id not found", id));
        });
    }


    public Ingredients getIngredients(int id) {
        return ingredientDAO.selectIngredientsById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id not found", id)));
    }

    public void updateIngredients(Ingredients ingredients, Integer id) {
        int result =  ingredientsDAO.updateIngredients(ingredients, id);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }
}
