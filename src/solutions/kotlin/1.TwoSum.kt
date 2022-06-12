package solutions.kotlin

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()

    for (i in nums.indices) {
        val requiredNumber = target - nums[i]
        if (map.containsKey(requiredNumber)) {
            return intArrayOf(map[requiredNumber]!!, i)
        }
        map[nums[i]] = i
    }

    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    println(twoSum(nums, target).toList())
}