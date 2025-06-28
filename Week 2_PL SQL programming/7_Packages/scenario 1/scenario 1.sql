CREATE TABLE customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER,
  LastModified DATE
);
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomerBalance(p_id NUMBER, p_new_balance NUMBER);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
  END;
  PROCEDURE UpdateCustomerBalance(p_id NUMBER, p_new_balance NUMBER) IS
  BEGIN
    UPDATE customers
    SET Balance = p_new_balance, LastModified = SYSDATE
    WHERE CustomerID = p_id;
  END;
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM customers WHERE CustomerID = p_id;
    RETURN v_balance;
  END;
END CustomerManagement;
/
--test
BEGIN
  CustomerManagement.AddCustomer(3, 'Koushika', TO_DATE('1999-01-01','YYYY-MM-DD'), 2000);
END;
/

BEGIN
  CustomerManagement.UpdateCustomerBalance(3, 2500);
END;
/

DECLARE
  v_bal NUMBER;
BEGIN
  v_bal := CustomerManagement.GetCustomerBalance(3);
  DBMS_OUTPUT.PUT_LINE('Customer 3 Balance: ' || v_bal);
END;
/
