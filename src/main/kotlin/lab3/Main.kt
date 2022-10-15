package lab3
import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream
val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
fun game(
    inputStream: InputStream = System.`in`,
    output: PrintStream = outputConsole
) {
    val reader = BufferedReader(inputStream.reader())

    val game = Game()
    var finish = false
    output.print(game)
    do {
        output.print("Ваш ход или команда\n")
        val arr = reader.readLine().split(" ")
        if (arr.size != 2)
            finish = true
        else {
            val x = arr[0].toIntOrNull()
            val y = arr[1].toIntOrNull()
            if (x == null || y == null)
                output.print("Неверные координаты или команда\n")
            else {
                if (x == -1)
                    if (game.takeBack(y))
                        output.print(game)
                    else
                        output.print("Неправильная команда\n")
                else
                    if (game.step(Point(x, y)))
                        output.print(game)
            }
        }
    } while (!finish && !game.gameOver)
}


fun main() {
    game()
}

