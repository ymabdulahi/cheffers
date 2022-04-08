import "../adapters/recipeAdapter"
import {useState, useEffect, useContext} from "react"
import {getAllRecipes} from "../adapters/recipeAdapter"
import CardList from "../components/CardList"
import NavBar from "../components/NavBar"
import {useNavigate} from "react-router-dom";
import AddNewButton from "../components/AddNewButton"
import PopulateDBbutton from "../components/PopulateDBbutton"
import { ThemeContext } from "../contexts/ThemeContext";

const HomePage = () => {
    const [recipes, setRecipes] = useState(null);
    const [input, setInput] = useState("");
    const [recipesFiltered, setRecipesFiltered] = useState([]);

    useEffect(()=>{
        getAllRecipes().then(response => setRecipes(response))}, [])

    const searchChange = (s) => {
        console.log(s.target.value)
        setInput(s.target.value)
        setRecipesFiltered("");
    };

    const sortRecipes = 
    recipes ?
    recipes.sort((x, y) => {return (x.favourites === y.favourite)? 0 : x? -1 : 1;})
    :
    null;

    const filteredRecipes = 
    recipes ?
        sortRecipes.filter((recipes)=> {
            return recipes.name.toLowerCase().includes(input.toLowerCase());
        })
        :
        null;

        const filteredToBreakFast = () => { 
   
            const newRecipes = recipes.filter((recipes)=> { return recipes.mealType.toLowerCase().includes("breakfast") })
            setRecipesFiltered(newRecipes);
            console.log(recipesFiltered.id);
        }
    
        const filteredToLunch = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.mealType.toLowerCase().includes("lunch") })
            setRecipesFiltered(newRecipes);
        }
    
        const filteredToDinner = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.mealType.toLowerCase().includes("dinner") })
            setRecipesFiltered(newRecipes);
        }

        const filteredToSnack = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.mealType.toLowerCase().includes("snack") })
            setRecipesFiltered(newRecipes);
        }
    
        const filteredToDessert = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.mealType.toLowerCase().includes("dessert") })
            setRecipesFiltered(newRecipes);
        }

        const filteredToVegetarian = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.vegetarian })
            setRecipesFiltered(newRecipes);
        }

        const filteredToVegan = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.vegan })
            setRecipesFiltered(newRecipes);
        }

        const filteredToMeatOnly = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.meatOnly })
            setRecipesFiltered(newRecipes);
        }

        const filteredToPescatarian = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.pescatarian })
            setRecipesFiltered(newRecipes);
        }

        const filteredToHot = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.spiceRating.toLowerCase().includes("hot") })
            setRecipesFiltered(newRecipes);
        }

        const filteredToMedium = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.spiceRating.toLowerCase().includes("medium") })
            setRecipesFiltered(newRecipes);
        }

        const filteredToMild = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.spiceRating.toLowerCase().includes("mild") })
            setRecipesFiltered(newRecipes);
        }

        const filteredToSweet = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.spiceRating.toLowerCase().includes("sweet") })
            setRecipesFiltered(newRecipes);
        }

        const filteredTo30mins = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.cookingTime < 31 })
            setRecipesFiltered(newRecipes);
        }

        const filteredToHour = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.cookingTime < 61 })
            setRecipesFiltered(newRecipes);
        }

        const filteredToOverHour = () => { 
       
            const newRecipes = recipes.filter((recipes)=> { return recipes.cookingTime > 61 })
            setRecipesFiltered(newRecipes);
        }

        const goHome = () => {
            setRecipesFiltered("");
        }

        const recipesToShow = recipesFiltered.length > 0 ? recipesFiltered : filteredRecipes;  

    let navigate = useNavigate();

    const goNewRecipePage = () => {
        navigate("/NewRecipePage")
    }

    const goNewIngredientPage = () => {
        navigate("/NewIngredientPage")
    }
    
    const addToFaves = (id) => {
        const findRecipe = recipes.find(recipes => recipes.id === id);
        findRecipe.favourites = true;
        const updateRecipes = [...recipes];
        setRecipes(updateRecipes);
    };

    const removeFromFaves = (id) => {
        const findRecipe = recipes.find(recipes => recipes.id === id);
        findRecipe.favourites = false;
        const updateRecipes = [...recipes];
        setRecipes(updateRecipes);
    };

    const filteredToFaves= () => {   
        const newRecipes = recipes.filter((recipes)=> { return recipes.favourites })
        setRecipesFiltered(newRecipes);
    }

    const darkTheme = useContext(ThemeContext);
    const darkMode = darkTheme.state.darkMode;

    return (
        recipes ?
        <>
            <NavBar goHome={goHome} searchChange={searchChange} value={input} filteredToBreakFast={filteredToBreakFast} 
            filteredToLunch={filteredToLunch} filteredToDinner={filteredToDinner} filteredToSnack={filteredToSnack} 
            filteredToDessert={filteredToDessert} filteredToVegetarian={filteredToVegetarian} filteredToVegan={filteredToVegan} 
            filteredToMeatOnly={filteredToMeatOnly} filteredToPescatarian={filteredToPescatarian} filteredToHot={filteredToHot}
            filteredToMedium={filteredToMedium} filteredToMild={filteredToMild} filteredToSweet={filteredToSweet}
            filteredTo30mins={filteredTo30mins} filteredToHour={filteredToHour} filteredToOverHour={filteredToOverHour}
            filteredToFaves={filteredToFaves} />
            <h1 className={`homepage-title ${darkMode ? "homepage-title-dark" : "homepage-title-light"}`}>All Recipes</h1>
            <CardList recipes={recipesToShow} addToFaves={addToFaves} removeFromFaves={removeFromFaves}/>
            {/* <PopulateDBbutton/> */}
            <AddNewButton />
        </>

        :
        <>
        <NavBar goHome={goHome} searchChange={searchChange} value={input} filteredToBreakFast={filteredToBreakFast} 
            filteredToLunch={filteredToLunch} filteredToDinner={filteredToDinner} filteredToSnack={filteredToSnack} 
            filteredToDessert={filteredToDessert} filteredToVegetarian={filteredToVegetarian} filteredToVegan={filteredToVegan} 
            filteredToMeatOnly={filteredToMeatOnly} filteredToPescatarian={filteredToPescatarian} filteredToHot={filteredToHot}
            filteredToMedium={filteredToMedium} filteredToMild={filteredToMild} filteredToSweet={filteredToSweet}
            filteredTo30mins={filteredTo30mins} filteredToHour={filteredToHour} filteredToOverHour={filteredToOverHour}/>
            // <PopulateDBbutton/>
        <p>Loading...</p>
        </>
    )
}
export default HomePage;