import axios from "axios";

const getAllRecipes = () => {
    return (
        axios.get("http://localhost:8080/api/v1/recipes")
        .then(response => {
            return response.data
        })
    )
}

const getRecipeById = (id) => {
    return (
        axios.get("http://localhost:8080/api/v1/recipes/" + id)
        .then(response => {
            return response.data
        })
    )
}

const getRecipeAccordingToAllergy = (allergen) => {
    return (
        axios.get("http://localhost:8080/api/v1/resturantIngredients?allergen=" + allergen)
        .then(response => {
            return response.data
        })
    )
}

const getRecipesByCookingTime = (cookingTime) => {
    return (
        axios.get("http://localhost:8080/api/v1/resturantIngredients?cookingTime=" + cookingTime)
        .then(response => {
            return response.data
        })
    )
}

const getAllIngredients = () => {
    return (
        axios.get("http://localhost:8080/api/v1/ingredients")
        .then(response => {
            return response.data
        })
    )
    }

const getIngredientById = (id) => {
    return (
        axios.get("http://localhost:8080/api/v1/ingredients/" + id)
        .then(response => {
            return response.data
        })
    )
}

const addIngredient = (ingredient) => {
return (
    axios.post('http://localhost:8080/api/v1/ingredients', ingredient)
).catch((e)=> {
    console.log("recipeAdapter could not add ingredient")
})
}

const addRecipe = (recipe) => {
    return (
        axios.post("http://localhost:8080/api/v1/recipes", recipe)
    ).catch((e)=> {
        console.log("recipeAdapter could not add recipe")
    })
}

const updateRecipe = (recipe, id) => {
    return (
        axios.put("http://localhost:8080/api/v1/recipes/" + id, recipe)
    ).catch((e)=> {
        console.log("recipeAdapter could not update recipe")
    })
}

export { getAllRecipes, getRecipeById, getRecipeAccordingToAllergy, getRecipesByCookingTime, getAllIngredients, getIngredientById, addIngredient, addRecipe, updateRecipe}