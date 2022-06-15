package solutions.kotlin

/**
 * Given a string s, return the longest palindromic substring in s.
 */

fun longestPalindrome(s: String): String {
    var start = 0
    var end = 0

    for (i in s.indices) {
        val length1 = palindromeLength(s, i, i)
        val length2 = palindromeLength(s, i, i + 1)
        val longestLength = kotlin.math.max(length1, length2)

        if (longestLength > end - start) {
            start = i - ((longestLength - 1) / 2)
            end = i + (longestLength / 2)
        }
    }

    return s.substring(start, end + 1)
}

private fun palindromeLength(s: String, left: Int, right: Int): Int {
    if (left > right) return 0

    var leftPointer = left
    var rightPointer = right

    while (leftPointer >= 0 && rightPointer <= s.length - 1 && s[leftPointer] == s[rightPointer]) {
        leftPointer--
        rightPointer++
    }

    return rightPointer - leftPointer - 1
}

fun main() {
    val s = "babad"

    println(longestPalindrome(s))
}