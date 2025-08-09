CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER,
  balance NUMBER,
  IsVIP VARCHAR2(5),
  LastModified DATE
);
INSERT INTO customers VALUES (1, 'Koushika', 25, 12000, 'FALSE', SYSDATE);
COMMIT;
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/
--example usage
UPDATE customers SET balance = balance + 1000 WHERE customer_id = 1;
SELECT * FROM customers WHERE customer_id = 1;
