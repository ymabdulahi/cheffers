package User;

import java.util.Objects;

public class User {
    private String allergy;
    private Cuisine cuisine;
    private boolean vegetarian;
    private boolean vegan;
    private boolean meatOnly;
    private boolean pescatarian;
    private MealType mealType;
    private Spice spice;
    private Integer cookingTime;

    public User(String allergy, Cuisine cuisine, boolean vegetarian, boolean vegan, boolean meatOnly, boolean pescatarian, MealType mealType, Spice spice, Integer cookingTime) {
        this.allergy = allergy;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.meatOnly = meatOnly;
        this.pescatarian = pescatarian;
        this.mealType = mealType;
        this.spice = spice;
        this.cookingTime = cookingTime;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
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

    @Override
    public String toString() {
        return "User{" +
                "allergy='" + allergy + '\'' +
                ", cuisine=" + cuisine +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", meatOnly=" + meatOnly +
                ", pescatarian=" + pescatarian +
                ", mealType=" + mealType +
                ", spice=" + spice +
                ", cookingTime=" + cookingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return vegetarian == user.vegetarian &&
                vegan == user.vegan &&
                meatOnly == user.meatOnly &&
                pescatarian == user.pescatarian &&
                Objects.equals(allergy, user.allergy) &&
                Objects.equals(cuisine, user.cuisine) &&
                Objects.equals(mealType, user.mealType) &&
                Objects.equals(spice, user.spice) &&
                Objects.equals(cookingTime, user.cookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allergy, cuisine, vegetarian, vegan, meatOnly, pescatarian, mealType, spice, cookingTime);
    }
}
