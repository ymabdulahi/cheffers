package Ingredients;

import java.util.Objects;

public class Ingredients {
    private Integer id;
    private String name;
    private String allergyCategory;

    public Ingredients(Integer id, String name, String allergyCategory) {
        this.id = id;
        this.name = name;
        this.allergyCategory = allergyCategory;
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

    public String getAllergyCategory() {
        return allergyCategory;
    }

    public void setAllergyCategory(String allergyCategory) {
        this.allergyCategory = allergyCategory;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", allergyCategory='" + allergyCategory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(allergyCategory, that.allergyCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, allergyCategory);
    }
}
