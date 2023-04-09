fun majorityElement(nums: IntArray): Int {
    val hashMap = HashMap<Int, Int>()
    for (num in nums) {
        hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        if (hashMap[num]!! > (nums.size / 2)) return num
    }

    return -1
}

fun majorityElementBoyerMoore(nums: IntArray): Int {
    var count = 0
    var candidate: Int = 0
    nums.forEach { num ->
        if (count == 0) {
            candidate = num
        }
        count += if (num == candidate) 1 else -1
    }

    return candidate
}

fun main() {
    val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
    println(majorityElement(nums))
    println(majorityElementBoyerMoore(nums))
}