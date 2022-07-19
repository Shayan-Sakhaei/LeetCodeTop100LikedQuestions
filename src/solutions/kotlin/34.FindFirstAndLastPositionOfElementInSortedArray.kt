package solutions.kotlin

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */

fun searchRange(nums: IntArray, target: Int): IntArray {
    return intArrayOf(binarySearch(nums, target, true), binarySearch(nums, target, false))
}

private fun binarySearch(nums: IntArray, target: Int, isFirstElement: Boolean): Int {
    var start = 0
    var end = nums.size - 1
    var index = -1

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (target < nums[mid]) {
            end = mid - 1
        } else if (target > nums[mid]) {
            start = mid + 1
        } else {
            index = mid
            if (isFirstElement) end = mid - 1
            else start = mid + 1
        }
    }

    return index
}

fun main() {
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8

    println(searchRange(nums, target).toList())
}