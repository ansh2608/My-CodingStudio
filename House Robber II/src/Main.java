public class Main {
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 0) return 0;
        if (n == 1) return valueInHouse[0];
        return Math.max(f(valueInHouse, 0, n - 1), f(valueInHouse, 1, n));
    }
    public static long f(int[] valueInHouse, int lo, int hi) {
        long[] value = new long[valueInHouse.length];
        if (lo == 0) {
            value[0] = valueInHouse[0];
            value[1] = Math.max(valueInHouse[0], valueInHouse[1]);
        }
        else {
            value[0] = 0;
            value[1] = valueInHouse[1];
        }
        for (int i = 2; i < hi; i++) value[i] = Math.max(value[i - 2] + valueInHouse[i], value[i - 1]);
        return value[hi - 1];
    }
    public static void main(String[] args) {
        int[] arr={1,3,2,0};
        System.out.println(houseRobber(arr));
    }
}