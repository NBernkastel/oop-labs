package lab4

import lab3.Board
import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream =
    PrintStream(System.out, true, "UTF-8")

fun main() {
    //game(stateStart = StateXO(Board("         "),'X'))
    Board.size = 5
    game(stateStart = StateBalda("games"))
}

fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole, stateStart : AbstractState) {
    val reader = BufferedReader(inputStream.reader())
    val game = MultiGame(stateStart)
    while (!game.gameOver) {
        var input = Input.parse(reader.readLine())
        when (input) {
            is Exit -> return
            is Step -> game.step(input)
            is TakeBack -> game.takeBack(input.shift)
        }
        print(game)
    }
}