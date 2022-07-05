package solutions.kotlin

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 */

fun nextPermutation(nums: IntArray): Unit {
    var i = nums.size - 2

    while (i >= 0 && nums[i] >= nums[i + 1]) i--

    if (i < 0) {
        reverse(nums, 0, nums.size - 1)
    } else {
        var j = nums.size - 1
        while (j >= 0 && nums[i] >= nums[j]) j--

        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

        reverse(nums, i + 1, nums.size - 1)
    }
}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var currStart = start
    var currEnd = end

    while (currStart < currEnd) {
        val temp = nums[currStart]
        nums[currStart] = nums[currEnd]
        nums[currEnd] = temp

        currStart++
        currEnd--
    }
}
