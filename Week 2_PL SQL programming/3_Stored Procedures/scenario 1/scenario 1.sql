CREATE TABLE savings_accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);
INSERT INTO savings_accounts VALUES (201, 'Koushika', 10000);
INSERT INTO savings_accounts VALUES (202, 'Madhu', 15000);
COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE savings_accounts
  SET balance = balance + (balance * 0.01);
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Monthly interest applied successfully.');
END;
/
EXEC ProcessMonthlyInterest;
