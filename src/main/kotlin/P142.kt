fun detectCycle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (slow != null && fast?.next != null) {
        slow = slow.next
        fast = fast.next?.next
        if (slow === fast) {
            slow = head
            while (slow != fast) {
                slow = slow?.next
                fast = fast?.next
            }
            return slow
        }
    }

    return null
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node2
    node2.next = node1

    println(detectCycle(node1)?.`val`)
}