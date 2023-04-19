fun maxArea(height: IntArray): Int {
    var leftBarrierIndex = 0
    var rightBarrierIndex = height.lastIndex
    var maxArea = 0

    while (leftBarrierIndex < rightBarrierIndex) {
        if (height[leftBarrierIndex] < height[rightBarrierIndex]) {
            maxArea = kotlin.math.max(maxArea, height[leftBarrierIndex] * (rightBarrierIndex - leftBarrierIndex))
            leftBarrierIndex++
        } else {
            maxArea = kotlin.math.max(maxArea, height[rightBarrierIndex] * (rightBarrierIndex - leftBarrierIndex))
            rightBarrierIndex--
        }
    }

    return maxArea
}

fun main() {
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(maxArea(height))
}