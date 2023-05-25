fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    var rowStart = 0
    var rowEnd = matrix.size - 1
    var columnStart = 0
    var columnEnd = matrix[0].size - 1

    while (rowStart <= rowEnd && columnStart <= columnEnd) {
        for (i in columnStart..columnEnd) {
            result.add(matrix[rowStart][i])
        }
        rowStart++

        for (i in rowStart..rowEnd) {
            result.add(matrix[i][columnEnd])
        }
        columnEnd--

        if (rowStart <= rowEnd) {
            for (i in columnEnd downTo columnStart) {
                result.add(matrix[rowEnd][i])
            }
        }
        rowEnd--

        if (columnStart <= columnEnd) {
            for (i in rowEnd downTo rowStart) {
                result.add(matrix[i][columnStart])
            }
        }
        columnStart++
    }

    return result
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

    println(spiralOrder(matrix))
}