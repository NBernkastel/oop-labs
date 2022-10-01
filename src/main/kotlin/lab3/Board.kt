package lab3

class Board(val cells: Array<Array<Char>>) {
    constructor(string:String,cells: Array<Array<Char>>) : this(Array(Board.size
    ) { i -> Board.stringToArray(string.substring(i + 3)) }) {
    }
    object Board {
        var size = 3
        fun stringToArray(string: String): Array<Char> {
            return stringToArray(string)
        }
    }
}