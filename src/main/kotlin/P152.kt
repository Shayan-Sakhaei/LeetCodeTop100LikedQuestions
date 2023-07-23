fun maxProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var maxProduct = nums[0]

    for (i in 1..nums.lastIndex) {
        val temp = max
        max = kotlin.math.max(kotlin.math.max(max * nums[i], min * nums[i]), nums[i])
        min = kotlin.math.min(kotlin.math.min(temp * nums[i], min * nums[i]), nums[i])
        maxProduct = kotlin.math.max(maxProduct, max)
    }

    return maxProduct
}

fun main() {
    val nums = intArrayOf(2, 3, -2, 4)

    println(maxProduct(nums))
}
