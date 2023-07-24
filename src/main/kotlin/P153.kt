fun findMin(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) return nums[0]

    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val mid = left + (right - left) / 2
        if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid]
        if (nums[left] <= nums[mid] && nums[mid] > nums[right]) left = mid + 1
        else right = mid - 1
    }

    return nums[left]
}

fun main() {
    val nums = intArrayOf(3, 4, 5, 1, 2)

    println(findMin(nums))
}