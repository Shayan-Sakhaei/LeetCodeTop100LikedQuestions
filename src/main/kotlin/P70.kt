fun climbStairs(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2
    val memo = IntArray(n)
    memo[0] = 1
    memo[1] = 2

    for (i in 2 until n) {
        memo[i] = memo[i - 1] + memo[i - 2]
    }

    return memo[n - 1]
}

fun main() {
    val n = 3
    println(climbStairs(n))
}