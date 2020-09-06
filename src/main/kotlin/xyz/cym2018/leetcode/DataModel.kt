package xyz.cym2018.leetcode
// LinkedList 变长列表
// 二叉搜索树:左小右大
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
