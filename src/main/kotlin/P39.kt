fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    combination(candidates, result, target, 0, mutableListOf<Int>())
    return result
}

private fun combination(
    candidates: IntArray,
    list: MutableList<List<Int>>,
    target: Int,
    index: Int,
    currList: MutableList<Int>
) {
    if (currList.sum() == target) {
        list.add(ArrayList(currList))
        return
    }

    if (index > candidates.lastIndex || currList.sum() > target) {
        return
    }

    currList.add(candidates[index])
    combination(candidates, list, target, index, currList)
    currList.removeAt(currList.lastIndex)
    combination(candidates, list, target, index + 1, currList)
}

fun main() {
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7

    println(combinationSum(candidates, target))
}
