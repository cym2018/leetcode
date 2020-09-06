package xyz.cym2018.leetcode

class AEJI {
    fun minDifference(nums: IntArray): Int {
        if (nums.size < 5) return 0
        val maxInt = arrayOfNulls<Int>(4)
        val minInt = arrayOfNulls<Int>(4)
        fun addNum(num: Int) {
            if (maxInt[3] == null) {
                for (index in 0..3) {
                    if (maxInt[index] == null) {
                        maxInt[index] = num
                        minInt[index] = num
                        if (index == 3) {
                            maxInt.sort()
                            minInt.sort()
                        }
                        break
                    }
                }
            } else {
                if (maxInt[0]!! < num) {
                    maxInt[0] = num
                    maxInt.sort()
                }
                if (minInt[3]!! > num) {
                    minInt[3] = num
                    minInt.sort()
                }
            }
        }
        nums.forEach { o -> addNum(o) }
        var minDiff = maxInt[0]!! - minInt[0]!!
        for (index in 1..3) {
            if (minDiff > maxInt[index]!! - minInt[index]!!) {
                minDiff = maxInt[index]!! - minInt[index]!!
            }
        }
        return if (minDiff < 0) 0 else minDiff
    }


    fun minDifferenceA(nums: IntArray): Int {
        if (nums.size < 5) {
            return 0
        }
        val sorted = nums.sortedArray()
        var minInt = sorted[sorted.size - 4] - sorted[0]
        for (index in 1..3) {
            if (minInt > sorted[sorted.size - 4 + index] - sorted[index]) {
                minInt = sorted[sorted.size - 4 + index] - sorted[index]
            }
        }
        return if (minInt < 0) 0 else minInt
    }
}