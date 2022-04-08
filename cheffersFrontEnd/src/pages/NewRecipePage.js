import { useNavigate } from "react-router-dom";
import FormPageNavBar from "../components/FormPageNavBar";
import RecipeForm from "../components/RecipeForm";
import "../styles/Form.css"
import "../App.css"
import { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';


const NewRecipePage = () => {

    let navigate = useNavigate();
    const theme = useContext(ThemeContext);
    const darkMode = theme.state.darkMode;

    const goHome = () => {
        navigate("/");
    }

    return(
        <>
        <FormPageNavBar goHome={goHome}/>
        <h1 className={`recipePageTitle ${darkMode ? "recipe-title-dark" : "recipe-title-light"}`}>Add a new Recipe</h1>
        <RecipeForm />
        </>
    )

}
export default NewRecipePage