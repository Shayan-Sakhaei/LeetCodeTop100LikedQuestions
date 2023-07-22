fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var slow = head
    var fast = head.next

    while (slow != null && fast?.next != null) {
        slow = slow.next
        fast = fast.next?.next
    }

    val mid = slow?.next
    slow?.next = null

    val leftSide = sortList(head)
    val rightSide = sortList(mid)

    return merge(leftSide, rightSide)
}

private fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    val sortedList = ListNode(0)
    var curr = sortedList

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            curr.next = l1
            l1 = l1.next
        } else {
            curr.next = l2
            l2 = l2.next
        }

        curr = curr.next!!
    }

    if (l1 != null) {
        curr.next = l1
    } else {
        curr.next = l2
    }

    return sortedList.next
}

fun main() {
    val head = ListNode(4)
    head.next = ListNode(2)
    head.next?.next = ListNode(1)
    head.next?.next?.next = ListNode(3)

    var curr = sortList(head)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}