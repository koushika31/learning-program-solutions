CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(100),
  salary NUMBER
);
INSERT INTO employees VALUES (201, 'Siva', 40000);
COMMIT;

CREATE OR REPLACE PROCEDURE UpdateSalary(
  emp_id_in IN NUMBER,
  percent IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * percent / 100)
  WHERE emp_id = emp_id_in;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20003, 'Employee ID not found.');
  END IF;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Salary update failed: ' || SQLERRM);
END;
/

EXEC UpdateSalary(201, 10);
