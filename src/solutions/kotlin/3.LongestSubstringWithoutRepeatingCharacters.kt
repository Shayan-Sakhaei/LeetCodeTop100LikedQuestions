package solutions.kotlin

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

fun lengthOfLongestSubstring(s: String): Int {
    val set = hashSetOf<Char>()
    var maxLength = 0
    var left = 0

    for (i in s.indices) {
        while (!set.add(s[i])) {
            set.remove(s[left++])
        }
        maxLength = kotlin.math.max(maxLength, set.size)
    }

    return maxLength
}

fun main() {
    val s = "abcabcbb"

    println(lengthOfLongestSubstring(s))
}