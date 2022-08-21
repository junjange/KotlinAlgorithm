package beakjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n : Int = br.readLine().toInt()
    val m : Int = br.readLine().toInt()
    val graph= Array(n){IntArray(n)}
    var num = 1
    var l=0
    var x=n/2
    var y=n/2
    graph[x][y] = 1
    var answer = Pair(x,y)

    val dx = arrayListOf<Int>(0, 1, 0, -1)
    val dy = arrayListOf<Int>(1, 0, -1, 0)
    while (true){

        for (i in 0 until  4){
            for (j in 0 until l){

                x += dx[i]
                y += dy[i]
                num += 1

                graph[x][y] = num



            }
        }




        if (x == 0 && y == 0) {
            break

        }


        x -= 1
        y -= 1
        l += 2




    }
    var mx = 0
    var my = 0
    for(i in graph.indices){
        for(j in graph[i].indices){
            sb.append("${graph[i][j]} ")

            if(graph[i][j] == m){
                 mx = i+1
                 my = j+1
            }
        }
        sb.append("\n")

    }
    sb.append("$mx $my")

    println(sb)


}
