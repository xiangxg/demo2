package data.structure.link;

/**
 * Created by think on 2019/10/22.
 */
public class LinkedListSolution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            ListNode node = head;
            head = node.next;
            node.next = null;
        }
        if (head == null)
            return null;
        ListNode pre = head;
        while (pre.next != null){
            if ( pre.next.val==val){
                ListNode node = pre.next;
                pre.next = node.next;
                node.next = null;
            }else{
                pre = pre.next;
            }

        }
        return head;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LinkedListSolution()).removeElements(head, 6);
        System.out.println(res);
    }
}
