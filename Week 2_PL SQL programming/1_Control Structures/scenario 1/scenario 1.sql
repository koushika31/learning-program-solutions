SET SERVEROUTPUT ON;
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/
CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER
);
/
CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  interest_rate NUMBER,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
/
INSERT INTO customers VALUES (1, 'Koushika', 65);
INSERT INTO customers VALUES (2, 'Madhu', 45);
INSERT INTO customers VALUES (3, 'Siva', 70);

INSERT INTO loans VALUES (101, 1, 9.5);
INSERT INTO loans VALUES (102, 2, 8.5);
INSERT INTO loans VALUES (103, 3, 10.0);
COMMIT;
/
BEGIN
  FOR cust IN (SELECT customer_id FROM customers WHERE age > 60) LOOP
    UPDATE loans
    SET interest_rate = interest_rate - 1
    WHERE customer_id = cust.customer_id;
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers above 60.');
END;
/
--view
SELECT * FROM loans;
