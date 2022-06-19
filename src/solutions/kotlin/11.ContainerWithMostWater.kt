package solutions.kotlin

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */

fun maxAreaBruteForceApproach(height: IntArray): Int {
    var max = Int.MIN_VALUE

    for (i in 0 until height.size - 1) {
        for (j in i + 1 until height.size) {
            val currWidth = j - i
            val currHeight = kotlin.math.min(height[i], height[j])

            val containerArea = currWidth * currHeight

            max = kotlin.math.max(max, containerArea)
        }
    }

    return max
}

fun maxAreaTwoPointersApproach(height: IntArray): Int {
    var start = 0
    var end = height.size - 1
    var max = Int.MIN_VALUE

    while (start < end) {
        val area = (end - start) * kotlin.math.min(height[start], height[end])

        max = kotlin.math.max(max, area)

        if (height[start] < height[end]) start++
        else end--
    }

    return max
}


fun main() {
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(maxAreaBruteForceApproach(height))
    println(maxAreaTwoPointersApproach(height))
}