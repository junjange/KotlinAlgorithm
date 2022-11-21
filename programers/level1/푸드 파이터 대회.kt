package progrmers.level1

class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        food.forEachIndexed { idx, f ->
            val cnt = if (f % 2 != 0) f - 1 else f
            repeat(cnt / 2) {
                answer += "$idx"
            }

        }
        val reserveAnswer = answer.reversed()
        answer += "0"
        answer += reserveAnswer

        return answer
    }
}
