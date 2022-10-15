package lab3

class State(
    val board: Board = Board(Array(3){Array(3){' '} }),
    val turn: Char = 'X',
){
    val gameResult: String? = if(checkWin()!=' ') "Победил ${checkWin()}"  else null
    fun copy(): State{
        return this
    }
    fun step(point: Point): State?{
        return if (point.x in board.cells.indices && point.y in board.cells.indices && board[point] == ' '){
            State(board.setAndCopy(point,turn))
        } else null
    }
    override fun toString(): String{
        return gameResult ?: (board.cells.toString() + "Ход $turn")
    }
    fun checkWin(): Char {
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
            if ((board.cells[i[0][0]][i[0][1]] == board.cells[i[1][0]][i[1][1]]) && (board.cells[i[1][0]][i[1][1]] == board.cells[i[2][0]][i[2][1]])
                && (board.cells[i[0][0]][i[0][1]] != ' ' && board.cells[i[1][0]][i[1]
                        [1]] != ' ' && board.cells[i[2][0]][i[2][1]] != ' ')
            ) {
                return board.cells[i[0][0]][i[0][1]]
            }
        }
        return ' '
    }
}