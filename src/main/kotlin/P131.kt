fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    partition(s, 0, mutableListOf(), result)
    return result
}

private fun partition(
    s: String,
    index: Int,
    tempList: MutableList<String>,
    list: MutableList<List<String>>,
) {
    if (s.isEmpty()) {
        list.add(ArrayList(tempList))
        return
    }

    for (i in 0..s.lastIndex) {
        val current = s.substring(0, i + 1)
        if (isPalindrome(current)) {
            tempList.add(current)
            partition(s.substring(i + 1), index + 1, tempList, list)
            tempList.removeAt(tempList.lastIndex)
        }
    }
}

private fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.lastIndex
    while (start <= end) {
        if (s[start].compareTo(s[end]) != 0) return false
        start++
        end--
    }

    return true
}

fun main() {
    val s = "aab"
    println(partition(s))
}