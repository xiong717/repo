import java.util.HashSet;
import java.util.Scanner;

public class mapset {

    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count =0;

        for(char ch:jewels.toCharArray()){
            set.add(ch);
        }

        for(char ch : stones.toCharArray()){
            if(set.contains(ch)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char ch: str2.toUpperCase().toCharArray()
             ) {
            set.add(ch);
        }

        for (char ch : str1.toUpperCase().toCharArray()
             ) {
            if (!set.contains(ch)){

                set2.add(ch);
            }
        }
        System.out.println(set2);
    }

    String[] a = null;
    String[] B = null;
    

}
