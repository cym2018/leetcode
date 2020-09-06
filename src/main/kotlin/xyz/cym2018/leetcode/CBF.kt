package xyz.cym2018.leetcode

class CBF {

    fun isPowerOfThree(n: Int): Boolean {
        if (n > 2 && n % 3 == 0) {
            return isPowerOfThree(n / 3)
        } else {
            return n == 1
        }
    }

}