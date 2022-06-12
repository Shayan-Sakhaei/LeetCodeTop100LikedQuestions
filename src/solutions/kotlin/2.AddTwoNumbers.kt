package solutions.kotlin

import datastructures.ListNode

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var left = l1
    var right = l2
    val sumList = ListNode(0)
    var curr = sumList
    var carry = 0

    while (left != null && right != null) {
        val sum = left.`val` + right.`val` + carry
        if (sum < 10) {
            curr.next = ListNode(sum)
            carry = 0
        } else {
            curr.next = ListNode(sum % 10)
            carry = sum / 10
        }

        left = left.next
        right = right.next

        curr = curr.next!!
    }

    while (left != null) {
        val sum = left.`val` + carry
        if (sum < 10) {
            curr.next = ListNode(sum)
            carry = 0
        } else {
            curr.next = ListNode(sum % 10)
            carry = sum / 10
        }

        curr = curr.next!!
        left = left.next
    }

    while (right != null) {
        val sum = right.`val` + carry
        if (sum < 10) {
            curr.next = ListNode(sum)
            carry = 0
        } else {
            curr.next = ListNode(sum % 10)
            carry = sum / 10
        }

        curr = curr.next!!
        right = right.next
    }

    if (carry != 0) {
        curr.next = ListNode(carry)
    }

    return sumList.next
}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)

    var curr = addTwoNumbers(l1, l2)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}