fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    val mergedList = ListNode(0)
    var currentNode = mergedList
    var left = list1
    var right = list2

    while (left != null && right != null) {
        if (left.`val` <= right.`val`) {
            currentNode.next = ListNode(left.`val`)
            left = left.next
        } else {
            currentNode.next = ListNode(right.`val`)
            right = right.next
        }
        currentNode = currentNode.next!!
    }

    while (left != null) {
        currentNode.next = ListNode(left.`val`)
        left = left.next
        currentNode = currentNode.next!!
    }

    while (right != null) {
        currentNode.next = ListNode(right.`val`)
        right = right.next
        currentNode = currentNode.next!!
    }

    return mergedList.next
}

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next?.next = ListNode(4)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next?.next = ListNode(4)

    val mergedList = mergeTwoLists(list1, list2)
    var currentNode = mergedList
    while (currentNode != null) {
        println(currentNode.`val`)
        currentNode = currentNode.next
    }
}