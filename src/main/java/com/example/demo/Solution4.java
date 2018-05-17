package com.example.demo;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution4 {

    public ListNode removeElements(ListNode head, int val) {

       if (head == null)
           return head;
        head.next = removeElements(head.next, val);
        if (head.val == val)
            return head.next;
        else{
            return head;
        }


    }

    public static void main(String[] args) {

        int[] nums = {1,5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements(head, 6);
        System.out.println(res);
    }
}