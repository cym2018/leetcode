package xyz.cym2018.leetcode

import java.util.*


class AJG {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val intArray = LinkedList<LinkedList<Int>>()
        fun func(i: Int, node: TreeNode?) {
            if (node == null) return
            if (intArray.size <= i) {
                intArray.add(0, LinkedList())
            }
            intArray[intArray.size - 1 - i].add(node.`val`)
            func(i + 1, node.left!!)
            func(i + 1, node.right!!)
        }
        func(0, root!!)
        return intArray.toList()
    }
}