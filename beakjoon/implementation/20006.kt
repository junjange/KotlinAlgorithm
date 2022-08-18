import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


object Main {
    var P = 0
    var M = 0
    private var rooms: MutableList<Room> = ArrayList()
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val pmInfo = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        P = pmInfo[0].toInt()
        M = pmInfo[1].toInt()
        for (i in 0 until P) {
            //레벨 l
            //닉네임 n
            val playerInfo = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val l = playerInfo[0].toInt()
            val nickname = playerInfo[1]
            var hasRoom = false
            for (room in rooms) {
                if (!room.isValidLevel(l)) continue
                if (room.isFull) continue
                room.member++
                if (room.member == M) {
                    room.isFull = true
                }
                room.peoples.add(Pair(nickname, l))
                hasRoom = true
                break
            }
            if (!hasRoom) {
                val newRoom = Room(l, M)
                newRoom.peoples.add(Pair(nickname, l))
                rooms.add(newRoom)
            }
        }
        val sb = StringBuilder()
        for (room in rooms) {
            room.peoples.sortWith(Comparator { a: Pair, b: Pair -> a.nickname.compareTo(b.nickname) })
            if (room.isFull) {
                sb.append("Started!\n")
            } else {
                sb.append("Waiting!\n")
            }
            for (person in room.peoples) {
                sb.append(person.level).append(" ").append(person.nickname).append("\n")
            }
        }
        println(sb)
    }

    internal class Pair(var nickname: String, var level: Int)
    internal class Room(level: Int, maxv: Int) {
        var isFull: Boolean
        var member: Int
        var level: Int
        var peoples: MutableList<Pair>

        init {
            isFull = if (maxv == 1) true else false
            member = 1
            this.level = level
            peoples = ArrayList()
        }

        fun isValidLevel(level: Int): Boolean {
            val result = Math.abs(this.level - level)
            return result <= 10
        }
    }
}
