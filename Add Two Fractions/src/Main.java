public class Main {
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long[] addFraction(int a, int b, int c, int d) {
        long[] ans = new long[2];
        ans[0] = a * (long) d + b * (long) c;
        ans[1] = b * (long) d;

        // Finding the greatest common divisor
        long gcd = gcd(ans[0], ans[1]);

        // Simplifying the fraction
        ans[0] /= gcd;
        ans[1] /= gcd;

        return ans;
    }

    public static void main(String[] args) {
        int a = 1, b = 500, c = 2, d = 1500;
        long[] ans = addFraction(a, b, c, d);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
