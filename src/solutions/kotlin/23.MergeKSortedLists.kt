package solutions.kotlin

import datastructures.ListNode


/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var index = lists.size - 1
    var result: ListNode? = null

    while (index >= 0) {
        result = merge(result, lists[index])
        index--
    }

    return result
}

private fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` < list2.`val`) {
        list1.next = merge(list1.next, list2)
        list1
    } else {
        list2.next = merge(list1, list2.next)
        list2
    }
}

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(4)
    list1.next!!.next = ListNode(5)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)

    val list3 = ListNode(2)
    list3.next = ListNode(6)

    var curr = mergeKLists(arrayOf(list1, list2, list3))
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}