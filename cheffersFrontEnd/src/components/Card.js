import "../styles/Card.css";
import React, { useState, useEffect, useContext } from "react";
import { AiFillStar } from "react-icons/ai";
import { AiOutlineStar } from "react-icons/ai";
import { ThemeContext } from "../contexts/ThemeContext";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import food_placeholder from "../images/food_placeholder.png"
import vegetarianIcon from "../images/vegetarianIcon.png"
import veganIcon from "../images/veganIcon.png"
import pescatarianIcon from "../images/pescatarianIcon.png"
import meatOnlyIcon from "../images/meatOnlyIcon.png"

const Card = ({
  name,
  id,
  isVegan,
  isVegetarian,
  isMeatOnly,
  isPescatarian,
  addToFaves,
  removeFromFaves,
  favourites,
}) => {
  const darkTheme = useContext(ThemeContext);
  const darkMode = darkTheme.state.darkMode;

  const [theme, setTheme] = useState("");

  useEffect(() => {
    if (isVegan) {
      //console.log("vegan")
      setTheme("card-vegan");
    } else if (isVegetarian) {
      setTheme("card-vegetarian");
    } else if (isPescatarian) {
      setTheme("card-pesc");
    } else if (isMeatOnly) {
      setTheme("card-meat");
    }
  }, [isVegan, isVegetarian, isMeatOnly, isPescatarian]);

  let navigate = useNavigate();

  return (
    <div className={`card ${theme} ${darkMode ? "card-dark" : "card-light"}`}>
      {favourites == true ? (
        <button onClick={() => removeFromFaves(id)}>
          <AiFillStar />
        </button>
      ) : (
        <button onClick={() => addToFaves(id)}>
          <AiOutlineStar />
        </button>
      )}
      <Link to={{ pathname: `/recipe/${id}` }}>
        <div className="link-to-recipe">
          {/* <img src={props.image} alt={props.alt}/> */}
          <img className ="food-image" src={food_placeholder} alt="placeholder"/>
          <p>{name}</p>
          {/* <p>Some description</p> */}

          <div className="recipe-icon-block">
          {isVegetarian ? 
          <img src={vegetarianIcon} alt="vegetarian" className="icon"/>
          :
          <>
          </>
        }
          {isVegan ? 
          <img src={veganIcon} alt="Vegan Icon" className="icon"/>
           :
           <>
           </>
          }
          {isPescatarian ? 
          <img src={pescatarianIcon} alt="Pescatarian Icon" className="icon"/>
          :
          <>
          </>
         }
          {isMeatOnly ?
          <img src={meatOnlyIcon} alt="Meat Icon" className="icon"/>
          :
          
          <></>}
        
      </div>
        </div>
        
      </Link>
      
    </div>
  );
};

export default Card;