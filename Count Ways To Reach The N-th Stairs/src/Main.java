public class Main {
    public static int countDistinctWayToClimbStair(long nStairs) {
        int pp=1,p=1;
        for(int i=2;i<=nStairs;i++){
            int curr=(pp+p)%1000000007;
            pp=p;
            p=curr;
        }
        return p;
    }
    public static void main(String[] args) {
        long n=51;
        System.out.println(countDistinctWayToClimbStair(n));
    }
}