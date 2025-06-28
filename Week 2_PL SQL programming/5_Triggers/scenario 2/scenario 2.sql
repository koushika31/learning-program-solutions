CREATE TABLE transactions (
  txn_id NUMBER PRIMARY KEY,
  acc_no NUMBER,
  txn_type VARCHAR2(20),
  amount NUMBER,
  txn_date DATE
);
CREATE TABLE audit_log (
  log_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  txn_id NUMBER,
  log_time DATE,
  action VARCHAR2(50)
);
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
  INSERT INTO audit_log (txn_id, log_time, action)
  VALUES (:NEW.txn_id, SYSDATE, 'Transaction Inserted');
END;
/
--example usage
INSERT INTO transactions VALUES (1001, 401, 'deposit', 2000, SYSDATE);
SELECT * FROM audit_log;
