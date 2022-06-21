package solutions.kotlin

import datastructures.ListNode

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var slow: ListNode? = dummyHead
    var fast: ListNode? = dummyHead

    for (i in 0..n) {
        fast = fast?.next
    }

    while (fast != null) {
        slow = slow?.next
        fast = fast.next
    }

    slow?.next = slow?.next?.next

    return dummyHead.next
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    val n = 2

    var curr = removeNthFromEnd(head, n)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}