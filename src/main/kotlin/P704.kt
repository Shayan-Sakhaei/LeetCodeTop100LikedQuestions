fun search(nums: IntArray, target: Int): Int {
    var lowerBound = 0
    var upperBound = nums.size - 1

    while (lowerBound <= upperBound) {
        val mid = lowerBound + (upperBound - lowerBound) / 2
        if (nums[mid] == target) return mid
        else if (nums[mid] < target) lowerBound = mid + 1
        else upperBound = mid - 1
    }

    return -1
}

fun main() {
    val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
    val target = 9

    println(search(nums, target))
}