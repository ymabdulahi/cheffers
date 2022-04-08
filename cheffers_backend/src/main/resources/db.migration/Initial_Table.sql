CREATE TYPE cuisine as ENUM('ITALIAN', 'BRITISH', 'MEXICAN', 'AMERICAN', 'INDIAN', 'JAPANESE', 'KOREAN', 'FRENCH', 'CHINESE', 'GERMAN', 'THAI', 'VIETNAM', 'ARABIC', 'JAMAICAN', 'SWEDISH', 'UZBEK');
CREATE TYPE meal_type as ENUM('BREAKFAST', 'LUNCH', 'DINNER', 'SNACK', 'DESSERT');
CREATE TYPE spice_rating as ENUM('HOT', 'MEDIUM', 'MILD', 'SWEET');

CREATE TABLE ingredients (
    id BIGSERIAL PRIMARY KEY,
    iname TEXT UNIQUE NOT NULL,
    allergy_category TEXT
);

CREATE TABLE recipes (
    id BIGSERIAL PRIMARY KEY,
    rname TEXT UNIQUE NOT NULL,
    cuisine cuisine,
    vegetarian BOOLEAN,
    vegan BOOLEAN,
    meat_only BOOLEAN,
    pescatarian BOOLEAN,
    meal_type meal_type,
    spice_rating spice_rating,
    cooking_time_mins INT NOT NULL,
    instructions TEXT NOT NULL

);

CREATE TABLE recipes_ingredients (
    id BIGSERIAL PRIMARY KEY,
    recipe_id INT REFERENCES recipes(id),
    ingredient_id INT REFERENCES ingredients(id)
);