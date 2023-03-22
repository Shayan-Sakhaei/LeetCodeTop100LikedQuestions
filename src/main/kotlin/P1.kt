fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

fun twoSumHashMap(nums: IntArray, target: Int): IntArray {
    val hashMap = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (hashMap.containsKey(complement)) {
            return intArrayOf(hashMap[complement]!!, i)
        } else {
            hashMap[nums[i]] = i
        }
    }
    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSumBruteForce(nums, target).toList())
    println(twoSumHashMap(nums, target).toList())
}