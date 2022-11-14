package lab4

import lab3.Board

class StateXO (board:lab3.Board,var turn:Char) : AbstractState(board){
    override var gameResult: String? = null

    override fun copyState(): AbstractState {
        return StateXO(Board(board),turn)
    }
    init {
        if(turn == 'X') turn = '0' else turn = 'X'
    }
    override fun nextState(step: Step): AbstractState {
        return StateXO(board.setAndCopy(step.point,turn),turn)
    }

    override fun toString(): String {
        gameResult = checkWin(board)
        return if (board.isFill) {
            gameResult = "Ничья!"
            ("Ничья!")
        } else {
            return (checkWin(board) ?: board.toString())
        }
    }
    fun checkWin(board: Board): String? {
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
                return ("Победил игрок: " + board.cells[i[0][0]][i[0][1]])
        }
        return null
    }
}