fun maxProfit(prices: IntArray): Int {
    var min = Int.MAX_VALUE
    var maxProfit = 0

    for (i in prices.indices) {
        if (prices[i] < min) min = prices[i]
        else if (prices[i] - min > maxProfit) maxProfit = prices[i] - min
    }

    return maxProfit
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))
}