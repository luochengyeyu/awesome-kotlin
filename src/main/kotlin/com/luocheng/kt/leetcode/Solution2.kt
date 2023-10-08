package com.luocheng.kt.leetcode

import kotlin.system.measureTimeMillis

/**
 * ## [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/description/)
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
class Solution2 {
    fun reverseList(head: ListNode?): ListNode? {
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

    fun case() {
        val node5 = ListNode(5, null)
        val node4 = ListNode(4, node5)
        val node3 = ListNode(3, node4)
        val node2 = ListNode(2, node3)
        val node1 = ListNode(1, node2)
        println(node1)
        val result = reverseList(node1)
        println(result)
    }

}

fun main() {
    measureTimeMillis {
        Solution2().case()
    }.also {
        println("耗时：$it ms")
    }
}
