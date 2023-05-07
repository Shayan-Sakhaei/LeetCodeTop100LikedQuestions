fun swapPairs(head: ListNode?): ListNode? {
    head?.next ?: return head
    val nextPairHead = head.next?.next
    head.next?.next = head
    val newHead = head.next
    head.next = swapPairs(nextPairHead)
    return newHead
}

fun swapPairsIterative(head: ListNode?): ListNode? {
    val temp = ListNode(0)
    temp.next = head
    var current: ListNode? = temp

    while (current?.next != null && current.next?.next != null) {
        val firstNode = current.next
        val secondNode = current.next?.next

        firstNode?.next = secondNode?.next

        current.next = secondNode
        current.next?.next = firstNode

        current = current.next?.next
    }

    return temp.next
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)

    var curr = swapPairs(head)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}