package xyz.cym2018.leetcode

import java.util.*

fun main() {
    val root=TreeNode(3)
    root.left= TreeNode(1)
    root.right= TreeNode(4)
    root.left!!.left=TreeNode(3)
    root.right!!.left= TreeNode(1)
    root.right!!.right=TreeNode(5)
    val obj=ADDH()
    print(obj.goodNodes(root))
}
class ADDH {
    fun goodNodes(root: TreeNode?): Int {
        var num = 0
        val stack = Stack<Int>();
        fun func(node: TreeNode?) {
//            print("Now Value:"+node.`val`+"\nStack value:")
//            stack.forEach{ print(""+it+" ")}
//            println()
            if (stack.stream().filter { it > node.`val` }.count()==0L) {
//                print("Good Node\n")
                num++
            }
//            else{
//                print("Not A Good Node\n")
//            }
            stack.push(node!!.`val`)
            if (node.left != null) func(node.left)
            if (node.right != null) func(node.right)
            stack.pop()
        }
        func(root)
        return num;
    }
}