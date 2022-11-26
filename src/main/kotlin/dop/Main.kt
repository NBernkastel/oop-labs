package dop

import lab3.Board
import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream =
    PrintStream(System.out, true, "UTF-8")
var test = false
fun main() {
    game(stateStart = EStateXO(Board("         "), Turn.X))
    Board.size = 5
    //game(stateStart = EStateBalda("games"))
}

fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole, stateStart: EAbstractState) {
    val reader = BufferedReader(inputStream.reader())
    val game = EGame(stateStart)
    while (!game.gameOver) {
        try {
            when (val input = Input.parse(reader.readLine())) {
                is Exit -> return
                is Step -> game.step(input)
                is TakeBack -> game.takeBack(input.shift)
            }
            output.print(game)
        } catch (e: GameException) {
            output.println(e.message)
        }
    }
}