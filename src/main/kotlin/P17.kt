fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return listOf()

    val result = mutableListOf<String>()
    val digitToChar = hashMapOf<Char, CharArray>(
        '2' to charArrayOf('a', 'b', 'c'),
        '3' to charArrayOf('d', 'e', 'f'),
        '4' to charArrayOf('g', 'h', 'i'),
        '5' to charArrayOf('j', 'k', 'l'),
        '6' to charArrayOf('m', 'n', 'o'),
        '7' to charArrayOf('p', 'q', 'r', 's'),
        '8' to charArrayOf('t', 'u', 'v'),
        '9' to charArrayOf('w', 'x', 'y', 'z')
    )

    combinations(digits, result, digitToChar, StringBuilder(), 0)

    return result
}

private fun combinations(
    digits: String,
    list: MutableList<String>,
    map: HashMap<Char, CharArray>,
    sb: StringBuilder,
    startIndex: Int
) {
    if (sb.length == digits.length) {
        list.add(sb.toString())
        return
    }

    for (char in map[digits[startIndex]]!!) {
        sb.append(char)
        combinations(digits, list, map, sb, startIndex + 1)
        sb.deleteCharAt(sb.length - 1)
    }
}

fun main() {
    val digits = "23"

    println(letterCombinations(digits))
}