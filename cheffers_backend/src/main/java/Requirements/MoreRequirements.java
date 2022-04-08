package Requirements;

import Recipes.Cuisine;
import Recipes.MealType;
import Recipes.Spice;

import java.util.Objects;

public class MoreRequirements {
    private String requirementsName;
    private String ingredientsName;
    private Cuisine cuisine;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean meat_only;
    private Boolean pescatarian;
    private MealType meal_type;
    private Spice spice;
    private Integer cooking_time_mins;
    private String instructions;

    public MoreRequirements(String requirementsName, String ingredientsName, Cuisine cuisine, Boolean vegetarian, Boolean vegan, Boolean meat_only, Boolean pescatarian, MealType meal_type, Spice spice, Integer cooking_time_mins, String instructions) {
        this.requirementsName = requirementsName;
        this.ingredientsName = ingredientsName;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.meat_only = meat_only;
        this.pescatarian = pescatarian;
        this.meal_type = meal_type;
        this.spice = spice;
        this.cooking_time_mins = cooking_time_mins;
        this.instructions = instructions;
    }

    public String getRequirementsName() {
        return requirementsName;
    }

    public void setRequirementsName(String requirementsName) {
        this.requirementsName = requirementsName;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getMeat_only() {
        return meat_only;
    }

    public void setMeat_only(Boolean meat_only) {
        this.meat_only = meat_only;
    }

    public Boolean getPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(Boolean pescatarian) {
        this.pescatarian = pescatarian;
    }

    public MealType getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(MealType meal_type) {
        this.meal_type = meal_type;
    }

    public Spice getSpice() {
        return spice;
    }

    public void setSpice(Spice spice) {
        this.spice = spice;
    }

    public Integer getCooking_time_mins() {
        return cooking_time_mins;
    }

    public void setCooking_time_mins(Integer cooking_time_mins) {
        this.cooking_time_mins = cooking_time_mins;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "MoreRequirements{" +
                "requirementsName='" + requirementsName + '\'' +
                ", ingredientsName='" + ingredientsName + '\'' +
                ", cuisine=" + cuisine +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", meat_only=" + meat_only +
                ", pescatarian=" + pescatarian +
                ", meal_type=" + meal_type +
                ", spice=" + spice +
                ", cooking_time_mins=" + cooking_time_mins +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoreRequirements that = (MoreRequirements) o;
        return Objects.equals(requirementsName, that.requirementsName) &&
                Objects.equals(ingredientsName, that.ingredientsName) &&
                Objects.equals(cuisine, that.cuisine) &&
                Objects.equals(vegetarian, that.vegetarian) &&
                Objects.equals(vegan, that.vegan) &&
                Objects.equals(meat_only, that.meat_only) &&
                Objects.equals(pescatarian, that.pescatarian) &&
                Objects.equals(meal_type, that.meal_type) &&
                Objects.equals(spice, that.spice) &&
                Objects.equals(cooking_time_mins, that.cooking_time_mins) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requirementsName, ingredientsName, cuisine, vegetarian, vegan, meat_only, pescatarian, meal_type, spice, cooking_time_mins, instructions);
    }
}
