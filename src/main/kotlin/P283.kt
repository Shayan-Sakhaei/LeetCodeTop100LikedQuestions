fun moveZeroes(nums: IntArray): Unit {
    var left = 0
    for (right in nums.indices) {
        if (nums[right] != 0) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
        }
    }
}
