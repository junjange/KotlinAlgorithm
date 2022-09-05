import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bingo = Array(5){ IntArray(5) { 0 } }
    val map = HashMap<Int,Pair<Int,Int>>()
    val horizontal = IntArray(5) {0}
    val vertical = IntArray(5) {0}
    var diagonal1 = 0
    var diagonal2 = 0
    val diagonal2Element = intArrayOf(4, 13, 22, 31, 40) // 반대 대각선 확인
    var clear = 0
    var answer = 0

    for(i in 0..4) {
        val elements = readLine().split(" ").map { it.toInt() }.toIntArray()
        for(j in elements.indices) {
            bingo[i][j] = elements[j]
            map[elements[j]] = i to j
        }
    }

    val builder = StringBuilder()
    for(i in 0..4) {
        readLine().split(" ").map { it.toInt() }.forEach {
            answer++
            val (x,y) = map[it]!!
            horizontal[x] += 1
            vertical[y] += 1

            // 대각선 확인
            if(x == y) diagonal1++

            // 반대 대각선 확인
            builder.append(x,y)
            if(diagonal2Element.contains(builder.toString().toInt())) diagonal2++
            builder.clear()

            // 수평
            if(horizontal[x] == 5) {
                clear++
                horizontal[x] = 0
            }

            // 수직
            if(vertical[y] == 5) {
                clear++
                vertical[y] = 0
            }

            // 대각선
            if(diagonal1 == 5) {
                clear++
                diagonal1 = 0
            }

            // 반대 대각선
            if(diagonal2 == 5) {
                clear++
                diagonal2 = 0
            }

            // 빙고 횟수 확인
            if(clear >= 3) {
                print("$answer")
                return@with
            }
        }
    }

    print("$answer")
}
