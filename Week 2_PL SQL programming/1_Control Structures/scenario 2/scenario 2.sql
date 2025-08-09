BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER,
  balance NUMBER,
  IsVIP VARCHAR2(5)
);
/

INSERT INTO customers VALUES (1, 'Koushika', 65, 12000, 'FALSE');
INSERT INTO customers VALUES (2, 'Madhu', 45, 8000, 'FALSE');
INSERT INTO customers VALUES (3, 'Siva', 70, 15000, 'FALSE');
COMMIT;
/

BEGIN
  FOR cust IN (SELECT customer_id FROM customers WHERE balance > 10000) LOOP
    UPDATE customers
    SET IsVIP = 'TRUE'
    WHERE customer_id = cust.customer_id;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/

SELECT * FROM customers;
