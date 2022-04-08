import {postIngredients, postRecipes} from '../data/populatedb.js'

const PopulateDBbutton = () => {
return(
    <>
    <button onClick={postIngredients}>post ingredients</button>
    <button onClick={postRecipes}>post recipes</button>
    </>
)
}

export default PopulateDBbutton