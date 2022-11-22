package lab5

import lab3.Board
import lab4.Step

class EStateXO (board:lab3.Board, private var turn:Char) : EAbstractState(board){
    override var gameResult: String? = null

    override fun copyState(): EAbstractState {
        return EStateXO(Board(board),turn)
    }
    init {
        turn = if(turn == 'X') '0' else 'X'
    }
    override fun nextState(step: Step): EAbstractState {
        return EStateXO(board.setAndCopy(step.point,turn),turn)
    }

    override fun toString(): String {
        gameResult = checkWin(board)
        return if (board.isFill) {
            gameResult = "Ничья!"
            ("Ничья!")
        } else if(!test) {
            return (checkWin(board) ?: board.toString())
        }
        else {
            return ""
        }

    }
    private fun checkWin(board: Board): String? {
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
            if ((board.cells[i[0][0]][i[0][1]] != ' ' && board.cells[i[1][0]][i[1][1]] != ' ' && board.cells[i[1][0]][i[1][1]] != ' ')
                && (board.cells[i[0][0]][i[0][1]] == board.cells[i[1][0]][i[1][1]]) && (board.cells[i[1][0]][i[1][1]] == board.cells[i[2][0]][i[2][1]])
            )
                return (if(!test) {"Победил игрок: " + board.cells[i[0][0]][i[0][1]]} else board.cells[i[0][0]][i[0][1]].toString())
        }
        return null
    }
}