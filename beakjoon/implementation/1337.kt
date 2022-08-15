package beakjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(n) {br.readLine()!!.toInt()}.sorted()
    val answer = arrayListOf<Int>()

    for (i in arr){
        var cnt = 0
        for (j in i until i+5){
            if (j !in arr){
                cnt++
            }
        }
        answer.add(cnt)

    }

    println(answer.minOrNull())

}
