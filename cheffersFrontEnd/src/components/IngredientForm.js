import {useState} from "react"
import {addIngredient} from "../adapters/recipeAdapter"
import "../styles/Form.css"

const IngredientForm = () => {

    const [ingredientName, setIngredientName] = useState(null)
    const [allergen, setAllergen] = useState(null);

    const handleFormSubmission = (event) => {
        event.preventDefault();
        const newIngredient = {
            ingredientName: ingredientName,
            allergen: allergen
        };   

        addIngredient(newIngredient);
    }

    const handleNameChange = (event) => {
        setIngredientName(event.target.value);
    };

    const handleAllergenChange = (event) => {
        setAllergen(event.target.value);
    };
    
    return(
        <div className="formContainer">
        <div className = "form">
        <form onSubmit={handleFormSubmission}>
            <p className="inputTitle">Add new ingredient</p>
            <input type="text" value={ingredientName} onChange={handleNameChange}></input>
            <p className="inputTitle"> Allergen</p>
            <input type="text" value={allergen} onChange={handleAllergenChange}></input>
            <hr/>
            <input className="submit" type="submit" value="Submit"/>
            
        </form>
        </div>
        </div>

    )
    
}

export default IngredientForm;