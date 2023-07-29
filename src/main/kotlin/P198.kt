fun rob(nums: IntArray): Int {
    val dp = IntArray(nums.size + 1)
    dp[0] = 0
    dp[1] = nums[0]

    for (i in 1 until nums.size) {
        dp[i + 1] = kotlin.math.max(dp[i], dp[i - 1] + nums[i])
    }

    return dp[nums.size]
}

fun main() {
    val nums = intArrayOf(2, 7, 9, 3, 1)

    println(rob(nums))
}