class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        fun solution(N: Int, stages: IntArray): IntArray {
        val countMap = mutableMapOf<Int, Double>()
        var n = stages.size

        for (i in 1..N) {
            val count = stages.count {
                i == it
            }

            if (count != 0) {
                countMap[i] = (count.toDouble() / n.toDouble())
                n -= count
            } else {
                countMap[i] = 0.0
            }
        }

        val keys = countMap.toList().sortedByDescending { (_, value) -> value }.toMap().keys

        return keys.toIntArray()
    }
}
