import java.util.Stack


class Solution {

    fun solution(ingredient: IntArray): Int {
    var answer: Int = 0
    var stack = Stack<Int>()
    for (i in ingredient){
        stack.push(i)
        if (stack.size >= 4){
            if (stack[stack.size - 4] == 1 &&
                stack[stack.size - 3] == 2 &&
                stack[stack.size - 2] == 3 &&
                stack[stack.size - 1] == 1){

                stack.pop()
                stack.pop()
                stack.pop()
                stack.pop()
                answer +=1
            }
        }
    }
        
        return answer
    }

}
