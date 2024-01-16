public class Main {
    public static String binary(int n){
        StringBuilder sb=new StringBuilder();
        while (n>0){
            int rem=n%2;
            sb.insert(0,rem);
            n/=2;
        }
        return sb.toString();
    }
    public static boolean checkBits(int n) {
        String ans=binary(n);
        for (int i=0;i<ans.length()-1;i++) if (ans.charAt(i) == ans.charAt(i+1)) return false;
        return true;
    }
    public static void main(String[] args) {
        int n=42;
        System.out.println(checkBits(n));
    }
}