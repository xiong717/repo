import java.util.Arrays;
import java.util.HashSet;

public class testdemo3 {
    public String replaceSpace1(String s) {
          return s.replace(" ","%20");
    }
    public String replaceSpace2(String s) {
       String[] strings = s.split(" ");
       String ret = "";
        for (int i = 0; i <strings.length ; i++) {
             ret += (strings[i] + "%20");
        }
        return ret.substring(0,ret.length()-3);

    }

    public static String reverseLeftWords1(String s, int n) {
       /* StringBuffer str = new StringBuffer(s.substring(0,n));
        s = s.substring(n,s.length())+str;
        return s;*/
        return s.substring(n)+s.substring(0,n);
    }

    public static String reverse(String s,int left,int right){
        char[] ss = s.toCharArray();
        while(left < right){
            char tmp = ss[left];
            ss[left] = ss[right];
            ss[right] = tmp;
            left++;
            right--;
        }
        return new String(ss);
    }
    public static String reverseLeftWords(String s, int n) {
        String s1 = reverse(s,0,n-1);
        String s2 = reverse(s1,n,s.length()-1);
        String s3 = reverse(s2,0,s1.length()-1);
        return s3;
    }
    public static void main3(String[] args) {
        String s = "abcdefg";
        String ret = reverseLeftWords(s,2);
        System.out.println(ret);
    }
    public int findRepeatNumber2(int[] nums) {
        int count=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i< nums.length;i++){
           if (set.contains(nums[i])){
               return nums[i];
           }else {
               set.add(nums[i]);
           }
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        for(; i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,9,20,2,9};
        System.out.println(findRepeatNumber1(nums));
    }
}
