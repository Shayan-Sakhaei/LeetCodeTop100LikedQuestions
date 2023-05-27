fun canJump(nums: IntArray): Boolean {
    var currIndex = nums.lastIndex

    for (i in nums.lastIndex downTo 0) {
        if (i + nums[i] >= currIndex) currIndex = i
    }

    return currIndex == 0
}

fun main() {
    val nums = intArrayOf(2, 3, 1, 1, 4)

    println(canJump(nums))
}