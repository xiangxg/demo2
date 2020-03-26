package data.structure.link;

/**
 * Created by think on 2019/10/23.
 */
public class LinkedListSolution4 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements(head.next,val);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }
}
