public class Recursion {
    public static int helper(int day,int last,int[][] points){
        if (day==0){
            int max=0;
            for (int task=0;task<3;task++) {
                if (task!=last) max=Math.max(max,points[0][task]);
            }
            return max;
        }
        int max=0;
        for (int task=0;task<3;task++) {
            if (task!=last) {
                int point=points[day][task]+helper(day-1,task,points);
                max=Math.max(max,point);
            }
        }
        return max;

    }
    public static int ninjaTraining(int n, int[][] points) {

        return helper(n-1,3,points);
    }
    public static void main(String[] args) {
        int n=3;
        int[][] points={{10,40,70},{20,50,80},{30,60,90}};
        System.out.println(ninjaTraining(n,points));
    }
}
