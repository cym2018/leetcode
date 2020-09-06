package xyz.cym2018.leetcode

import kotlin.math.min
class AEEC {
    // Out of Memory
    fun minDaysA(n: Int): Int {
        val days = arrayOfNulls<Int>(n + 1)
        var minDay: Int
        days[0] = 0
        days[1] = 1
        for (index in 2..n) {
            minDay = days.get(index - 1)!! + 1;
            if (index % 3 == 0) {
                minDay = min(minDay, days.get(index / 3)!! + 1)
            }
            if (index % 2 == 0) {
                minDay = min(minDay, days.get(index / 2)!! + 1)
            }
            days[index] = minDay
        }
        return days[n]!!;
    }


    fun minDaysB(n: Int): Int {
        val dpMap = HashMap<Int, Int>()
        fun minDaysB1(n: Int): Int {
            var minDay = n
            if (n % 2 == 0) {
                if (dpMap.containsKey(n / 2)) {
                    minDay = min(minDay, dpMap.get(n / 2)!! + 1)
                } else {
                    minDay = min(minDay, minDaysB1(n / 2) + 1)
                }
            }
            if (n % 3 == 0) {
                if (dpMap.containsKey(n / 3)) {
                    minDay = min(minDay, dpMap.get(n / 3)!! + 1)
                } else {
                    minDay = min(minDay, minDaysB1(n / 3) + 1)
                }
            }
            if (n % 3 == 1 || n % 2 != 0 || n % 3 != 0) {
                if (dpMap.containsKey(n - 1)) {
                    minDay = min(minDay, dpMap.get(n - 1)!! + 1)
                } else {
                    minDay = min(minDay, minDaysB1(n - 1) + 1)
                }
            }
            dpMap.set(n, minDay)
            return minDay;
        }
        dpMap.set(0, 0)
        dpMap.set(1, 1)
        val ret = minDaysB1(n)
        return ret;
    }

    fun minDaysC(n: Int): Int {
        val dpMap = HashMap<Int, Int>()
        fun minDaysC1(n: Int): Int {
            if (n < 2) return n;
            if (dpMap.containsKey(n)) return dpMap[n]!!;
            dpMap[n] = min(minDaysC1(n / 3) + n % 3 + 1, minDaysC1(n / 2) + n % 2 + 1)
            return dpMap[n]!!
        }
        return minDaysC1(n)
    }


}