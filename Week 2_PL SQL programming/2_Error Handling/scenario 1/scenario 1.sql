CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);
INSERT INTO accounts VALUES (101, 'Koushika', 5000);
INSERT INTO accounts VALUES (102, 'Madhu', 3000);
COMMIT;
CREATE OR REPLACE PROCEDURE AddNewCustomer(
  id IN NUMBER,
  cname IN VARCHAR2,
  cage IN NUMBER,
  cbalance IN NUMBER
) IS
BEGIN
  INSERT INTO customers(customer_id, name, age, balance, IsVIP)
  VALUES (id, cname, cage, cbalance, 'FALSE');

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Insertion failed: ' || SQLERRM);
END;
/

