package lab3

class Board(val cells: Array<Array<Char>>) {
    val isFill: Boolean
        get() {
            for (i in cells) {
                for (j in i) {
                    if (j == ' ')
                        return false
                }
            }
            return true
        }

    constructor(string: String) : this(Array(
        Board.size
    )
    { i -> Board.stringToArray(string.substring(0 + i * 3 until 3 + i * 3)) }) {
    }

    constructor(board: lab3.Board) : this(board.cells.copy()) {
    }

    fun getOrNull(point: Point): Char? {
        return if (point.x < cells.size && point.y < cells.size) cells[point.x][point.y]
        else
            null
    }

    fun setAndCopy(point: Point, c: Char): lab3.Board {
        return Board(this.cells.apply { this[point.x][point.y] = c })
    }

    operator fun get(point: Point): Char {
        return cells[point.x][point.y]
    }

    operator fun get(point: Array<Int>): Char {
        return cells[point[0]][point[1]]
    }
    override fun toString(): String{
        var s = ""
        for(cell in cells) {
          s +="$cell/n"
        }
        return s
    }
    object Board {
        var size = 3
        fun stringToArray(string: String): Array<Char> {
            return stringToArray(string)
        }
    }
}
fun Array<Array<Char>>.copy(): Array<Array<Char>> {
    return Array(3) { i -> Array(3) { j -> this[i][j] } }
}