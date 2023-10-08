package com.luocheng.kt.leetcode

import java.util.*


data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun build(array: IntArray): TreeNode? {
    if (array.isEmpty()) {
        return null
    }
    // 创建第一个结点
    // 创建第一个结点
    val root = TreeNode(array[0])
    val deque: Deque<TreeNode?> = LinkedList()
    deque.addFirst(root)
    // 遍历子结点的方向
    // 遍历子结点的方向
    var isLeft = true
    for (i in 1..<array.size) {
        // 取出队尾元素
        deque.last?.let {
            if (isLeft) {
                it.left = TreeNode(array[i])
                deque.addFirst(it.left)
                isLeft = false
            } else {
                it.right = TreeNode(array[i])
                deque.addFirst(it.right)
                // 删除队尾元素
                deque.removeLast()
                isLeft = true
            }
        }

    }
    return root
}

fun main() {
    build(intArrayOf(1, 2, 3, 4))
}