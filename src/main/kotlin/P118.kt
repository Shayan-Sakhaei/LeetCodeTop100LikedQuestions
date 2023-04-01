fun generate(numRows: Int): List<List<Int>> {
    val triangle = mutableListOf<MutableList<Int>>()
    triangle.add(mutableListOf(1))

    for (i in 1 until numRows) {
        val prevRow = triangle[i - 1]
        val currentRow = mutableListOf<Int>()
        currentRow.add(1)
        for (j in 1 until i) {
            currentRow.add(prevRow[j - 1] + prevRow[j])
        }
        currentRow.add(1)
        triangle.add(currentRow)
    }

    return triangle
}

fun main() {
    val numRows = 5
    println(generate(numRows))
}