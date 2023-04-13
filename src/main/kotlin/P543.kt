var diameter = -1

fun diameterOfBinaryTree(root: TreeNode?): Int {
    dfs(root)
    return diameter
}

private fun dfs(root: TreeNode?): Int {
    root ?: return -1
    val leftHeight = 1 + dfs(root.left)
    val rightHeight = 1 + dfs(root.right)
    diameter = kotlin.math.max(diameter, (leftHeight + rightHeight))
    return kotlin.math.max(leftHeight, rightHeight)
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    println(diameterOfBinaryTree(root))
}