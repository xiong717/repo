class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class day5 {
    public ListNode middleNode(ListNode head) {
        //把链表中的值 存进 结点数组中
        ListNode[] A = new ListNode[1000];
        int i=0;
        while(head!=null){
            A[i] = head;
            i++;
            head = head.next;
        }
        return A[i/2];
    }

    public  static  ListNode middleNode2(ListNode head) {
        //两次遍历
        int count = 0;
        ListNode cur = head;
        while(cur!=null) {
            count++;
            cur = cur.next;
        }
        int k =0;
        while(k < count/2) {
            k++;
            head = head.next;
        }
        return head;
    }
    public static void main(String[] args) {
      ListNode listNode1 = new ListNode(1);
      ListNode listNode2 = new ListNode(2);
      ListNode listNode3 = new ListNode(3);
      ListNode listNode4 = new ListNode(4);
      ListNode listNode5 = new ListNode(5);
      ListNode listNode6 = new ListNode(6);
      listNode1.next = listNode2;
      listNode2.next = listNode3;
      listNode3.next = listNode4;
      listNode4.next = listNode5;
      listNode5.next = listNode6;
        ListNode ret = middleNode2(listNode1);
        System.out.println(ret.val);

    }
}
