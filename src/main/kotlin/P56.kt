fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    val result = mutableListOf<IntArray>()
    var currentInterval = intervals[0]
    result.add(currentInterval)

    for (interval in intervals) {
        val currentEnd = currentInterval[1]
        val nextBegin = interval[0]
        val nextEnd = interval[1]

        if (currentEnd >= nextBegin) {
            currentInterval[1] = kotlin.math.max(currentEnd, nextEnd)
        } else {
            currentInterval = interval
            result.add(currentInterval)
        }
    }

    return result.toTypedArray()
}

fun main() {
    val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))

    merge(intervals).forEach {
        println(it.toList())
    }
}