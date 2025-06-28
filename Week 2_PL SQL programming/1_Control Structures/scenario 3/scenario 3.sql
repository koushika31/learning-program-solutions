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
  due_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
/

INSERT INTO customers VALUES (1, 'Koushika', 65);
INSERT INTO customers VALUES (2, 'Madhu', 45);
INSERT INTO customers VALUES (3, 'Siva', 70);

INSERT INTO loans VALUES (101, 1, 9.5, SYSDATE + 20);
INSERT INTO loans VALUES (102, 2, 8.5, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 10.0, SYSDATE + 10);
COMMIT;
/

BEGIN
  FOR rec IN (
    SELECT c.name, l.due_date 
    FROM customers c 
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE l.due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.name || ' has a loan due on ' || TO_CHAR(rec.due_date, 'DD-Mon-YYYY'));
  END LOOP;
END;
/
