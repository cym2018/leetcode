package xyz.cym2018.leetcode
class ADAF {

    // 超时
    fun numberOfArraysA(s: String, k: Int): Int {
        var num = 0
        var len = 1
        if (s[0].equals('0')) return 0
        while (len < s.length) {
            if (s.substring(0, len).toInt() > k) break
            num += numberOfArraysA(s.substring(len++, s.length), k)
        }
        return if (s.substring(0, len).toInt() <= k) num + 1 else num
    }
}