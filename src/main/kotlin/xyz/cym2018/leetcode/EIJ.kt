package xyz.cym2018.leetcode

import java.util.*

class EIJ {
    fun postorderA(root: Node?): IntArray {
        val ret = LinkedList<Int>()
        fun func1(node: Node?) {
            if (node == null) {
                return
            }
            node.children.forEach { func1(it) }
            ret.add(node.`val`)
        }
        func1(root)
        return ret.toIntArray()
    }

    fun postorderB(root: Node?): IntArray {
        val stack1 = Stack<Node>()
        val stack2 = Stack<Node>()
        var tempNode: Node
        if(root!=null) stack1.push(root)
        while (!stack1.empty()) {
            tempNode = stack2.push(stack1.pop())
            tempNode.children.forEach {
                stack1.push(it)
            }
        }
        val ret = LinkedList<Int>()
        while (stack2.size != 0) {
            ret.add(stack2.pop().`val`)
        }
        return ret.toIntArray()
    }

}