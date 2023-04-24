fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    generate(result, "", 0, 0, n)

    return result
}

private fun generate(list: MutableList<String>, currentString: String, open: Int, close: Int, n: Int) {
    if (currentString.length == n * 2) {
        list.add(currentString)
        return
    }

    if (open < n) generate(list, "$currentString(", open + 1, close, n)
    if (close < open) generate(list, "$currentString)", open, close + 1, n)
}

fun main() {
    val n = 3

    println(generateParenthesis(n))
}