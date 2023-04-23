fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var slow: ListNode? = dummyHead
    var fast: ListNode? = dummyHead

    repeat(n + 1) {
        fast = fast?.next
    }

    while (fast != null) {
        slow = slow?.next
        fast = fast?.next
    }

    slow?.next = slow?.next?.next

    return dummyHead.next
}

fun main() {
    val head = ListNode(1)
    val n = 1

    var curr = removeNthFromEnd(head, n)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}