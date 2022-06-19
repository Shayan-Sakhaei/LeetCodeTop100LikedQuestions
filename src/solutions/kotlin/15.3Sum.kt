package solutions.kotlin

import java.util.*


/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var start = i + 1
        var end = nums.size - 1
        val requiredSum = 0 - nums[i]

        while (start < end) {
            if (nums[start] + nums[end] == requiredSum) {
                result.add(arrayListOf(nums[i], nums[start], nums[end]))

                while (start < end && nums[start] == nums[start + 1]) start++
                while (start < end && nums[end] == nums[end - 1]) end--

                start++
                end--
            } else if (nums[start] + nums[end] > requiredSum) {
                end--
            } else {
                start++
            }
        }
    }

    return result
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)

    println(threeSum(nums))
}