package solutions.kotlin


/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    combination(candidates, target, 0, mutableListOf(), result)
    return result
}

private fun combination(
    candidates: IntArray,
    target: Int,
    index: Int,
    composed: MutableList<Int>,
    result: MutableList<List<Int>>
) {
    if (index == candidates.size) {

        if (target == 0) {
            result.add(ArrayList(composed))
        }

        return
    }

    if (candidates[index] <= target) {
        composed.add(candidates[index])
        combination(candidates, target - candidates[index], index, composed, result)
        composed.removeAt(composed.size - 1)
    }

    combination(candidates, target, index + 1, composed, result)
}

fun main() {
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7

    println(combinationSum(candidates, target))
}

