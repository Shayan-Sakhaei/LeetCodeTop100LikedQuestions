fun longestConsecutive(nums: IntArray): Int {
    var longestSequence = 0
    val set = nums.toHashSet()

    for (i in 0..nums.lastIndex) {
        var currentSequence = 1

        var currentNum = nums[i]
        while (set.contains(--currentNum)) {
            currentSequence++
            set.remove(currentNum)
        }

        currentNum = nums[i]
        while (set.contains(++currentNum)) {
            currentSequence++
            set.remove(currentNum)
        }

        longestSequence = kotlin.math.max(longestSequence, currentSequence)
    }

    return longestSequence
}

fun main() {
    val nums = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)

    println(longestConsecutive(nums))
}