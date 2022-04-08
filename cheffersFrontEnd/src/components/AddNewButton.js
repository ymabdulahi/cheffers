import { useState, useEffect } from "react"
import { useNavigate } from "react-router-dom"
import "../styles/AddNewButton.css"

const AddNewButton = (props) => {

    const [ AddNewButtonState, SetAddNewButtonState ]= useState ("closed")

    const handleClick = () => {
        AddNewButtonState === "closed" ?
        SetAddNewButtonState("open")
        :
        SetAddNewButtonState("closed")
    }

    let navigate = useNavigate()
    const goNewRecipePage = () => {
        navigate("/NewRecipePage")
    }

    const goNewIngredientPage = () => {
        navigate("/NewIngredientPage")
    }

    return(
        
        AddNewButtonState === "closed" ?
        <div className="addButtonDiv">
            <button onClick={handleClick} className="plusButton">+</button>
            </div>
        :
        <div className="addButtonDiv">
            <button onClick = {goNewRecipePage} className="addRecipe">Add New Recipe</button>
            <button onClick = {goNewIngredientPage} className="addIngredient">Add New Ingredient</button>
            <button onClick={handleClick} className="plusButton">-</button>

            

            </div>

      
    )
}

export default AddNewButton