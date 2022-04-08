import Card from "./Card";
import '../styles/CardList.css'

const CardList = ({recipes, addToFaves, removeFromFaves}) => {
    const recipeList = recipes

    const recipeComponents = recipes.map(recipe => {
        return (
        <Card 
            name={recipe.name} 
            key={recipe.id} 
            id={recipe.id}
            isVegan={recipe.vegan} 
            isVegetarian={recipe.vegetarian}
            isMeatOnly={recipe.meatOnly}
            isPescatarian={recipe.pescatarian}
            favourites={recipe.favourites}
            className="recipeCard"

            addToFaves={addToFaves}
            removeFromFaves={removeFromFaves}


        />
    )})


    return (
        <div className="cardList" >
            {recipeComponents}
        </div>
    )

}

export default CardList