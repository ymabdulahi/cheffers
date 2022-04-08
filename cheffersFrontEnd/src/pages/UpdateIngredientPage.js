import { useNavigate } from "react-router-dom";
import IngredientForm from "../components/IngredientForm";
import "../styles/Form.css"
import "../App.css"
import FormPageNavBar from "../components/FormPageNavBar";

const NewIngredientPage = ({ingredientName, allergen}) => {

    let navigate = useNavigate();

    const goHome = () => {
        navigate("/");
    }

    return(
        <>
        <FormPageNavBar goHome={goHome}/>
        <h1 className="ingredientPageTitle">Add a new Ingredient</h1>
        <IngredientForm ingredientName = {ingredientName} allergen={allergen}/>
        </>
    )

}
export default NewIngredientPage