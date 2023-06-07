fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val columns = board[0].size
    val visited = Array(rows) { BooleanArray(columns) { false } }

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (word[0] == board[i][j] && exist(board, word, i, j, 0, visited)) return true
        }
    }
    return false
}

private fun exist(
    board: Array<CharArray>,
    word: String,
    i: Int,
    j: Int,
    charIndex: Int,
    visited: Array<BooleanArray>
): Boolean {
    if (charIndex == word.length) return true

    if (i < 0 || i >= board.size ||
        j < 0 || j >= board[i].size ||
        word[charIndex] != board[i][j] || visited[i][j]
    ) return false

    visited[i][j] = true

    if (exist(board, word, i + 1, j, charIndex + 1, visited) ||
        exist(board, word, i - 1, j, charIndex + 1, visited) ||
        exist(board, word, i, j + 1, charIndex + 1, visited) ||
        exist(board, word, i, j - 1, charIndex + 1, visited)
    ) return true

    visited[i][j] = false
    return false
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"

    println(exist(board, word))
}
