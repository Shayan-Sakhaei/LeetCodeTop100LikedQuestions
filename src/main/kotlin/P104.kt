import java.util.*

fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    return (kotlin.math.max(maxDepth(root.left), maxDepth(root.right))) + 1
}

fun maxDepthBFS(root: TreeNode?): Int {
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    if (root != null) queue.add(root)
    var depth = 0

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val currentNode = queue.poll()
            if (currentNode.left != null) queue.add(currentNode.left)
            if (currentNode.right != null) queue.add(currentNode.right)
        }
        depth++
    }

    return depth
}

fun main() {
    val root = TreeNode(3)

    root.left = TreeNode(9)

    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    println(maxDepth(root))
    println(maxDepthBFS(root))
}