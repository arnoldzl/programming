package com.laicode.base.linkedList;

import com.laicode.base.util.HelperUtil.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseIterative(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
