CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  acc_id IN NUMBER,
  amount IN NUMBER
)
RETURN BOOLEAN IS
  acc_balance NUMBER;
BEGIN
  SELECT balance INTO acc_balance FROM accounts WHERE acc_no = acc_id;
  RETURN acc_balance >= amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/
--example usage
DECLARE
  result BOOLEAN;
BEGIN
  result := HasSufficientBalance(401, 2000);
  IF result THEN
    DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
  END IF;
END;
/
