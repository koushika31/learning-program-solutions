CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  amount NUMBER,
  annual_rate NUMBER,
  years NUMBER
)
RETURN NUMBER IS
  monthly_rate NUMBER;
  n NUMBER;
  emi NUMBER;
BEGIN
  monthly_rate := annual_rate / 12 / 100;
  n := years * 12;
  emi := (amount * monthly_rate * POWER(1 + monthly_rate, n)) /
         (POWER(1 + monthly_rate, n) - 1);
  RETURN ROUND(emi, 2);
END;
/
--example
SELECT CalculateMonthlyInstallment(100000, 10, 2) AS emi FROM dual;
