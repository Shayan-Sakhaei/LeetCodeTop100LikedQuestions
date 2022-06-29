package solutions.kotlin

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    generate(n, n, "", result)

    return result
}

private fun generate(open: Int, close: Int, str: String, result: MutableList<String>) {
    if (open == 0 && close == 0) {
        result.add(str)
        return
    }

    if (open != 0) {
        generate(open - 1, close, "$str(", result)
    }

    if (open < close) {
        generate(open, close - 1, "$str)", result)
    }
}

fun main() {
    val n = 3

    println(generateParenthesis(n))
}