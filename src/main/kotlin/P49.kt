fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val hashMap = HashMap<String, MutableList<String>>()

    for (i in strs.indices) {
        val sortedWord = strs[i].toCharArray().sorted().joinToString("")
        if (hashMap.contains(sortedWord)) {
            val anagramsList = hashMap[sortedWord]
            anagramsList!!.add(strs[i])
        } else {
            hashMap[sortedWord] = mutableListOf(strs[i])
        }
    }

    return hashMap.values.toList()
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    println(groupAnagrams(strs))
}