import java.util.*

fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val queue = LinkedList<TreeNode>()

    root ?: return result

    queue.offer(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val currNode = queue.poll()
            if (i == 0) result.add(currNode.`val`)
            if (currNode.right != null) queue.offer(currNode.right)
            if (currNode.left != null) queue.offer(currNode.left)
        }
    }

    return result
}

fun main() {
    val root = TreeNode(1)

    root.left = TreeNode(2)
    root.left?.right = TreeNode(5)

    root.right = TreeNode(3)
    root.right?.right = TreeNode(4)

    println(rightSideView(root))
}