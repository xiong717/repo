import java.util.Arrays;

public class day2 {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length;i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void rotate(int[] nums, int k) {
        int[] arr = reverse(nums,0,nums.length-1);
        int[] arr2 = reverse(arr,0,k-1);
        int[] arr3 = reverse(arr2,k,nums.length-1);
        System.out.println(Arrays.toString(arr3));
    }
    public static int[] reverse(int[] nums,int left,int right) {

        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);

    }
}
