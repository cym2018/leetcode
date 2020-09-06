package xyz.cym2018.leetcode


class BEG {
    var result = ArrayList<String>();
    fun binaryTreePaths(root: TreeNode?): List<String> {
        result = ArrayList();
        if (root != null) {
            if (root.left == null && root.right == null) {
                result.add("" + root.`val`)
            }
            if (root.left != null) {
                iFun("" + root.`val`, root.left!!);
            }
            if (root.right != null) {
                iFun("" + root.`val`, root.right!!);
            }
        }
        return result;
    }

    fun iFun(str: String, node: TreeNode) {
        if (node.left == null && node.right == null) {
            result.add(str + "->" + node.`val`)
        }
        if (node.left != null) {
            iFun(str + "->" + node.`val`, node.left!!);
        }
        if (node.right != null) {
            iFun(str + "->" + node.`val`, node.right!!);
        }
    }
}