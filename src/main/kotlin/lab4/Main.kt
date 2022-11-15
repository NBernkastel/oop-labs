package lab4

import lab3.Board
import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream =
    PrintStream(System.out, true, "UTF-8")
var test = true
fun main() {
    //game(stateStart = StateXO(Board("         "),'X'))
    Board.size = 5
    game(stateStart = StateBalda("games"))
}

fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole, stateStart : AbstractState) {
    val reader = BufferedReader(inputStream.reader())
    val game = MultiGame(stateStart)
    while (!game.gameOver) {
        when (val input = Input.parse(reader.readLine())) {
            is Exit -> return
            is Step -> game.step(input)
            is TakeBack -> game.takeBack(input.shift)
        }
        output.print(game)
    }
}