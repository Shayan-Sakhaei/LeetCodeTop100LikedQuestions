class P33 {
    fun search(nums: IntArray, target: Int): Int {
        var lowerBound = 0
        var upperBound = nums.lastIndex

        while (lowerBound < upperBound) {
            val mid = lowerBound + (upperBound - lowerBound) / 2
            if (nums[mid] > nums[upperBound]) {
                lowerBound = mid + 1
            } else {
                upperBound = mid
            }
        }

        val start = lowerBound
        lowerBound = 0
        upperBound = nums.lastIndex

        if (target >= nums[start] && target <= nums[upperBound]) lowerBound = start
        else upperBound = start

        return binarySearch(nums, lowerBound, upperBound, target)
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        var lowerBound = start
        var upperBound = end

        while (lowerBound <= upperBound) {
            val mid = lowerBound + (upperBound - lowerBound) / 2
            if (nums[mid] == target) return mid
            else if (nums[mid] < target) lowerBound = mid + 1
            else upperBound = mid - 1
        }

        return -1
    }
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0

    println(P33().search(nums, target))
}