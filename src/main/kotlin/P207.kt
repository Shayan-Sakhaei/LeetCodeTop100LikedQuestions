import java.util.*

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adj = Array<MutableList<Int>>(numCourses) { mutableListOf() }
    val indegree = IntArray(numCourses)
    val answer = mutableListOf<Int>()

    for (pair in prerequisites) {
        val course = pair[0]
        val prerequisite = pair[1]
        adj[prerequisite].add(course)
        indegree[course]++
    }

    val queue = LinkedList<Int>()
    for (i in 0 until numCourses) {
        if (indegree[i] == 0) {
            queue.offer(i)
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        answer.add(current)
        for (next in adj[current]) {
            indegree[next]--
            if (indegree[next] == 0) {
                queue.offer(next)
            }
        }
    }

    return answer.size == numCourses
}

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))

    println(canFinish(numCourses, prerequisites))
}