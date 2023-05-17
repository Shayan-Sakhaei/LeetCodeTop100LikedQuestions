fun jump(nums: IntArray): Int {
    var minimumJumps = 0
    var curEnd = 0
    var curFarthest = 0

    for (i in 0 until nums.lastIndex) {
        curFarthest = kotlin.math.max(curFarthest, i + nums[i])
        if (i == curEnd) {
            minimumJumps++
            curEnd = curFarthest
        }
    }

    return minimumJumps
}

fun main() {
    val nums = intArrayOf(2, 3, 1, 1, 4)

    println(jump(nums))
}