public class Main {
    public static int search(int[] nums, int target) {
        int i=0,j=nums.length-1,ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                ans=mid;
                break;
            }
            else if(nums[mid]<=target) i=mid+1;
            else j=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {3, 12, 18, 28, 29, 30, 35, 36, 40, 45 };
        int n=3;
        System.out.println(search(A,n));
    }
}