import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day3 {
    public static void moveZeroes(int[] nums) {
        int j =0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] !=0) {
                nums[j]=nums[i];
                j++;
            }
        }

        for(int i = j+1; i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main1(String[] args) {
        int[] nums = {0,1,0,3,13};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2){
            return null;
        }
        for(int i =0; i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                if((numbers[i]+numbers[j])== target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int n  = 9;
        int[] arr = twoSum(nums,n);
        System.out.println(Arrays.toString(arr));
    }
}




