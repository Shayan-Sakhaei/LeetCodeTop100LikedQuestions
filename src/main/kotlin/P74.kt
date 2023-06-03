fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val columns = matrix[0].size
    var low = 0
    var high = rows * columns - 1

    while (low <= high) {
        val mid1D = low + (high - low) / 2
        val mid2D = matrix[mid1D / columns][mid1D % columns]
        if (mid2D == target) return true
        else if (mid2D < target) low = mid1D + 1
        else high = mid1D - 1
    }

    return false
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
    val target = 3

    println(searchMatrix(matrix, target))
}