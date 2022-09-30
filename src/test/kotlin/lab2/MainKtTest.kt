package lab2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.math.PI

var outputBuffer = ByteArrayOutputStream()
var output = PrintStream(outputBuffer)

class MainKtTest : StringSpec({

    "print board" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf(' ', ' ', ' '),
            arrayOf(' ', 'X', ' '),
            arrayOf(' ', ' ', '0')
        )
        board.printBoard(output)
        outputBuffer.toString() shouldBe " 012\n0   \r\n1 X \r\n2  0\r\n"
    }
    "print board2" {
        outputBuffer.reset()
        boardSize = 4
        val board = arrayOf(
            arrayOf(' ', ' ', ' ', ' '),
            arrayOf(' ', 'X', ' ', ' '),
            arrayOf(' ', ' ', '0', ' '),
            arrayOf(' ', ' ', '0', ' ')
        )
        board.printBoard(output)
        outputBuffer.toString() shouldBe " 0123\n0    \r\n1 X  \r\n2  0 \r\n3  0 \r\n"
        boardSize = 3
    }
    "checkWin" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('X', ' ', ' '),
            arrayOf(' ', 'X', ' '),
            arrayOf(' ', ' ', 'X')
        )
        board.checkWin() shouldBe 'X'
    }
    "checkWin2" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', ' ', ' '),
            arrayOf('0', ' ', ' '),
            arrayOf('0', ' ', ' ')
        )
        board.checkWin() shouldBe '0'
    }
    "isFill" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', ' ', '0'),
            arrayOf('0', '0', '0')
        )
        board.isFill() shouldBe false
    }
    "isFill2" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', '0', '0'),
            arrayOf('0', '0', '0')
        )
        board.isFill() shouldBe true
    }
    "pointFromString" {
        "2 3".pointFromString() shouldBe Pair(2, 3)
    }
    "pointFromString2" {
        "dfgdfgfg".pointFromString() shouldBe null
    }
    "isRightMove" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', ' ', '0'),
            arrayOf('0', '0', '0')
        )
        board.isRightMove(Pair(1, 1)) shouldBe true
    }
    "isRightMove1" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', ' ', '0'),
            arrayOf('0', '0', '0')
        )
        board.isRightMove(Pair(2, 2)) shouldBe false
    }
    "isRightMove2" {
        outputBuffer.reset()
        val board = arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', ' ', '0'),
            arrayOf('0', '0', '0')
        )
        board.isRightMove(Pair(20, 2)) shouldBe false
    }
    "game" {
        outputBuffer.reset()
        val input = "1 1\n1 2\n0 1\n0 2\n2 1"
        game(ByteArrayInputStream(input.toByteArray()), output, test = true)
        outputBuffer.toString() shouldBe "X"
    }
    "game1" {
        outputBuffer.reset()
        val input = "1 1\n0 0\n1 0\n1 2\n2 1\n0 1\n0 2\n2 0\n2 2"
        game(ByteArrayInputStream(input.toByteArray()), output, test = true)
        outputBuffer.toString() shouldBe "ничья"
    }
    "game2" {
        val input = "10 1\nпрапр"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()), output, test = true)
        outputBuffer.toString() shouldBe "координаты введены неверно\r\n"
    }
    "game3" {
        val input = "1 1\n1 1\nпрапр"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()), output, test = true)
        outputBuffer.toString() shouldBe "координаты введены неверно\r\n"
    }
    "area" {
        area(1.0) shouldBe (3.1415926 plusOrMinus 0.001)
    }
})
