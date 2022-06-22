package solutions.kotlin

import datastructures.ListNode

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val mergedList = ListNode(0)
    var curr = mergedList
    var left = list1
    var right = list2

    while (left != null && right != null) {
        if (left.`val` < right.`val`) {
            curr.next = left
            left = left.next
            curr = curr.next!!
        } else {
            curr.next = right
            right = right.next
            curr = curr.next!!
        }
    }

    while (left != null) {
        curr.next = left
        left = left.next
        curr = curr.next!!
    }

    while (right != null) {
        curr.next = right
        right = right.next
        curr = curr.next!!
    }

    return mergedList.next
}

fun mergeTwoListsRecursiveApproach(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }
}

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(4)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)

    var curr = mergeTwoLists(list1, list2)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}