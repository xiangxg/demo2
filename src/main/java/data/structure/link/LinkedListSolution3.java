package data.structure.link;

/**
 * Created by think on 2019/10/22.
 */
public class LinkedListSolution3 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumyHead = new ListNode(-1);
        dumyHead.next = head;
        ListNode pre = dumyHead;
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

        ListNode res = (new LinkedListSolution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
