import java.util.*

fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return null
    val left = root.left
    val right = root.right
    root.left = invertTree(right)
    root.right = invertTree(left)
    return root
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)

    root.right = TreeNode(7)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)

    val invertedTree = invertTree(root)
    levelOrderPrint(invertedTree)
}

private fun levelOrderPrint(root: TreeNode?) {
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    if (root != null) queue.add(root)

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val currentNode = queue.poll()
            println(currentNode.`val`)
            if (currentNode.left != null) queue.add(currentNode.left)
            if (currentNode.right != null) queue.add(currentNode.right)
        }
    }
}