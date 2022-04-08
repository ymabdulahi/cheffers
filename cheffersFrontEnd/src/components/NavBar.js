import '../styles/NavBar.css'
import ThemeToggle from './ThemeToggle';
import { useState, useContext } from "react"
import { ThemeContext } from "../contexts/ThemeContext";



const NavBar = ({ goHome, searchChange, filteredToBreakFast, filteredToLunch, filteredToDinner, filteredToSnack,
    filteredToDessert, filteredToVegetarian, filteredToVegan, filteredToMeatOnly, filteredToPescatarian,
    filteredToHot, filteredToMedium, filteredToMild, filteredToSweet, filteredTo30mins, filteredToHour,
    filteredToOverHour, filteredToFaves }) => {

    const [dropdown, setDropdown] = useState(false);

    const dropdownClick = () => {

        if (dropdown === false) {
            setDropdown(true);
        } else {
            setDropdown(false);
        }
    }

    const theme = useContext(ThemeContext);
    const darkMode = theme.state.darkMode;

    return (
        <div>

            <div className={`navBar ${darkMode ? "navbar-dark" : "navbar-light"}`}>
                <h1 onClick={goHome}>Cheffers</h1>
                <input className={`searchBar ${darkMode ? "searchBar-dark" : "searchBar-light"}`} type="search" placeholder="search..." onChange={searchChange} />
                <button onClick={dropdownClick}>Filter</button>
                <button onClick={filteredToFaves}>Favourites</button>
                <ThemeToggle />
            </div>

            {dropdown === true ?
                (<div className={`menuLinks ${darkMode ? "menuLinks-dark" : "menuLinks-light"}`}>
                    <div className="mealTypeMenu">
                        <p>Meal Type</p>
                        <div className="mealTypeLinks">
                            <html onClick={filteredToBreakFast}>Breakfast</html>
                            <html onClick={filteredToLunch}>Lunch</html>
                            <html onClick={filteredToDinner}>Dinner</html>
                            <html onClick={filteredToSnack}>Snack</html>
                            <html onClick={filteredToDessert}>Dessert</html>
                        </div>
                    </div>
                    <div className="dietsMenu">
                        <p>Diets</p>
                        <div className="dietsLinks">
                            <html onClick={filteredToVegetarian}>Vegetarian</html>
                            <html onClick={filteredToVegan}>Vegan</html>
                            <html onClick={filteredToMeatOnly}>Meat only</html>
                            <html onClick={filteredToPescatarian}>Pescatarian</html>
                        </div>
                    </div>
                    <div className="spiceRatingMenu">
                        <p>Spice Rating</p>
                        <div className="spiceRatingLinks">
                            <html onClick={filteredToHot}>Hot</html>
                            <html onClick={filteredToMedium}>Medium</html>
                            <html onClick={filteredToMild}>Mild</html>
                            <html onClick={filteredToSweet}>Sweet</html>
                        </div>
                    </div>
                    <div className="cookingTimeMenu">
                        <p>Cooking Time</p>
                        <div className="cookingTimeLinks">
                            <html onClick={filteredTo30mins}>Under 30 mins</html>
                            <html onClick={filteredToHour}>Up to an hour</html>
                            <html onClick={filteredToOverHour}>Over an hour</html>
                        </div>
                    </div>
                </div>)
                :
                (null)}
        </div>
    )
}

export default NavBar;