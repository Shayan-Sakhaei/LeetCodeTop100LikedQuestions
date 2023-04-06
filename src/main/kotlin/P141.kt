fun hasCycle(head: ListNode?): Boolean {
    head?.next ?: return false

    val hashSet = HashSet<ListNode>()
    var curr = head

    while (curr != null) {
        if (!hashSet.add(curr)) return true
        curr = curr.next
    }

    return false
}

fun hasCycleTwoPinter(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (slow?.next != null && fast?.next?.next != null) {
        slow = slow.next
        fast = fast.next?.next
        if (slow == fast) return true
    }

    return false
}

fun main() {
    val nodeThree = ListNode(3)
    val nodeTwo = ListNode(2)
    val nodeZero = ListNode(0)
    val nodeMinusFour = ListNode(2)

    val head = nodeThree
    head.next = nodeTwo
    head.next?.next = nodeZero
    head.next?.next?.next = nodeMinusFour
    head.next?.next?.next?.next = nodeTwo

    println(hasCycle(head))
    println(hasCycleTwoPinter(head))
}