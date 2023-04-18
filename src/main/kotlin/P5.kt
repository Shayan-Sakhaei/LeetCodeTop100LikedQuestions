fun longestPalindrome(s: String): String {
    var start = 0
    var end = 0

    for (i in s.indices) {
        val oddLength = expandPalindrome(s, i, i)
        val evenLength = expandPalindrome(s, i, i + 1)
        val length = kotlin.math.max(oddLength, evenLength)
        if (length > end - start) {
            start = i - ((length - 1) / 2)
            end = i + (length / 2)
        }
    }

    return s.substring(start, end + 1)
}

private fun expandPalindrome(s: String, left: Int, right: Int): Int {
    var currLeft = left
    var currRight = right
    while (currLeft >= 0 && currRight < s.length && s[currLeft] == s[currRight]) {
        currLeft--
        currRight++
    }

    return currRight - currLeft - 1
}

fun main() {
    val s = "babad"

    println(longestPalindrome(s))
}