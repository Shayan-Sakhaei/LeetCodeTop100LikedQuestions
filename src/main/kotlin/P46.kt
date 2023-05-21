fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    permute(nums, mutableListOf(), result)
    return result
}

private fun permute(nums: IntArray, currList: MutableList<Int>, list: MutableList<List<Int>>) {
    if (currList.size == nums.size) {
        list.add(ArrayList(currList))
        return
    }

    for (i in nums.indices) {
        if (currList.contains(nums[i])) continue
        currList.add(nums[i])
        permute(nums, currList, list)
        currList.removeAt(currList.lastIndex)
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)

    println(permute(nums))
}