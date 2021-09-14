import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class testdemo2 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        int count = 0;
        while (cur!=null){
            stack.push(cur.val);
            cur = cur.next;
            count++;
        }
        int[] arr = new int[count];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,7,4,2,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
       /* HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,111);
        System.out.println(map.get(1));//111*/
    }

    //复杂一个复杂链表
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return  head;
    }
}
