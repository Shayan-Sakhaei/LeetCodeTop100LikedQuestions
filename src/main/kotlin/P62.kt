fun uniquePaths(m: Int, n: Int): Int {
    val paths = Array(m + 1) { IntArray(n + 1) }
    return paths(0, 0, m, n, paths)
}

private fun paths(row: Int, column: Int, m: Int, n: Int, paths: Array<IntArray>): Int {
    if (row >= m || column >= n) return 0
    if (row == m - 1 && column == n - 1) return 1
    if (paths[row][column] != 0) return paths[row][column]

    val r = paths(row, column + 1, m, n, paths)
    val c = paths(row + 1, column, m, n, paths)

    paths[row][column] = r + c
    return paths[row][column]
}

fun main() {
    val m = 3
    val n = 7

    println(uniquePaths(m, n))
}