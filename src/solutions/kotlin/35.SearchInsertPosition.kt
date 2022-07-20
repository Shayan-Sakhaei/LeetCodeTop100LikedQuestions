package solutions.kotlin

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        if (target == nums[mid]) {
            return mid
        } else if (target < nums[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return start
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 2

    println(searchInsert(nums, target))
}