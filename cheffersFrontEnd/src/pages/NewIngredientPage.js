import { useNavigate } from "react-router-dom";
import IngredientForm from "../components/IngredientForm";
import "../styles/Form.css"
import "../App.css"
import FormPageNavBar from "../components/FormPageNavBar";
import { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';

const NewIngredientPage = () => {

    let navigate = useNavigate();

    const theme = useContext(ThemeContext);
    const darkMode = theme.state.darkMode;


    const goHome = () => {
        navigate("/");
    }

    return(
        <>
        <FormPageNavBar goHome={goHome}/>
        <h1 className={`ingredientPageTitle ${darkMode ? "ing-title-dark" : "ing-title-light"}`}>Add a new Ingredient</h1>
        <IngredientForm />
        </>
    )

}
export default NewIngredientPage