fun singleNumber(nums: IntArray): Int {
    val hashSet = HashSet<Int>()
    for (num in nums) {
        if (hashSet.contains(num)) hashSet.remove(num)
        else hashSet.add(num)
    }

    return hashSet.first()
}

fun singleNumberXOR(nums: IntArray): Int {
    var singleNumber = 0
    for (i in nums.indices) {
        singleNumber = singleNumber xor nums[i]
    }
    return singleNumber
}

fun main() {
    val nums = intArrayOf(4, 1, 2, 1, 2)
    println(singleNumber(nums))
    println(singleNumberXOR(nums))
}
