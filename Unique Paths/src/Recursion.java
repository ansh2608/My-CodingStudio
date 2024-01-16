public class Recursion {
    public static int helper(int m, int n){
        if (m==0 && n==0) return 1;
        if (m<0 || n<0) return 0;
        int left=helper(m-1,n);
        int up=helper(m,n-1);
        return left+up;
    }
    public static int uniquePaths(int m, int n) {
        return helper(m,n);
    }
    public static void main(String[] args) {
        int m=2,n=2;
        System.out.println(uniquePaths(m,n));
    }
}
