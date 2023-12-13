package com.lcyy.leetcode.id206

import com.lcyy.leetcode.ListNode
import kotlin.system.measureTimeMillis

/**
 * ## [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
class Solution {
    /**
     * ## 方法一：迭代
     *
     * 复杂度分析
     * - 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * - 空间复杂度：O(1)。
     */
    private fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        }
        return pre
    }

    /**
     * ## 方法二：递归
     *
     * 复杂度分析
     * - 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * - 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     */
    private fun reverseList2(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head;
        }
        val newHead = reverseList2(head.next);
        head.next?.next = head;
        head.next = null;
        return newHead;
    }

    fun case1() {
        val node = listNode()
        reverseList(node).also {
            println(it)
        }
    }

    fun case2() {
        val node = listNode()
        reverseList2(node).also {
            println(it)
        }
    }

    private fun listNode(): ListNode {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        return node1
    }

}

fun main() {
    Solution().case1()
    Solution().case2()
}
