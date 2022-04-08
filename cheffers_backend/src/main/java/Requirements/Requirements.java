package Requirements;

import java.util.Objects;

public class Requirements {
    private Integer id;
    private Integer recipes_id;
    private Integer ingredients_id;

    public Requirements(Integer id, Integer recipes_id, Integer ingredients_id) {
        this.id = id;
        this.recipes_id = recipes_id;
        this.ingredients_id = ingredients_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecipes_id() {
        return recipes_id;
    }

    public void setRecipes_id(Integer recipes_id) {
        this.recipes_id = recipes_id;
    }

    public Integer getIngredients_id() {
        return ingredients_id;
    }

    public void setIngredients_id(Integer ingredients_id) {
        this.ingredients_id = ingredients_id;
    }

    @Override
    public String toString() {
        return "Requirements{" +
                "id=" + id +
                ", recipes_id=" + recipes_id +
                ", ingredients_id=" + ingredients_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requirements that = (Requirements) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(recipes_id, that.recipes_id) &&
                Objects.equals(ingredients_id, that.ingredients_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipes_id, ingredients_id);
    }
}
