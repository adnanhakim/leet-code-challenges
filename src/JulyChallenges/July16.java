package JulyChallenges;

/*
July 16

Question: Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (xn).

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
*/

class July16 {
    public double myPow(double x, int n) {
        boolean negativePower = n < 0;

        double result = pow(x, Math.abs((double) n));

        if (negativePower)
            return 1 / result;

        return result;
    }

    public double pow(double x, double n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0) {
            double y = pow(x, n / 2);
            return y * y;
        } else {
            double y = pow(x, n - 1);
            return x * y;
        }
    }
}
