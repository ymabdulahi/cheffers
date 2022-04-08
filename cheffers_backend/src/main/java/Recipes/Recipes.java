package Recipes;

import java.util.Objects;

public class Recipes {

    private Integer id;
    private String name;
    private Cuisine cuisine;
    private boolean vegetarian;
    private boolean vegan;
    private boolean meatOnly;
    private boolean pescatarian;
    private MealType mealType;
    private Spice spice;
    private Integer cookingTime;
    private String instructions;

    public Recipes(Integer id, String name, Cuisine cuisine, boolean vegetarian, boolean vegan, boolean meatOnly, boolean pescatarian, MealType mealType, Spice spice, Integer cookingTime, String instructions) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.meatOnly = meatOnly;
        this.pescatarian = pescatarian;
        this.mealType = mealType;
        this.spice = spice;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isMeatOnly() {
        return meatOnly;
    }

    public void setMeatOnly(boolean meatOnly) {
        this.meatOnly = meatOnly;
    }

    public boolean isPescatarian() {
        return pescatarian;
    }

    public void setPescatarian(boolean pescatarian) {
        this.pescatarian = pescatarian;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Spice getSpice() {
        return spice;
    }

    public void setSpice(Spice spice) {
        this.spice = spice;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisine=" + cuisine +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", meatOnly=" + meatOnly +
                ", pescatarian=" + pescatarian +
                ", mealType=" + mealType +
                ", spice=" + spice +
                ", cookingTime=" + cookingTime +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return vegetarian == recipes.vegetarian &&
                vegan == recipes.vegan &&
                meatOnly == recipes.meatOnly &&
                pescatarian == recipes.pescatarian &&
                Objects.equals(id, recipes.id) &&
                Objects.equals(name, recipes.name) &&
                Objects.equals(cuisine, recipes.cuisine) &&
                Objects.equals(mealType, recipes.mealType) &&
                Objects.equals(spice, recipes.spice) &&
                Objects.equals(cookingTime, recipes.cookingTime) &&
                Objects.equals(instructions, recipes.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cuisine, vegetarian, vegan, meatOnly, pescatarian, mealType, spice, cookingTime, instructions);
    }
}
