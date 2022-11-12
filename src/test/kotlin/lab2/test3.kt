

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lab3.Board
import lab3.Point
import lab3.State

class test3 : StringSpec({
    "Class Board: isFill 1-st test" {
        val board = Board(Array(3) { Array(3) { ' ' } })
        board.isFill shouldBe false
    }

    "Class Board: isFill 2-nd test" {
        val board = Board(Array(3) { Array(3) { 'X' } })
        board.isFill shouldBe true
    }

    "class Board: constructor #1 test" {
        var board = Board(Array(3) { Array(3) { ' ' } })
        board = Board("123456789")
        board.cells shouldBe arrayOf(
            arrayOf('1', '2', '3'),
            arrayOf('4', '5', '6'),
            arrayOf('7', '8', '9')
        )
    }

    "class Board: constructor #2 test" {
        var testBoard = arrayOf(
            arrayOf('3', '2', '3'),
            arrayOf('r', '7', 'm'),
            arrayOf('g', '0', '9')
        )
        var board = Board(testBoard)
        board.cells shouldBe arrayOf(
            arrayOf('3', '2', '3'),
            arrayOf('r', '7', 'm'),
            arrayOf('g', '0', '9')
        )
    }

    "class Board: getOrNull test" {
        val board = Board(Array(3) { Array(3) { ' ' } })
        board.getOrNull(Point(1, 2)) shouldBe ' '
    }

    "class Board: get(Point) test" {
        val board = Board("153gorg34")
        board[Point(2, 1)] shouldBe 'r'
    }
    "class Board: get(Array) test" {
        val board = Board("325523ghj")
        board[arrayOf(1, 1)] shouldBe '2'
    }

    "class Board: stringToArray test" {
        Board.Board.stringToArray("123") shouldBe arrayOf('1', '2', '3')
    }

    "class Board: setAndCopy test" {
        val board = Board("X0 0XX   ")
        board.setAndCopy(Point(2, 2), 'X')
        board.cells shouldBe arrayOf(
            arrayOf('X', '0', ' '),
            arrayOf('0', 'X', 'X'),
            arrayOf(' ', ' ', 'X')
        )
    }

    "class Board: toString test" {
        val board = Board("12gbhdfdb")
        board.toString() shouldBe "1 2 g \nb h d \nf d b \n"
    }

    "class Board: copy test" {
        val board = Board("123456789")
        val brd = board.copy()
        brd shouldBe arrayOf(
            arrayOf('1', '2', '3'),
            arrayOf('4', '5', '6'),
            arrayOf('7', '8', '9')
        )
    }

    "class State: checkWin test" {
        val state = State()
        state.checkWin(Board("X00X0X00X")) shouldBe "Победил игрок: 0"
        state.checkWin(Board("XXX 0 0 0")) shouldBe "Победил игрок: X"
        state.checkWin(Board("123456789")) shouldBe null
    }

    "class State: step test" {
        val state = State(board = Board("X   X   0"), turn = 'X')
        state.step(Point(6, 0)) shouldBe null
    }

})