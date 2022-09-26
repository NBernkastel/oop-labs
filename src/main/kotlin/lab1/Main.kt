package lab1

import java.io.BufferedReader
import kotlin.math.*;

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
var boardSize = 3
fun main() {
    game(test = true)
}

fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole,test : Boolean) {
    var board: Array<Array<Char>> = arrayOf(arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '));
    var move = true
    val reader  = BufferedReader(inputStream.reader())
    while (true) {
        var point: Array<Int>
        if (isFill(board)) {
            output.print("ничья")
            return
        }
        do {
            if (!test)
                output.println("Введите координаты")
            point = pointFromString(reader.readLine())
            if (point.contentEquals(arrayOf(-1, -1)))
                return;
            if(!isRightMove(board,point))
                output.println("координаты введены неверно")
        } while (!isRightMove(board, point))
        if (move)
            board[point[0]][point[1]] = 'X'
        else
            board[point[0]][point[1]] = '0'
        if(!test)
            output.println("игровая доска")
        if(!test)
            printBoard(board, output)
        if (checkWin(board) == 'X') {
            output.print("X")
            return
        }
        if (checkWin(board) == '0') {
            output.print("0")
            return
        }
        move = !move
    }
}

fun printBoard(board: Array<Array<Char>>, out: PrintStream = outputConsole) {
    out.print(" ")
    for (i in 0 until boardSize)
        out.print(i)
    out.print("\n")
    for (i in 0 until boardSize) {
        out.print(i)
        for (j in 0 until boardSize) {
            out.print("${board[i][j]}")
        }
        out.println()
    }
}

fun checkWin(board: Array<Array<Char>>): Char {
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
        if ((board[i[0][0]][i[0][1]] == board[i[1][0]][i[1][1]]) && (board[i[1][0]][i[1][1]] == board[i[2][0]][i[2][1]])
            && (board[i[0][0]][i[0][1]] != ' ' && board[i[1][0]][i[1]
                    [1]] != ' ' && board[i[2][0]][i[2][1]] != ' ')
        ) {
            return board[i[0][0]][i[0][1]]
        }
    }
    return ' '
}

fun isFill(board: Array<Array<Char>>): Boolean {
    for (i in board) {
        for (j in i) {
            if (j == ' ')
                return false
        }
    }
    return true
}

fun pointFromString(string: String): Array<Int> {
    return string.split(' ').map { it.toIntOrNull() ?: return arrayOf(-1, -1) }.toTypedArray()
}

fun isRightMove(board: Array<Array<Char>>, point: Array<Int>): Boolean {
    return point[0] in board.indices && point[1] in board.indices && board[point[0]][point[1]] == ' '
}

fun area(r: Double): Double {
    return PI * r * r
}