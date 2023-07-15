fun copyRandomList(node: Node?): Node? {
    var currentNode = node
    val originalToCopyMap = HashMap<Node, Node>()

    while (currentNode != null) {
        val copyNode = Node(currentNode.`val`)
        originalToCopyMap[currentNode] = copyNode
        currentNode = currentNode.next
    }

    currentNode = node

    while (currentNode != null) {
        val copy = originalToCopyMap[currentNode]
        copy?.next = originalToCopyMap[currentNode.next]
        copy?.random = originalToCopyMap[currentNode.random]
        currentNode = currentNode.next
    }

    return originalToCopyMap[node]
}

fun main() {
    val node7 = Node(7)
    val node13 = Node(13)
    val node11 = Node(11)
    val node10 = Node(10)
    val node1 = Node(1)

    node7.apply {
        next = node13
        random = null
    }

    node13.apply {
        next = node11
        random = node7
    }

    node11.apply {
        next = node10
        random = node1
    }

    node10.apply {
        next = node1
        random = node11
    }

    node1.apply {
        next = null
        random = node7
    }

    var currentNode = copyRandomList(node7)
    while (currentNode != null) {
        println("Value= ${currentNode.`val`} | Next= ${currentNode.next?.`val`} | Random= ${currentNode.random?.`val`}")
        currentNode = currentNode.next
    }
}