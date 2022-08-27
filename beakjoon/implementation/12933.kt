package beakjoon.implementation

import java.io.BufferedReader
import java.io.InputStreamReader



fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val duck = br.readLine()!!.toList()
    val size = duck.size
    val visited = Array(duck.size){false}
    val quack = "quack".toList()
    var cnt = 0

    if (size % 5 != 0){
        println(-1)

    }else{
        for (i in 0 until size){
            if (duck[i] == 'q' && !visited[i]){
               var k = 0
                var check = true
                for (j in i until size){
                    if (duck[j] == quack[k] && !visited[j]){
                        visited[j] = true
                        if (duck[j] == 'k'){
                            if (check){
                                check = false
                                cnt++
                            }

                            k = 0
                            continue
                        }
                        k++

                    }
                }
            }

        }

        if (!visited.all { it } || cnt == 0){
            println(-1)
        }else{
            println(cnt)
        }


    }

}
