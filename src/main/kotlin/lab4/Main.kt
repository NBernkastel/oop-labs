package lab4

import lab3.Board
import lab5.GameException
import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream =
    PrintStream(System.out, true, "UTF-8")
var test = false
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
                is Step -> if (game.step(input)) game.step(input) else {
                    output.print("неверный ход\n");continue
                }
                is TakeBack -> game.takeBack(input.shift)
            }
            output.print(game)
    }
}