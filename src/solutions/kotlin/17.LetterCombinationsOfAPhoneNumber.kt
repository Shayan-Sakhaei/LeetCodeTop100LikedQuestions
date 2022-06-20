package solutions.kotlin

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return listOf()

    val result = mutableListOf<String>()

    val map = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )

    combinations(digits, map, 0, StringBuilder(), result)

    return result
}

private fun combinations(
    digits: String,
    map: HashMap<Char, String>,
    index: Int,
    sb: StringBuilder,
    result: MutableList<String>
) {

    if (index == digits.length) {
        result.add(sb.toString())
        return
    }

    val digit = digits[index]
    val numberCharacters = map[digit]!!

    for (char in numberCharacters) {
        sb.append(char)

        combinations(digits, map, index + 1, sb, result)

        sb.deleteCharAt(sb.length - 1)
    }
}

fun main() {
    val digits = "23"

    println(letterCombinations(digits))
}