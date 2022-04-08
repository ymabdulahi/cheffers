import './App.css';
import HomePage from './pages/HomePage';
import NewRecipePage from './pages/NewRecipePage';
import NewIngredientPage from './pages/NewIngredientPage';
import ThemeToggle from './components/ThemeToggle';
import React, { useEffect, useContext } from "react";
import { ThemeContext } from "./contexts/ThemeContext";
import {BrowserRouter, Routes, Route} from 'react-router-dom';
//import NavBar from './components/NavBar';

import {postIngredients, postRecipes} from './data/populatedb.js'
import RecipePage from './pages/RecipePage';



function App() {
  const theme = useContext(ThemeContext);
  const darkMode = theme.state.darkMode;

  useEffect(() => {
    if (darkMode) {
      document.body.classList.add("bg-dark");
      document.body.classList.remove("bg-light");
    } else {
      document.body.classList.add("bg-light");
      document.body.classList.remove("bg-dark");
    }
  });

  return (

    <BrowserRouter>
      <div className={`App ${darkMode ? "app-dark" : "app-light"}`}>
        <header className="App-header">
          {/* <HomePage />
          <ThemeToggle /> */}

        </header>
        
        <Routes>
          <Route path = "/" element={<HomePage />} />
          <Route path = "/NewRecipePage" element = {<NewRecipePage />} />
          <Route path = "/NewIngredientPage" element = {<NewIngredientPage />} />
          <Route path="/recipe/:id" element={<RecipePage />} />
        </Routes>

        {/* <button onClick={postIngredients}>post ingredients</button> */}
        {/* <button onClick={postRecipes}>post recipes</button> */}

      </div>
    </BrowserRouter>

  );
}

export default App;
