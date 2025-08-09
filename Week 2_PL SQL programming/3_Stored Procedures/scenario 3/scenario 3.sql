CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);
INSERT INTO accounts VALUES (401, 'Koushika', 8000);
INSERT INTO accounts VALUES (402, 'Madhu', 3000);
COMMIT;
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amount IN NUMBER
) IS
BEGIN
  UPDATE accounts
  SET balance = balance - amount
  WHERE acc_no = from_acc AND balance >= amount;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance or invalid source account.');
  END IF;

  UPDATE accounts
  SET balance = balance + amount
  WHERE acc_no = to_acc;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Invalid destination account.');
  END IF;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
--example usage
EXEC TransferFunds(401, 402, 1000);
