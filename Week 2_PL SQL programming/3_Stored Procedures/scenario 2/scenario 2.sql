CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(100),
  department VARCHAR2(50),
  salary NUMBER
);
INSERT INTO employees VALUES (301, 'Siva', 'IT', 50000);
INSERT INTO employees VALUES (302, 'Arun', 'HR', 40000);
INSERT INTO employees VALUES (303, 'Meena', 'IT', 55000);
COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * bonus_percent / 100)
  WHERE department = dept_name;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || dept_name || ' department.');
END;
/
EXEC UpdateEmployeeBonus('IT', 10);
