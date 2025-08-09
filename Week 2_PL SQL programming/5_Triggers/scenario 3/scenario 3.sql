CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);
CREATE TABLE transactions (
  txn_id NUMBER PRIMARY KEY,
  acc_no NUMBER,
  txn_type VARCHAR2(20),
  amount NUMBER,
  txn_date DATE
);
INSERT INTO accounts VALUES (401, 'Koushika', 8000);
COMMIT;
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
  acc_balance NUMBER;
BEGIN
  SELECT balance INTO acc_balance
  FROM accounts
  WHERE acc_no = :NEW.acc_no;

  IF :NEW.txn_type = 'withdraw' AND :NEW.amount > acc_balance THEN
    RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds current balance.');
  END IF;

  IF :NEW.txn_type = 'deposit' AND :NEW.amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
  END IF;

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20003, 'Account not found.');
END;
/
--example usage
INSERT INTO transactions VALUES (1001, 401, 'deposit', 1000, SYSDATE);
--view
SELECT * FROM loans;
