package com.lcyy.leetcode

import kotlin.math.max


/**
 *
 */
class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val dic: MutableMap<Char, Int> = HashMap()
        var i = -1
        var res = 0
        val len = s.length
        for (j in 0..<len) {
            if (dic.containsKey(s[j])) i =
                max(i.toDouble(), dic[s[j]]!!.toDouble()).toInt() // 更新左指针 i
            dic[s[j]] = j // 哈希表记录
            res = max(res.toDouble(), (j - i).toDouble()).toInt() // 更新结果
        }
        return res
    }

}
