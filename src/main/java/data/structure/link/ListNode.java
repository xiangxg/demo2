package data.structure.link;

public class ListNode {

        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
        public ListNode(int [] arr){
            if (arr.length == 0)
                return;
            this.val = arr[0];
            ListNode node = this;
            for (int i = 1; i < arr.length; i++) {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            ListNode cur = this;
            while (cur != null){
                str.append(cur.val).append("->");
                cur = cur.next;
            }
            str.append("NULL");
            return str.toString();
        }
    }