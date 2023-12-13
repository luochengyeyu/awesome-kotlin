package com.lcyy.leetcode

data class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return "ListNode(value=$`val`, next=$next)"
    }
}