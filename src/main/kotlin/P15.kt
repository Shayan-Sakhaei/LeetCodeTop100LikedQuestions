fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val hashSet = HashSet<List<Int>>()

    for (i in 0 until nums.size - 1) {
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum < 0 -> {
                    left++
                }

                sum > 0 -> {
                    right--
                }

                else -> {
                    hashSet.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }
            }
        }
    }

    return hashSet.toList()
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)

    println(threeSum(nums))
}