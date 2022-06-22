package solutions.kotlin

import java.util.*

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    for (char in s) {
        if (char == '(' || char == '{' || char == '[') {
            stack.push(char)
        } else if (char == ')' && stack.isNotEmpty() && stack.peek() == '(') {
            stack.pop()
        } else if (char == '}' && stack.isNotEmpty() && stack.peek() == '{') {
            stack.pop()
        } else if (char == ']' && stack.isNotEmpty() && stack.peek() == '[') {
            stack.pop()
        } else {
            return false
        }
    }

    return stack.isEmpty()
}

fun isValidHashMapApproach(s: String): Boolean {
    val stack = Stack<Char>()

    val map = hashMapOf(
        ')' to '(',
        '}' to '{',
        ']' to '[',
    )

    for (char in s) {
        if (char == '(' || char == '{' || char == '[') {
            stack.push(char)
        } else {
            val popped = if (stack.isEmpty()) null else stack.pop()
            if (popped == null || popped != map[char]) return false
        }
    }

    return stack.isEmpty()
}


fun main() {
    val s = "(]"

    println(isValid(s))
    println(isValidHashMapApproach(s))
}