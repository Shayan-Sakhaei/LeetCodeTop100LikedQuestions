fun romanToInt(s: String): Int {
    var int = 0
    val hashMap = hashMapOf<Char, Int>(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    for (i in s.indices) {
        if (i + 1 < s.length && hashMap[s[i]]!! < hashMap[s[i + 1]]!!) {
            int -= hashMap[s[i]]!!
        } else {
            int += hashMap[s[i]]!!
        }
    }

    return int
}

fun main() {
    val s = "MCMXCIV"
    println(romanToInt(s))
}
