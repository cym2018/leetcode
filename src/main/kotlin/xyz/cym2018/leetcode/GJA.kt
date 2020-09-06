package xyz.cym2018.leetcode

class GJA {
    // 递归
    fun insertIntoBSTA(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)
        if (root.`val` < `val`)
            if (root.right == null) root.right = TreeNode(`val`)
            else insertIntoBSTA(root.right, `val`)
        else
            if (root.left == null) root.left = TreeNode(`val`)
            else insertIntoBSTA(root.left, `val`)
        return root;
    }

    // 迭代
    fun insertIntoBSTB(root: TreeNode?, `val`: Int): TreeNode? {
        var thisNode = root
        if (root == null) return TreeNode(`val`)
        while (true) {
            if (thisNode!!.`val` < `val`) {
                if (thisNode.right == null) {
                    thisNode.right = TreeNode(`val`)
                    return root
                } else
                    thisNode = thisNode.right
            } else {
                if (thisNode.left == null) {
                    thisNode.left = TreeNode(`val`)
                    return root
                } else
                    thisNode = thisNode.left
            }
        }
    }

}