fun reverseListIterative(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var prev: ListNode? = null
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

fun reverseListRecursive(head: ListNode?): ListNode? {
    head?.next ?: return head
    val newHead = reverseListRecursive(head.next)
    head.next?.next = head
    head.next = null
    return newHead
}

fun main() {
    val headIterative = ListNode(1)
    headIterative.next = ListNode(2)
    headIterative.next?.next = ListNode(3)
    headIterative.next?.next?.next = ListNode(4)
    headIterative.next?.next?.next?.next = ListNode(5)

    var currentIterative = reverseListIterative(headIterative)
    while (currentIterative != null) {
        println(currentIterative.`val`)
        currentIterative = currentIterative.next
    }

    println("----------")

    val headRecursive = ListNode(1)
    headRecursive.next = ListNode(2)
    headRecursive.next?.next = ListNode(3)
    headRecursive.next?.next?.next = ListNode(4)
    headRecursive.next?.next?.next?.next = ListNode(5)

    var currentRecursive = reverseListRecursive(headRecursive)
    while (currentRecursive != null) {
        println(currentRecursive.`val`)
        currentRecursive = currentRecursive.next
    }
}