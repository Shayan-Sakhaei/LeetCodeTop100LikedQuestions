package solutions.kotlin

import datastructures.ListNode

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val newHead = head.next
    val nextPairHead = head.next?.next

    head.next?.next = head
    head.next = swapPairs(nextPairHead)

    return newHead
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)

    var curr = swapPairs(head)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}