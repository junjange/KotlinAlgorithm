package beakjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n : Int = br.readLine().toInt()
    val map = TreeMap<String, Int>()
    for (i in 0 until n){
        val pile : String = br.readLine()
        val path = pile.split(".")[1]

        if (path in map){
            map[path] = map[path]!! + 1
        }else{
            map[path] = 1
        }
    }

    for ((key, value) in map){
        println("$key $value")
    }

}
