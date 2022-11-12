package lab3

class State(
    var board: Board = Board("         "),
    var turn: Char = 'X'
) {
    var gameResult: String? = null

    fun copyState(): State
    {
        return State(Board(board),turn)
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

    fun step(point: Point): State? {
        return if (board.getOrNull(point) != null) {
            State(board.setAndCopy(point, if (turn == 'X') '0' else 'X'))
        } else null
    }

    override fun toString(): String {
        return if (board.isFill) {
            ("Ничья!")
        } else {
            return (checkWin(board) ?: board.toString())
        }
    }

}