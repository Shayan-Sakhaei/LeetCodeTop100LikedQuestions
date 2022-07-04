package solutions.kotlin

import datastructures.ListNode


/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var count = 0
    var curr = head

    while (count < k) {
        if (curr == null) {
            return head
        }
        curr = curr.next
        count++
    }

    var reversed = reverseKGroup(curr, k)

    var currHead = head
    while (count > 0) {
        val nextHead = currHead?.next
        currHead?.next = reversed
        reversed = currHead
        currHead = nextHead
        count--
    }

    return reversed
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    val k = 3

    var curr = reverseKGroup(head, k)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}
