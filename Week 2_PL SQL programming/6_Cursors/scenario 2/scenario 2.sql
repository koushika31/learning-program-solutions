DECLARE
  CURSOR txn_cursor IS
    SELECT acc_no, txn_type, amount, txn_date
    FROM transactions
    WHERE TO_CHAR(txn_date, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY');
  
  v_acc_no transactions.acc_no%TYPE;
  v_type transactions.txn_type%TYPE;
  v_amt transactions.amount%TYPE;
  v_date transactions.txn_date%TYPE;
BEGIN
  OPEN txn_cursor;
  LOOP
    FETCH txn_cursor INTO v_acc_no, v_type, v_amt, v_date;
    EXIT WHEN txn_cursor%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('Account: ' || v_acc_no || ' | Type: ' || v_type || ' | Amount: ' || v_amt || ' | Date: ' || TO_CHAR(v_date, 'DD-Mon-YYYY'));
  END LOOP;
  CLOSE txn_cursor;
END;
/
