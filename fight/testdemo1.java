import java.util.LinkedList;
import java.util.Stack;

public class testdemo1 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void add(int val){
        stack1.push(val);
    }
    public static void main(String[] args) {
      
    }
    public static void delete(){
        while (!stack1.isEmpty()){
            stack2.push( stack1.pop());
        }
        stack2.pop();
    }
}
