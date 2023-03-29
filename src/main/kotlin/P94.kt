fun inorderTraversal(root: TreeNode?): List<Int> {
    return inorderTraversal(root, mutableListOf<Int>())
}

fun inorderTraversal(root: TreeNode?, list: MutableList<Int>): List<Int> {
    root ?: return list
    inorderTraversal(root.left, list)
    list.add(root.`val`)
    inorderTraversal(root.right, list)
    return list
}

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)
    println(inorderTraversal(root))
}