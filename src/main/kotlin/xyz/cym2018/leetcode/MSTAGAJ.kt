package xyz.cym2018.leetcode

class MSTAGAJ {
    // 哈希
    fun majorityElementA(nums: IntArray): Int {
        val hm = HashMap<Int, Int>()
        nums.forEach {
            if (hm.getOrDefault(it, 0).plus(1) >= (nums.size + 1) / 2) return it
            hm.set(it, hm.getOrDefault(it, 0).plus(1))
        }
        return if (nums.size == 1) nums[0] else -1;
    }

    // 投票
    fun majorityElementB(nums: IntArray): Int {
        var temp = 0
        var count = 0
        nums.forEach {
            if (count == 0) {
                temp = it
                count++
            } else if (temp.equals(it))
                count++
            else count--
        }
        count = 0
        nums.forEach { if (it.equals(temp)) count++ }
        return if (count >= (nums.size + 1) / 2) temp else -1
    }
}