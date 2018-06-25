package org.test.leetcode.linkedlist;

/**
 * Created by tuyuantao on 2018/6/23.
 */
public class ListNode {

    public Integer val;
    public ListNode next;

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        return sb.delete(sb.toString().length() - 2, sb.toString().length()).toString();
    }
}
