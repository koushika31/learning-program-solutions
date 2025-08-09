SET SERVEROUTPUT ON;
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
/

CREATE TABLE accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  LastModified DATE
);
/

CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_accID NUMBER, p_custID NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_accID NUMBER);
  FUNCTION GetTotalBalance(p_custID NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_accID NUMBER, p_custID NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_accID, p_custID, p_type, p_balance, SYSDATE);
  END;
  PROCEDURE CloseAccount(p_accID NUMBER) IS
  BEGIN
    DELETE FROM accounts WHERE AccountID = p_accID;
  END;

  FUNCTION GetTotalBalance(p_custID NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT NVL(SUM(Balance), 0) INTO v_total
    FROM accounts
    WHERE CustomerID = p_custID;
    RETURN v_total;
  END;

END AccountOperations;
/
BEGIN
  AccountOperations.OpenAccount(101, 1, 'Savings', 2500);
  AccountOperations.OpenAccount(102, 1, 'Checking', 1500);
END;
/

DECLARE
  v_balance NUMBER;
BEGIN
  v_balance := AccountOperations.GetTotalBalance(1);
  DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 1: ' || v_balance);
END;
/

BEGIN
  AccountOperations.CloseAccount(102);
END;
/
DECLARE
  v_balance NUMBER;
BEGIN
  v_balance := AccountOperations.GetTotalBalance(1);
  DBMS_OUTPUT.PUT_LINE('Balance after closing one account: ' || v_balance);
END;
/
