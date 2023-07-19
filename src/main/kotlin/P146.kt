class LRUCache(private val capacity: Int) {

    class Node(val key: Int, val `val`: Int) {
        var next: Node? = null
        var prev: Node? = null
    }

    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)
    private val map = HashMap<Int, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    private fun addNode(newNode: Node) {
        val headNext = head.next
        newNode.next = headNext
        newNode.prev = head
        head.next = newNode
        headNext?.prev = newNode
    }

    private fun removeNode(newNode: Node) {
        val prev = newNode.prev
        val next = newNode.next
        prev?.next = next
        next?.prev = prev
    }

    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val node = map[key]!!
            map.remove(key)
            removeNode(node)
            addNode(node)
            map[key] = head.next!!
            node.`val`
        } else -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val curr = map[key]!!
            map.remove(key)
            removeNode(curr)
        }
        if (map.size == capacity) {
            val lruNode = tail.prev!!
            map.remove(lruNode.key)
            removeNode(lruNode)
        }
        addNode(Node(key, value))
        map[key] = head.next!!
    }
}