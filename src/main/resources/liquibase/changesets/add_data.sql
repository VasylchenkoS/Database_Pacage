--liquibase formatted sql
--changeset v.vasylchenko:add_data runOnChange:true failOnError:true

INSERT INTO Menu(name) VALUES
  ('WinterMenu'), ('SpringMenu'),('SummerMenu'),('AutumnMenu');


INSERT INTO Employee (Surname, Name, Birth, Phone, position, Salary) VALUES
  ('Kogan','Igor','1968-05-23','651-48-47', 'DIRECTOR',35000),
  ('Herkku','Wartian','1988-05-23','652-23-42', 'MANAGER',25000),
  ('Importadora','Wellington','1982-05-23','234-35-684', 'COOK',20000),
  ('Koskitalo','Pirkko','1994-05-23','135-48-47', 'COOK',20000),
  ('Parente','Paula','1995-05-23','035-35-15', 'WAITER',15000),
  ('Jablonski','Karl','1999-05-23','864-18-48', 'WAITER',15000),
  ('Zbyszek','Wolski','1978-05-23','186-35-64', 'CLEANER',5000);

INSERT INTO TableSit (Number) VALUES
  ('#1'), ('#2'), ('#3'), ('#4'), ('#5'), ('#6'), ('#7'), ('#8'), ('#9'), ('#10');

INSERT INTO Storage (Ingredient, Quantity) VALUES
  ('Water',5000), ('Salt',5000), ('Sugar', 5000),('Sauce', 5000),
  ('Fish', 10), ('Meat', 20), ('Vegetables', 50), ('Fruits',70), ('Snacks',50),
  ('Alcohol', 40), ('Juice', 40), ('Beer',70);

INSERT INTO Dish (Name, Category, Price, Weigth) VALUES
  ('Soup','HOT_DISH',25.50,0.350),
  ('Free Potato','HOT_DISH',32,0.250),
  ('French Meat','HOT_DISH',79.30,0.750),
  ('Gold Fish','HOT_DISH',130,1.150),
  ('Caprize','SALAD',50,0.250),
  ('Summer Salad','SALAD',35,0.350),
  ('Chips','SNACK',25,0.150),
  ('Cheese Free','SNACK',45,0.450),
  ('Absolute','ALCOHOL',450,1.000),
  ('Hennesy','ALCOHOL',1350,0.750),
  ('Red Label','ALCOHOL',750,1.000),
  ('Leaf 0,33','ALCOHOL',75,0.330),
  ('Leaf 0,5','ALCOHOL',120,0.500),
  ('Hoegaarden 0,5','ALCOHOL',120,0.500);

INSERT INTO menu_dish(id_menu, id_dish) VALUES
  ((SELECT id_menu FROM menu WHERE name='WinterMenu'), (SELECT id_dish FROM dish WHERE name='Soup')),
  ((SELECT id_menu FROM menu WHERE name='WinterMenu'), (SELECT id_dish FROM dish WHERE name='Gold Fish')),
  ((SELECT id_menu FROM menu WHERE name='WinterMenu'), (SELECT id_dish FROM dish WHERE name='Chips')),
  ((SELECT id_menu FROM menu WHERE name='WinterMenu'), (SELECT id_dish FROM dish WHERE name='Absolute')),
  ((SELECT id_menu FROM menu WHERE name='SpringMenu'), (SELECT id_dish FROM dish WHERE name='Soup')),
  ((SELECT id_menu FROM menu WHERE name='SpringMenu'), (SELECT id_dish FROM dish WHERE name='French Meat')),
  ((SELECT id_menu FROM menu WHERE name='SpringMenu'), (SELECT id_dish FROM dish WHERE name='Chips')),
  ((SELECT id_menu FROM menu WHERE name='SpringMenu'), (SELECT id_dish FROM dish WHERE name='Hennesy')),
  ((SELECT id_menu FROM menu WHERE name='SummerMenu'), (SELECT id_dish FROM dish WHERE name='Summer Salad')),
  ((SELECT id_menu FROM menu WHERE name='SummerMenu'), (SELECT id_dish FROM dish WHERE name='Free Potato')),
  ((SELECT id_menu FROM menu WHERE name='SummerMenu'), (SELECT id_dish FROM dish WHERE name='Leaf 0,5')),
  ((SELECT id_menu FROM menu WHERE name='SummerMenu'), (SELECT id_dish FROM dish WHERE name='Leaf 0,5')),
  ((SELECT id_menu FROM menu WHERE name='AutumnMenu'), (SELECT id_dish FROM dish WHERE name='Soup')),
  ((SELECT id_menu FROM menu WHERE name='AutumnMenu'), (SELECT id_dish FROM dish WHERE name='French Meat')),
  ((SELECT id_menu FROM menu WHERE name='AutumnMenu'), (SELECT id_dish FROM dish WHERE name='Cheese Free')),
  ((SELECT id_menu FROM menu WHERE name='AutumnMenu'), (SELECT id_dish FROM dish WHERE name='Hoegaarden 0,5'))
;


 INSERT INTO dish_ingredients (ID_Dish, ID_Ingridient) VALUES
  ((SELECT ID_Dish FROM Dish WHERE Name='Soup'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Water')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Soup'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Salt')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Soup'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Meat')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Soup'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Vegetables')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Free Potato'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Salt')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Free Potato'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Vegetables')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Free Potato'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Sauce')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Gold Fish'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Salt')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Gold Fish'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Fish')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Gold Fish'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Vegetables')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Gold Fish'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Sauce')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Summer Salad'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Salt')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Summer Salad'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Vegetables')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Summer Salad'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Sauce')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Caprize'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Salt')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Caprize'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Vegetables')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Caprize'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Sauce')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Chips'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Snacks')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Cheese Free'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Snacks')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Absolute'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Alcohol')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Hennesy'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Alcohol')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Red Label'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Alcohol')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Leaf 0,33'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Beer')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Leaf 0,5'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Beer')),
  ((SELECT ID_Dish FROM Dish WHERE Name='Hoegaarden 0,5'), (SELECT ID_Ingridient FROM Storage WHERE Ingredient='Beer'));

INSERT INTO Ordering (ID_Employee, ID_Table, Date, "state") VALUES (
  (SELECT ID_Employee FROM Employee WHERE
    position='WAITER' AND Surname='Jablonski'),
  (SELECT ID_Table FROM TableSit WHERE Number='#1'), NOW(), 'OPEN'
);

INSERT INTO order_dish (ID_Order, ID_Dish) VALUES
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Soup')),
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Caprize')),
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Leaf 0,5'));

INSERT INTO Ordering (ID_Employee, ID_Table, Date, "state") VALUES (
  (SELECT ID_Employee FROM Employee WHERE
    position='WAITER' AND Surname='Parente'),
  (SELECT ID_Table FROM TableSit WHERE Number='#2'), NOW(), 'OPEN'
);
INSERT INTO order_dish (ID_Order, ID_Dish) VALUES
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Free Potato')),
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Summer Salad')),
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Hennesy'));

INSERT INTO Ordering (ID_Employee, ID_Table, Date, "state") VALUES (
  (SELECT ID_Employee FROM Employee WHERE
    position='WAITER' AND Surname='Jablonski'),
  (SELECT ID_Table FROM TableSit WHERE Number='#3'), NOW(), 'CLOSED'
);

INSERT INTO order_dish (ID_Order, ID_Dish) VALUES
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Free Potato')),
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Gold Fish')),
  ((SELECT id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Red Label'));

INSERT INTO Ordering (ID_Employee, ID_Table, Date, "state") VALUES (
  (SELECT ID_Employee FROM Employee WHERE
    position='WAITER' AND Surname='Parente'),
  (SELECT ID_Table FROM TableSit WHERE Number='#4'), NOW(), 'CLOSED'
);

INSERT INTO order_dish (ID_Order, ID_Dish) VALUES
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Chips')),
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Cheese Free')),
  ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Hennesy')) ,
   ((SELECT ordering.id_order FROM ordering WHERE id_order = (SELECT max(id_order)FROM ordering)),
   (SELECT ID_Dish FROM Dish WHERE Name='Absolute'));

SELECT add_dish((SELECT min(id_order)FROM ordering),'Importadora');
SELECT add_dish((SELECT max(id_order)FROM ordering),'Koskitalo');