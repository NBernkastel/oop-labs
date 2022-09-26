package lab2

import java.io.BufferedReader
import kotlin.math.*;

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
var boardSize = 3
var currentIndex = 0
val game = ArrayList<Array<Array<Char>>>()
fun main() {
    game(test = false)
}

fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole,test : Boolean) {
    var board: Array<Array<Char>> = arrayOf(arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '));
    var move = true
    val reader  = BufferedReader(inputStream.reader())
    while (true) {
        var point: Pair<Int,Int>
        if (board.isFill()) {
            output.print("ничья")
            return
        }
        do {
            if (!test) output.println("Введите координаты")
            point = reader.readLine().pointFromString() ?: return
            if(!board.isRightMove(point)) output.println("координаты введены неверно")
        } while (!board.isRightMove(point))
        if (move)
            board[point.first][point.second] = 'X'
        else
            board[point.first][point.second] = '0'
        if(!test)
            output.println("игровая доска")
        if(!test)
            output.println("текущий ход $currentIndex")
            board.printBoard(output)
            game.add(board)
            currentIndex++;
        if (board.checkWin() == 'X') {
            output.print("X")
            return
        }
        if (board.checkWin() == '0') {
            output.print("0")
            return
        }
        move = !move
    }
}

fun Array<Array<Char>>.printBoard(out: PrintStream = outputConsole) {
    out.print(" ")
    for (i in 0 until boardSize)
        out.print(i)
    out.print("\n")
    for (i in 0 until boardSize) {
        out.print(i)
        for (j in 0 until boardSize) {
            out.print("${this[i][j]}")
        }
        out.println()
    }
}

fun Array<Array<Char>>.checkWin(): Char {
    val winLines = arrayOf(
        arrayOf(arrayOf(0, 0), arrayOf(0, 1), arrayOf(0, 2)),
        arrayOf(arrayOf(1, 0), arrayOf(1, 1), arrayOf(1, 2)),
        arrayOf(arrayOf(2, 0), arrayOf(2, 1), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(2, 0)),
        arrayOf(arrayOf(0, 1), arrayOf(1, 1), arrayOf(2, 1)),
        arrayOf(arrayOf(0, 2), arrayOf(1, 2), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 0), arrayOf(1, 1), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 2), arrayOf(1, 1), arrayOf(2, 0))
    )
    for (i in winLines) {
        if ((this[i[0][0]][i[0][1]] == this[i[1][0]][i[1][1]]) && (this[i[1][0]][i[1][1]] == this[i[2][0]][i[2][1]])
            && (this[i[0][0]][i[0][1]] != ' ' && this[i[1][0]][i[1]
                    [1]] != ' ' && this[i[2][0]][i[2][1]] != ' ')
        ) {
            return this[i[0][0]][i[0][1]]
        }
    }
    return ' '
}

fun Array<Array<Char>>.isFill(): Boolean {
    for (i in this) {
        for (j in i) {
            if (j == ' ')
                return false
        }
    }
    return true
}

fun String.pointFromString(): Pair<Int,Int>? {
    var point : Array<Int?> = this.split(' ').map{it.toIntOrNull() ?: null}.toTypedArray()
    if (point.size == 1)
        return Pair(-1,point[0]?:return null)
    else (point.size == 2)
        return Pair(point[0]?:return null,point[1]?:return null)
}

fun Array<Array<Char>>.isRightMove(point: Pair<Int,Int>): Boolean {
    return point.first in this.indices && point.second in this.indices && this[point.first][point.second] == ' '
}

fun area(r: Double): Double {
    return PI * r * r

}
fun Array<Array<Char>>.get(point: Pair<Int, Int>): Char {
    return this[point.first][point.second]
}

fun Array<Array<Char>>.get(point: Array<Int>): Char {
    return this[point[0]][point[1]]
}

fun Array<Array<Char>>.set(point: Pair<Int, Int>, char: Char) {
    this[point.first][point.second] = char
}