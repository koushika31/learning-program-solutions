SET SERVEROUTPUT ON;
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
/

CREATE TABLE employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);
/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2,
    p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE
  );

  PROCEDURE UpdateEmployeeSalary(p_id NUMBER, p_new_salary NUMBER);

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2,
    p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE
  ) IS
  BEGIN
    INSERT INTO employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_department, p_hiredate);
  END;

  PROCEDURE UpdateEmployeeSalary(p_id NUMBER, p_new_salary NUMBER) IS
  BEGIN
    UPDATE employees
    SET Salary = p_new_salary
    WHERE EmployeeID = p_id;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
      RETURN NULL;
  END;

END EmployeeManagement;
/

BEGIN
  EmployeeManagement.HireEmployee(3, 'Siva', 'Analyst', 50000, 'Finance', SYSDATE);
END;
/

BEGIN
  EmployeeManagement.UpdateEmployeeSalary(3, 55000);
END;
/

DECLARE
  v_annual NUMBER;
BEGIN
  v_annual := EmployeeManagement.GetAnnualSalary(3);
  IF v_annual IS NOT NULL THEN
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual);
  END IF;
END;
/
