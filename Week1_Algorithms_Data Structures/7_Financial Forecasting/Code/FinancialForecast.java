import java.util.Scanner;
public class FinancialForecast {
    static double predictFutureValue(double current, double percent, int years) {
        if (years == 0)
            return current;
        double growth = 1 + (percent / 100);
        return predictFutureValue(current * growth, percent, years - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter current amount (₹): ");
        double amount = sc.nextDouble();
        System.out.print("Enter annual growth percentage (e.g., 10 for 10%): ");
        double percent = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();
        double futureValue = predictFutureValue(amount, percent, years);
        System.out.printf("\nFuture value after %d years: ₹%.2f\n", years, futureValue);
        sc.close();
    }
}
