import { useState } from "react";
import { updateRecipe } from "../adapters/recipeAdapter";
import "../styles/Form.css";

const UpdateRecipeForm = ({ recipe }) => {
  const [name, setName] = useState(recipe.name);
  const [cuisine, setCuisine] = useState(recipe.cuisine);
  const [vegetarian, setVegetarian] = useState(recipe.vegetarian);
  const [vegan, setVegan] = useState(recipe.vegan);
  const [meatOnly, setMeatOnly] = useState(recipe.meatOnly);
  const [pescatarian, setPescatarian] = useState(recipe.pescatarian);
  const [mealType, setMealType] = useState(recipe.mealType);
  const [spiceRating, setSpice] = useState(recipe.spice);
  const [cookingTime, setCookingTime] = useState(recipe.cookingTime);
  const [instructions, setInstructions] = useState(recipe.instructions);

  const handleFormSubmission = (event) => {
    event.preventDefault();
    const newRecipe = {
      name: name,
      cuisine: cuisine,
      vegetarian: vegetarian,
      vegan: vegan,
      meatOnly: meatOnly,
      pescatarian: pescatarian,
      mealType: mealType,
      spice: spiceRating,
      cookingTime: cookingTime,
      instructions: instructions,
    };

    updateRecipe(newRecipe, recipe.id);
  };

  const handleNameChange = (event) => {
    setName(event.target.value);
  };
  const handleCuisineChange = (event) => {
    setCuisine(event.target.value);
  };
  const handleVegetarianChange = (event) => {
    console.log("EVENT" + event);
    console.log("EVENT TARGET VALUE" + event.target.value);
    setVegetarian(!vegetarian);
  };

  const handleVeganChange = (event) => {
    setVegan(!vegan);
  };

  const handleMeatOnlyChange = (event) => {
    setMeatOnly(!meatOnly);
  };

  const handlePescatarianChange = (event) => {
    setPescatarian(!pescatarian);
  };

  const handleMealTypeChange = (event) => {
    setMealType(event.target.value);
  };

  const handleSpiceChange = (event) => {
    setSpice(event.target.value);
  };

  const handleCookingTimeChange = (event) => {
    setCookingTime(event.target.value);
  };
  const handleInstructionsChange = (event) => {
    setInstructions(event.target.value);
  };

  return (
    <div className="formContainer">
      <div className="form">
        <form onSubmit={handleFormSubmission}>
          <p className="inputTitle">New Recipe name</p>
          <input type="text" value={name} onChange={handleNameChange}></input>
          <p className="inputTitle">New Cuisine</p>
          <input
            type="text"
            value={cuisine}
            onChange={handleCuisineChange}
          ></input>
          <div className="checkboxContainer">
            <p className="inputTitle">Vegetarian</p>
            <input
              type="checkbox"
              value={vegetarian}
              onChange={handleVegetarianChange}
            ></input>
          </div>
          <div className="checkboxContainer">
            <p className="inputTitle">Vegan</p>
            <input
              type="checkbox"
              value={vegan}
              onChange={handleVeganChange}
            ></input>
          </div>
          <div className="checkboxContainer">
            <p className="inputTitle">Contains Meat</p>
            <input
              type="checkbox"
              value={meatOnly}
              onChange={handleMeatOnlyChange}
            ></input>
          </div>
          <div className="checkboxContainer">
            <p className="inputTitle">Pescatarian</p>
            <input
              type="checkbox"
              value={pescatarian}
              onChange={handlePescatarianChange}
            ></input>
          </div>
          <p className="inputTitle">Meal Type</p>
          <select
            className="select decorated"
            value={mealType}
            onChange={handleMealTypeChange}
          >
            <option className="option" value="BREAKFAST">
              BREAKFAST
            </option>
            <option className="option" value="LUNCH">
              LUNCH
            </option>
            <option className="option" value="DINNER">
              DINNER
            </option>
            <option className="option" value="SNACK">
              SNACK
            </option>
            <option className="option" value="DESSERT">
              DESSERT
            </option>
          </select>
          <p className="inputTitle">Spice Rating</p>
          <select
            className="select"
            value={spiceRating}
            onChange={handleSpiceChange}
          >
            <option value="SWEET">SWEET</option>
            <option value="MILD">MILD</option>
            <option value="MEDIUM">MEDIUM</option>
            <option value="HOT">HOT</option>
          </select>
          <p className="inputTitle">Cooking Time</p>
          <input
            type="text"
            value={cookingTime}
            onChange={handleCookingTimeChange}
          ></input>
          <p className="inputTitle">Instructions</p>
          <input
            type="text"
            className="instructions"
            value={instructions}
            onChange={handleInstructionsChange}
          ></input>
          <hr />
          <input className="submit" type="submit" />
        </form>
      </div>
    </div>
  );
};

export default UpdateRecipeForm;