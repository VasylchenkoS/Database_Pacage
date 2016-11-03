--liquibase formatted sql
--changeset v.vasylchenko:functions runOnChange:true failOnError:true

CREATE OR REPLACE FUNCTION add_dish(ord INT, sur VARCHAR(20)) returns void as
$$
DECLARE
  s INT :=0;
BEGIN
  FOR s in (SELECT id_dish FROM order_dish WHERE id_order = (SELECT max(id_order)FROM ordering))
  LOOP
    INSERT INTO kitchen (id_employee, id_order, date, dishstate, id_dish) VALUES
      ((SELECT employee.id_employee FROM employee WHERE surname = sur),
       (SELECT ID_Order FROM Ordering WHERE id_order = ord),
       now(),'DEFERRED', s);
  END LOOP;
END;
$$
LANGUAGE plpgsql;
