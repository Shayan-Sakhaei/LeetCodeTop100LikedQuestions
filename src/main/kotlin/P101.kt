fun isSymmetric(root: TreeNode?): Boolean {
    root ?: return true
    return isSymmetric(root.left, root.right)
}

fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    return (left.`val` == right.`val`) &&
            isSymmetric(left.left, right.right) &&
            isSymmetric(left.right, right.left)
}

fun main() {
    val root = TreeNode(1)

    root.left = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    root.right = TreeNode(3)
    root.right?.right = TreeNode(4)

    println(isSymmetric(root))
}