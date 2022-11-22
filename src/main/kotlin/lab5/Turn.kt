package lab5

enum class Turn(val char: Char) {
    X('X'),
    O('0');
    fun next(char: Char) : Turn{
        return if (char == 'X') X else O
    }
    override fun toString() : String {
        return char.toString()
    }
}