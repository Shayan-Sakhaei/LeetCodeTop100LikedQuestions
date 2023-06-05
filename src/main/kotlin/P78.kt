import java.util.*

fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    Arrays.sort(nums)

    subsets(nums, 0, mutableListOf(), result)

    return result
}

private fun subsets(nums: IntArray, start: Int, tempList: MutableList<Int>, result: MutableList<List<Int>>) {
    result.add(ArrayList(tempList))
    for (i in start..nums.lastIndex) {
        tempList.add(nums[i])
        subsets(nums, i + 1, tempList, result)
        tempList.removeAt(tempList.lastIndex)
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)

    println(subsets(nums))
}
