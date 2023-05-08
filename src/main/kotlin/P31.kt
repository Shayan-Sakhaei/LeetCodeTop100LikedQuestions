fun nextPermutation(nums: IntArray): Unit {
    var i = nums.size - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }
    if (i >= 0) {
        var j = nums.size - 1
        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }
        swap(nums, i, j)
    }
    reverse(nums, i + 1)
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

private fun reverse(nums: IntArray, start: Int) {
    var start = start
    var end = nums.size - 1
    while (start < end) {
        swap(nums, start, end)
        start++
        end--
    }
}
