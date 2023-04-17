fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var end = 0
    var maxLength = 0
    val hashSet = HashSet<Char>()

    while (end < s.length) {
        if (hashSet.add(s[end])) {
            end++
            maxLength = kotlin.math.max(maxLength, hashSet.size)
        } else {
            hashSet.remove(s[start])
            start++
        }
    }

    return maxLength
}

fun main() {
    val s = "pwwkew"

    println(lengthOfLongestSubstring(s))
}