fun rotate(nums: IntArray, k: Int) {
    val ks = k % nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, ks - 1)
    reverse(nums, ks, nums.size - 1)
}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var startIndex = start
    var endIndex = end

    while (startIndex <= endIndex) {
        val temp = nums[startIndex]
        nums[startIndex] = nums[endIndex]
        nums[endIndex] = temp

        startIndex++
        endIndex--
    }
}
