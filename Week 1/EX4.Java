public class FinancialForecasting {

    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double result1 = futureValue(presentValue, growthRate, years);
        System.out.println("Future value (recursive): " + result1);

        double[] memo = new double[years + 1];
        double result2 = futureValueMemo(presentValue, growthRate, years, memo);
        System.out.println("Future value (memoized): " + result2);
    }
}
