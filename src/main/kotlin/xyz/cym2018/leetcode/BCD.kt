package xyz.cym2018.leetcode

class BCD {
    fun main() {
        val headNode = ListNode(0)
        var node1 = headNode
        var node2: ListNode
        var endNode: ListNode
        for (index in 1..9) {
            node2 = ListNode(index)
            node1.next = node2
            node1 = node2
        }

        for (index in 9 downTo 0) {
            node2 = ListNode(index)
            node1.next = node2
            node1 = node2
        }
        val obj = BCD()
        obj.printNodes(headNode)
//    endNode=obj.getLastNode(headNode)
//    obj.reverseB(headNode)
//    obj.printNodes(endNode)
        print(obj.isPalindrome(headNode))
    }

    fun getLastNode(node: ListNode): ListNode {
        var endNode = node
        while (endNode.next != null) {
            endNode = endNode.next!!
        }
        return endNode
    }

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null || head.next == null) return true
        // 获取中间节点
        var fast = head
        var slow = head
        while (fast!!.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }
        fast = slow
        slow = slow!!.next
        // 将链表从中间分为两份,逆转后一段
        fast!!.next = null
        slow = reverseB(slow!!)
        fast = head
        // 比较是否相等
        while (slow != null) {
            if (!slow.`val`.equals(fast!!.`val`)) {
                return false
            }
            slow = slow.next
            fast = fast.next
        }
        return true
    }

    // 递归反转
    fun reverseA(node: ListNode, lastNode: ListNode?) {
        if (node.next != null) {
            reverseA(node.next!!, node)
        }
        node.next = lastNode
    }

    // 循环反转,返回最后一个节点
    fun reverseB(node: ListNode): ListNode {
        var lastNode: ListNode?
        lastNode = null
        var thisNode = node
        var nextNode = node.next
        while (nextNode != null) {
            thisNode.next = lastNode
            lastNode = thisNode
            thisNode = nextNode
            nextNode = nextNode.next
        }
        thisNode.next = lastNode
        return thisNode
    }

    fun printNodes(node: ListNode?) {
        var thisNode = node
        while (thisNode != null) {
            print("" + thisNode!!.`val` + " ")
            thisNode = thisNode.next
        }
        println()
    }
}