fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (s.isEmpty()) return false
    val n = s.length
    val dp = BooleanArray(n)

    for (i in 0 until n) {
        for (j in 0..i) {
            val substring = s.substring(j, i + 1)
            if (wordDict.contains(substring) && (j == 0 || dp[j - 1])) {
                dp[i] = true
                break
            }
        }
    }

    return dp[n - 1]
}


fun main() {
    val s = "cars"
    val wordDict = listOf("car", "ca", "rs")

    println(wordBreak(s, wordDict))
}