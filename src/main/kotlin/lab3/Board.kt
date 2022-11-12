package lab3

import lab3.Board.Board.size

class Board(val cells: Array<Array<Char>>) {
    val isFill: Boolean
        get() {
            for (i in 0 until size)
                for (j in 0 until size)
                    if (cells[i][j] == ' ')
                        return false
            return true
        }

    object Board {
        var size = 3
        fun stringToArray(str: String): Array<Char> {
            return Array(size) { i -> str[i] }
        }
    }
    constructor(str: String) : this(
        Array(size) { i -> Board.stringToArray(str.substring(3 * i)) })

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

    fun copy(): Array<Array<Char>> {
        return Array(3) { i -> Array(3) { j -> cells[i][j] } }
    }
}
