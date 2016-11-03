--liquibase formatted sql
--changeset v.vasylchenko:alter_table runOnChange:true failOnError:true

ALTER TABLE ordering
ADD CONSTRAINT FK_Employee FOREIGN KEY (ID_Employee) REFERENCES Employee(ID_Employee)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ordering
ADD CONSTRAINT FK_Table FOREIGN KEY (ID_Table) REFERENCES TableSit(ID_Table)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE kitchen
ADD CONSTRAINT FK_Employee FOREIGN KEY (ID_Employee) REFERENCES Employee(ID_Employee)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE kitchen
ADD CONSTRAINT FK_Order FOREIGN KEY (ID_Order) REFERENCES Ordering(ID_Order)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE kitchen
    ADD CONSTRAINT fk_dish FOREIGN KEY (id_dish) REFERENCES dish(id_dish)
    MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE dish_ingredients
ADD CONSTRAINT FK_dish FOREIGN KEY (ID_Dish)  REFERENCES Dish(ID_Dish)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE dish_ingredients
ADD CONSTRAINT FK_ingredients FOREIGN KEY (ID_Ingridient)  REFERENCES Storage(ID_Ingridient)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE ;

ALTER TABLE menu_dish
ADD CONSTRAINT FK_Dish FOREIGN KEY (ID_Dish) REFERENCES Dish(ID_Dish)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE ;

ALTER TABLE menu_dish
ADD CONSTRAINT FK_Menu FOREIGN KEY (ID_Menu) REFERENCES Menu(ID_Menu)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE order_dish
ADD CONSTRAINT FK_Dish FOREIGN KEY (ID_Dish) REFERENCES Dish(ID_Dish)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE ;

ALTER TABLE order_dish
ADD CONSTRAINT FK_Order FOREIGN KEY (ID_Order) REFERENCES Ordering(ID_Order)
MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE ;