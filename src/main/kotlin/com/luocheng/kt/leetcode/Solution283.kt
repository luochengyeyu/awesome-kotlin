package com.luocheng.kt.leetcode

import kotlin.system.measureTimeMillis

/**
 * ## [283.反转二叉树](https://leetcode.cn/problems/move-zeroes/description/)
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * > 示例 1:
 * > 输入: nums = [0,1,0,3,12]
 * > 输出: [1,3,12,0,0]
 */
class Solution283 {
    fun moveZeroes(nums: IntArray) {
        var j = 0
        nums.forEachIndexed { i, num ->
            if (num != 0) {
                if (i > j) {
                    nums[j] = num
                    nums[i] = 0
                }
                ++j
            }
        }
    }

    /**
     * 双指针
     */
    fun moveZeroes2(nums: IntArray) {
        var j = 0
        nums.forEachIndexed { i, num ->
            if (num != 0) {
                nums[j++] = nums[i]
            }
        }
        for (i in j..<nums.size) {
            nums[i] = 0
        }
    }

    private fun verify(nums: IntArray, expect: String) {
        val result = nums.contentToString()
        val passed = if (result == expect) "通过" else "失败"
        println("$result $passed")
    }

    fun case1() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        Solution283().moveZeroes(nums)
        verify(nums, "[1, 3, 12, 0, 0]")
    }

    fun case2() {
        val nums = intArrayOf(0)
        Solution283().moveZeroes(nums)
        verify(nums, "[0]")
    }
    fun case3() {
        val nums = intArrayOf(1,0,0,22,0,3,0,0)
        Solution283().moveZeroes2(nums)
        verify(nums, "[1, 22, 3, 0, 0, 0, 0, 0]")
    }
}

fun main() {
    Solution283().case1()
    Solution283().case2()
    Solution283().case3()
}
