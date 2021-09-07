public class day4 {
    public void reverseString(char[] s) {
        int left =0;
        int right = s.length-1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] =  tmp;
            left++;
            right--;
        }
    }

    public static void reverse(char[] s,int left ,int right) {
        while(left <= right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] =  tmp;
            left++;
            right--;
        }
    }

    public static String reverseWords(String s) {
       char[] chars = s.toCharArray();
       int left = 0;
       int right = 0;
        for (int i = 0; i <chars.length ; i++) {
            while (chars[i] == ' '){
                right = i-1;
                reverse(chars,left,right);
                left = i+1;
                i++;
            }
            reverse(chars,left,chars.length-1);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "i love you";
        System.out.println(reverseWords2(s));
    }

    public static String reverseWords2(String s) {
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        StringBuffer s1 = new StringBuffer();
        for(int i=0;i<strs.length;i++){
            String s2 = new StringBuffer(strs[i]).reverse().toString();
            if(i != strs.length-1){
                s1.append(s2+" ");
            }else{
                s1.append(s2);
            }

        }
        return s1.toString();
    }
}
