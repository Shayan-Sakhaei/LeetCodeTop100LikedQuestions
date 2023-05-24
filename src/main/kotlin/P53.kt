fun maxSubArray(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var currSum = 0

    for (num in nums) {
        if (currSum < 0) currSum = 0
        currSum += num
        max = kotlin.math.max(max, currSum)
    }

    return max
}

fun main() {
    val nums = intArrayOf(-2, 1)

    println(maxSubArray(nums))
}