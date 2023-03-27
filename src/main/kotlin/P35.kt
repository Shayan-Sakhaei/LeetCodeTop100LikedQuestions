fun searchInsert(nums: IntArray, target: Int): Int {
    var lowerIndex = 0
    var upperIndex = nums.lastIndex

    while (lowerIndex <= upperIndex) {
        val midIndex = lowerIndex + (upperIndex - lowerIndex) / 2
        when {
            target == nums[midIndex] -> {
                return midIndex
            }

            target < nums[midIndex] -> {
                upperIndex = midIndex - 1
            }

            target > nums[midIndex] -> {
                lowerIndex = midIndex + 1
            }
        }
    }

    return lowerIndex
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 4
    println(searchInsert(nums, target))

}