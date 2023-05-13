fun searchRange(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    result[0] = findFirstPosition(nums, target)
    result[1] = findLastPosition(nums, target)
    return result
}

fun findFirstPosition(nums: IntArray, target: Int): Int {
    var index = -1
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] >= target) end = mid - 1
        else start = mid + 1
        if (nums[mid] == target) index = mid
    }

    return index
}

fun findLastPosition(nums: IntArray, target: Int): Int {
    var index = -1
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] <= target) start = mid + 1
        else end = mid - 1
        if (nums[mid] == target) index = mid
    }

    return index
}

fun main() {
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8

    println(searchRange(nums, target).toList())
}