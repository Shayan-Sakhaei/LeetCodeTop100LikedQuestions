fun numIslands(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var islands = 0

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == '1') {
                islands++
                numIslands(grid, i, j)
            }
        }
    }

    return islands
}

fun numIslands(grid: Array<CharArray>, row: Int, column: Int) {
    if (row < 0 || row > grid.size || column < 0 || column > grid[row].size || grid[row][column] == '0') return

    grid[row][column] = '0'

    numIslands(grid, row - 1, column)
    numIslands(grid, row + 1, column)
    numIslands(grid, row, column - 1)
    numIslands(grid, row, column + 1)
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )

    println(numIslands(grid))
}