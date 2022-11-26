package dop

enum class Turn(private val char: Char) {
    X('X'),
    O('0');
    fun next(char: Char) : Turn{
        return if (char == 'X') O else X
    }
    override fun toString() : String {
        return char.toString()
    }
}