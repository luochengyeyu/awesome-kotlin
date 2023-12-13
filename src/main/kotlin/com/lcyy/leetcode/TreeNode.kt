package com.lcyy.leetcode

import java.util.*


data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun mkTree(str: String): TreeNode? {
    val arr = strToIntArray(str)
    val nodes = arrayOfNulls<TreeNode>(arr.size + 1)
    for (i in 1..<nodes.size) {
        if (arr[i - 1] != Int.MAX_VALUE) {
            nodes[i] = TreeNode(arr[i - 1])
        } else {
            nodes[i] = null
        }
    }

    var node: TreeNode? = null
    for (i in 1..<nodes.size / 2) {
        node = nodes[i]
        if (node == null) continue
        node.left = nodes[2 * i]
        node.right = nodes[2 * i + 1]
    }
    return nodes[1]
}

private fun strToIntArray(str: String): IntArray {
    var str = str
    str = str.substring(1, str.length - 1)
    val strs = str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val arr = IntArray(strs.size)
    for (i in arr.indices) {
        if (strs[i] == "null") {
            arr[i] = Int.MAX_VALUE
        } else {
            arr[i] = strs[i].toInt()
        }
    }
    return arr
}

fun main() {
    mkTree("")
}