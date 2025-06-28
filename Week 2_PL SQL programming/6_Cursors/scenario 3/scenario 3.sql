CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  interest_rate NUMBER,
  due_date DATE
);
INSERT INTO loans VALUES (301, 1, 9.5, SYSDATE + 180);
INSERT INTO loans VALUES (302, 2, 8.0, SYSDATE + 90);
COMMIT;
DECLARE
  CURSOR loan_cursor IS
    SELECT loan_id, interest_rate FROM loans;
  v_loan_id loans.loan_id%TYPE;
  v_rate loans.interest_rate%TYPE;
BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_rate;
    EXIT WHEN loan_cursor%NOTFOUND;
    UPDATE loans
    SET interest_rate = v_rate + 0.5
    WHERE loan_id = v_loan_id;
    DBMS_OUTPUT.PUT_LINE('Updated interest for Loan ID: ' || v_loan_id);
  END LOOP;
  CLOSE loan_cursor;
  COMMIT;
END;
/
--view
SELECT * FROM loans;
