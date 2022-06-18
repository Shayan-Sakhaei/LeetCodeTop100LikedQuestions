package solutions.kotlin

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }

    for (i in 0 until s.length + 1) {
        for (j in 0 until p.length + 1) {
            if (i == 0 && j == 0) dp[i][j] = true
            else if (j == 0) dp[i][j] = false
            else if (i == 0) {
                if (p[j - 1] != '*') dp[i][j] = false
                else dp[i][j] = dp[i][j - 2]
            } else {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') dp[i][j] = dp[i - 1][j - 1]
                else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2]
                    if (s[i - 1] == p[j - 2] || p[j - 2] == '.') dp[i][j] = dp[i][j] || dp[i - 1][j]
                } else dp[i][j] = false
            }
        }
    }

    return dp[s.length][p.length]
}

fun main() {
    val s = "aa"
    val p = "a*"

    println(isMatch(s, p))
}