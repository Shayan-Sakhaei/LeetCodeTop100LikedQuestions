import java.util.*

fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return mutableListOf()

    val result = mutableListOf<List<Int>>()
    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val currentList = mutableListOf<Int>()
        for (i in 0 until queue.size) {
            queue.peek().left?.let { queue.add(it) }
            queue.peek().right?.let { queue.add(it) }
            currentList.add(queue.remove().`val`)
        }
        result.add(ArrayList(currentList))
    }

    return result
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    println(levelOrder(root))
}