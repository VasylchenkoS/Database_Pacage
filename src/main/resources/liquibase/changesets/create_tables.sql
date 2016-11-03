--liquibase formatted sql
--changeset v.vasylchenko:create_tables runOnChange:true failOnError:true

CREATE TABLE Storage(
  ID_Ingridient       SERIAL PRIMARY KEY     NOT NULL,
  Ingredient  VARCHAR(50)    NOT NULL UNIQUE ,
  Quantity    INT
);

CREATE TABLE Dish(
  ID_Dish          SERIAL PRIMARY KEY     NOT NULL,
  Name  VARCHAR(50) NOT NULL UNIQUE,
  Category VARCHAR(50),
  Price DOUBLE PRECISION,
  Weigth REAL
);

CREATE TABLE Menu(
  ID_Menu          SERIAL PRIMARY KEY     NOT NULL ,
  Name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Employee(
  ID_Employee          SERIAL PRIMARY KEY     NOT NULL,
  Surname VARCHAR(50) NOT NULL,
  Name VARCHAR(50) NOT NULL ,
  Birth DATE,
  Phone VARCHAR(50),
  Position VARCHAR(50),
  Salary REAL,
  dtype VARCHAR(15)
);

CREATE TABLE TableSit(
  ID_Table          SERIAL PRIMARY KEY     NOT NULL,
  Number VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Ordering(
  ID_Order          SERIAL PRIMARY KEY     NOT NULL,
  ID_Employee INT NOT NULL,
  ID_Table INT,
  Date DATE NOT NULL,
  State VARCHAR(10) DEFAULT 'DEFERRED'
);

CREATE TABLE Kitchen(
  ID_Kitchen          SERIAL PRIMARY KEY     NOT NULL,
  ID_Employee INT NOT NULL,
  ID_Order INT,
  Date DATE NOT NULL,
  DishState  VARCHAR(10) DEFAULT 'DEFERRED',
  ID_Dish int,
  dtype VARCHAR(15)
);

CREATE TABLE menu_dish(
  ID_Menu INT,
  ID_Dish INT
);

CREATE TABLE order_dish(
  ID_Order INT NOT NULL,
  ID_Dish INT NOT NULL
);

CREATE TABLE dish_ingredients(
  ID_Dish     INT NOT NULL ,
  ID_Ingridient INT NOT NULL
);