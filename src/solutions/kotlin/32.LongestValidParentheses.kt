package solutions.kotlin

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */

fun longestValidParentheses(s: String): Int {
    var open = 0
    var close = 0
    var maxLength = 0

    for (i in s.indices) {
        if (s[i] == '(') {
            open++
        } else {
            close++
        }

        if (open == close) {
            val currLength = open + close
            maxLength = kotlin.math.max(maxLength, currLength)
        } else if (close > open) {
            open = 0
            close = 0
        }
    }

    open = 0
    close = 0

    for (i in s.lastIndex downTo 0) {
        if (s[i] == '(') {
            open++
        } else {
            close++
        }

        if (open == close) {
            val currLength = open + close
            maxLength = kotlin.math.max(maxLength, currLength)
        } else if (open > close) {
            open = 0
            close = 0
        }
    }

    return maxLength
}

fun main() {
    val s = "()(())"

    println(longestValidParentheses(s))
}

