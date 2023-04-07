fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var aPointer = headA
    var bPointer = headB

    while (aPointer != bPointer) {
        aPointer = if (aPointer == null) headB else aPointer.next
        bPointer = if (bPointer == null) headA else bPointer.next
    }

    return aPointer
}

fun main() {
    val nodeTwo = ListNode(2)
    val nodeFour = ListNode(4)

    val headA = ListNode(1)
    headA.next = ListNode(9)
    headA.next?.next = ListNode(1)
    headA.next?.next?.next = nodeTwo
    headA.next?.next?.next?.next = nodeFour

    val headB = ListNode(3)
    headB.next = nodeTwo
    headB.next?.next = nodeFour

    println(getIntersectionNode(headA, headB)?.`val`)
}