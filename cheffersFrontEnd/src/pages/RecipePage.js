import { getRecipeById } from "../adapters/recipeAdapter"
import { useParams } from "react-router";
import { useState, useEffect } from "react";

import { useNavigate } from "react-router-dom";
import FormPageNavBar from "../components/FormPageNavBar";
import "../App.css"

import UpdateRecipeForm from "../components/UpdateRecipeForm";
import { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';
import vegetarianIcon from "../images/vegetarianIcon.png"
import veganIcon from "../images/veganIcon.png"
import pescatarianIcon from "../images/pescatarianIcon.png"
import meatOnlyIcon from "../images/meatOnlyIcon.png"


const RecipePage = (props) => {

    const { id } = useParams();
    const [recipe, setRecipe] = useState(null)
    const [showUpdateForm, setShowUpdateForm] = useState(false)

    const theme = useContext(ThemeContext);
    const darkMode = theme.state.darkMode;

    useEffect(() => {
        getRecipeById(id).then(r => setRecipe(r))

    }, [])

    let navigate = useNavigate();
    const goHome = () => {
        navigate("/");
    }


    const updateForm = () => {
        setShowUpdateForm(true);
    }

    return (
        recipe ?


            <>

                <FormPageNavBar goHome={goHome} />
                <div className={`recipe-page ${darkMode ? "rec-pg-dark" : "rec-pg-light"}`}>

                    <h1>{recipe.name}</h1>
                    <h3>{`Cuisine: ${recipe.cuisine}`}</h3>
                    <h3>{`Spice Level: ${recipe.spiceRating}`}</h3>
                    <h3>{`Cooking Time: ${recipe.cookingTime} minutes`}</h3>
                    <h3>{`Meal Type: ${recipe.mealType}`}</h3>
                    <div className="recipe-icon-block">
          {recipe.vegetarian ? 
          <img src={vegetarianIcon} alt="vegetarian" className="icon"/>
          :
          <>
          </>
        }
          {recipe.vegan ? 
          <img src={veganIcon} alt="Vegan Icon" className="icon"/>
           :
           <>
           </>
          }
          {recipe.pescatarian ? 
          <img src={pescatarianIcon} alt="Pescatarian Icon" className="icon"/>
          :
          <>
          </>
         }
          {recipe.meatOnly ?
          <img src={meatOnlyIcon} alt="Meat Icon" className="icon"/>
          :
          
          <></>}
        
      </div>
                    <div className="cooking-instructions">
                        <h2>Instructions</h2>
                        <p><span className="recipe-instructions">{recipe.instructions}</span></p>
                    </div>

                    <button onClick={updateForm} id="recipeButton">Update Recipe</button>
                </div>


                {showUpdateForm ?
                    <>
                        <UpdateRecipeForm recipe={recipe} />
                    </>
                    :
                    <>
                    </>}
            </>
            :
            <p>Loading...</p>
    )
}

export default RecipePage;