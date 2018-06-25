package org.test.leetcode.linkedlist;

import java.util.Random;

/**
 * Created by tuyuantao on 2018/6/23.
 */
public class ListNodeUtil {

    /**
     * 构建从1到length的顺序链表
     *
     * @param length
     * @return
     */
    public static ListNode buildLinkedList(Integer length) {
        ListNode tail = null;
        for (int i = length; i >= 1; i--) {
            ListNode current = new ListNode();
            current.val = i;
            current.next = tail;
            tail = current;
        }

        return tail;
    }

    /**
     * 构建连接点是随机数的链表
     *
     * @param length
     * @return
     */
    public static ListNode buildRandomLinkedList(Integer length) {
        ListNode tail = null;
        Random random = new Random();
        for (int i = length; i >= 1; i--) {
            ListNode current = new ListNode();
            current.val = random.nextInt(10 * length) + 1;
            current.next = tail;
            tail = current;
        }

        return tail;
    }

    /**
     * 折叠链表
     *
     * @param listNode
     * @return
     */
    public static ListNode fold(ListNode listNode) {

        //先求长度，空间复杂度O(1), 时间复杂度 O(n)
        Integer size = getSize(listNode);
        Integer middle = (size + 1) / 2;
        Integer tempMiddle = middle;

        //把链表拆成2部分，时间复杂度 O(n)
        ListNode firstHalf = listNode;
        ListNode current = listNode;
        ListNode lastHalf = null;
        while (tempMiddle > 1) {
            current = current.next;
            lastHalf = current;
            tempMiddle--;
        }

        //后半部分链表反转, 空间复杂度O(1), 时间复杂度 O(n)
        lastHalf = lastHalf.next;
        current.next = null;
        lastHalf = reverse(lastHalf);

        //2段链表拼接，空间复杂度O(1), 时间复杂度 O(n);
        ListNode result = firstHalf;
        tempMiddle = middle;
        while (tempMiddle > 0 && lastHalf != null) {
            ListNode temp = lastHalf;
            lastHalf = lastHalf.next;
            temp.next = firstHalf.next;
            firstHalf.next = temp;
            firstHalf = firstHalf.next.next;
            tempMiddle--;
        }

        return result;
    }

    /**
     * 反转链表
     *
     * @param listNode
     * @return
     */
    public static ListNode reverse(ListNode listNode) {
        ListNode current = listNode;
        ListNode result = null;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    /**
     * 获取链表长度
     *
     * @param listNode
     * @return
     */
    public static Integer getSize(ListNode listNode) {
        ListNode node = listNode;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }

    public static void main(String[] args) {
        ListNode listNode = buildLinkedList(9);
        ListNode randomList = buildRandomLinkedList(10);
        System.out.println(getSize(listNode));
        System.out.println(listNode);
//        System.out.println(reverse(listNode));
        System.out.println(randomList);
        System.out.println(fold(listNode));
    }
}
