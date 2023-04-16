fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var left = l1
    var right = l2
    val result = ListNode(0)
    var curr = result
    var carry = 0

    while (left != null || right != null) {
        val leftValue = left?.`val` ?: 0
        val rightValue = right?.`val` ?: 0
        val sum = leftValue + rightValue + carry

        carry = sum / 10
        curr.next = ListNode(sum % 10)

        left = left?.next
        right = right?.next
        curr = curr.next!!
    }

    if (carry > 0) {
        curr.next = ListNode(carry)
    }

    return result.next
}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next?.next = ListNode(4)

    var curr = addTwoNumbers(l1, l2)
    while (curr != null) {
        print(curr.`val`)
        curr = curr.next
    }
}