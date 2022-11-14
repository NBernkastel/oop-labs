package lab3

class Board(val cells: Array<Array<Char>>) {
    val isFill: Boolean
        get() {
            for (i in 0 until size)
                for (j in 0 until size)
                    if (cells[i][j] == ' ')
                        return false
            return true
        }

    companion object {
        var size = 3
        fun stringToArray(str: String): Array<Char> {
            return Array(size) { i -> str[i] }
        }
    }
    constructor(str: String) : this(
        Array(size) { i -> Board.stringToArray(str.substring(size * i)) })

    constructor(board: lab3.Board) : this(board.cells.copy())

    operator fun get(point: Point): Char {
        return cells[point.y][point.x]
    }

    operator fun get(point: Array<Int>): Char {
        return cells[point[1]][point[0]]
    }

    fun getOrNull(point: Point): Char? {
        return if (point.x < cells.size && point.y < cells.size) cells[point.y][point.x]
        else null
    }

    fun setAndCopy(point: Point, c: Char): lab3.Board {
        return Board(this.cells.apply { this[point.y][point.x] = c }.copy())
    }

    override fun toString(): String {
        var str = ""
        for (i in cells) {
            for (j in i) {
                str += "$j "
            }
            str += "\n"
        }
        return str
    }
}
fun Array<Array<Char>>.copy(): Array<Array<Char>> {
    return Array(size) { i -> Array(size) { j -> this[i][j] } }
}