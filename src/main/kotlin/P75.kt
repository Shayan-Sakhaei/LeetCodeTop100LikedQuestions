fun sortColors(nums: IntArray): Unit {
    for (i in nums.indices) {
        for (j in 1 until nums.size - i) {
            if (nums[j - 1] > nums[j]) {
                val temp = nums[j - 1]
                nums[j - 1] = nums[j]
                nums[j] = temp
            }
        }
    }
}