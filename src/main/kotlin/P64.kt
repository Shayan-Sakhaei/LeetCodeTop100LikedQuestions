fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            when {
                i == 0 && j == 0 -> dp[i][j] = grid[i][j]
                i == 0 -> dp[i][j] = dp[i][j - 1] + grid[i][j]
                j == 0 -> dp[i][j] = dp[i - 1][j] + grid[i][j]
                else -> dp[i][j] = grid[i][j] + kotlin.math.min(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }

    return dp[m - 1][n - 1]
}

fun main() {
    val grid = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))

    println(minPathSum(grid))
}