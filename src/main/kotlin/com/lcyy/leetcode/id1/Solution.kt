package com.lcyy.leetcode.id1

import kotlin.system.measureTimeMillis

/**
 * ## [两数之和](https://leetcode.cn/problems/two-sum/description/)
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
class Solution {
    /**
     * 暴力枚举
     */
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val n: Int = nums.size
        for (i in 0..<n) {
            for (j in i + 1..<n) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return IntArray(0)
    }

    /**
     * 哈希表
     */
    private fun twoSum2(nums: IntArray, target: Int): IntArray {
        val hashtable = HashMap<Int, Int>()
        nums.forEachIndexed { i, num ->
            if (hashtable.containsKey(target - num)) {
                return intArrayOf(hashtable[target - num]!!, i)
            }
            hashtable[num] = i;
        }
        return intArrayOf()
    }

    fun case() {
        twoSum2(intArrayOf(2, 7, 11, 15), 17)
            .also { println(it.contentToString()) }
    }

}

fun main() {
    Solution().case()
}