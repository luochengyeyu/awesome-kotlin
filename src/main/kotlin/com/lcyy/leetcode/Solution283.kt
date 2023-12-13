package com.lcyy.leetcode

import kotlin.system.measureTimeMillis

/**
 * ## [283.移动零](https://leetcode.cn/problems/move-zeroes/description/)
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * > 示例 1:
 * > 输入: nums = [0,1,0,3,12]
 * > 输出: [1,3,12,0,0]
 */
class Solution283 {
    fun moveZeroes(nums: IntArray) {
        // 指针j记录最近遍历到的非零元素的下标
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
        // 第一次遍历的时候指针 j 用来记录当前有多少 非0 元素。
        // 即遍历的时候每遇到一个 非0 元素就将其往数组左边挪，第一次遍历完后，j 指针的下标就指向了最后一个 非0 元素下标。
        nums.forEachIndexed { i, num ->
            if (num != 0) {
                nums[j++] = nums[i]
            }
            println(nums.contentToString())
        }
        // 第二次遍历的时候，起始位置就从 j 开始到结束，将剩下的这段区域内的元素全部置为 0 即可。
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
        val nums = intArrayOf(1,0,0,22,0,3,0)
        Solution283().moveZeroes2(nums)
        verify(nums, "[1, 22, 3, 0, 0, 0, 0]")
    }
}

fun main() {
//    Solution283().case1()
//    Solution283().case2()
    Solution283().case3()
}
