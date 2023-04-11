fun isPalindrome(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    slow = reverse(slow)
    fast = head

    while (slow != null) {
        if (slow.`val` != fast?.`val`) return false
        slow = slow.next
        fast = fast.next
    }

    return true
}

private fun reverse(head: ListNode?): ListNode? {
    head?.next ?: return head
    val newHead = reverse(head.next)
    head.next?.next = head
    head.next = null
    return newHead
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(1)

    println(isPalindrome(head))
}