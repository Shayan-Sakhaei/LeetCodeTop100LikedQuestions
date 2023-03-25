import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s) {
        when (char) {
            '(' -> {
                stack.push('(')
            }

            '[' -> {
                stack.push('[')
            }

            '{' -> {
                stack.push('{')
            }

            ')' -> {
                if (stack.isNotEmpty() && stack.peek() == '(') stack.pop()
                else return false
            }

            ']' -> {
                if (stack.isNotEmpty() && stack.peek() == '[') stack.pop()
                else return false
            }

            '}' -> {
                if (stack.isNotEmpty() && stack.peek() == '{') stack.pop()
                else return false
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    val s = "()[]{}"
    println(isValid(s))
}