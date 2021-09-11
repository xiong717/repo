import java.util.Arrays;
import java.util.HashMap;

public class tongcheng58 {
    //重复相加各个数位的数 直到是个位数 12345 1+2+3+4+5=16 1+6=7
    public static int digitsRecursive (int num) {
        // write code here
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num = num/10;
        }
        int ret = sum;
        if(ret >= 10){
            return digitsRecursive(ret);
        }else{
            return sum;
        }
    }

    public static void main1(String[] args) {
        int num = 123456;
        System.out.println(digitsRecursive(num));
    }

    //给定一个数组 找出数组最后一个出现一次的数
    public static int solution (int[] source) {
        // write code here
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
           if (map.containsKey(source[i])) {
               int n = map.get(source[i]);
               map.put(source[i],n+1);
           }else {
               map.put(source[i],1);
           }
        }
        for (int i = source.length-1; i >=0 ; i--) {
            if (map.get(source[i]) == 1) {
                count = i;
                break;
            }
        }
        return source[count];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,7,7,7,8,8};
        System.out.println(solution(nums));
    }

}
