package lab5

import lab3.Game

open class GameException(message: String): Exception(message)
object WrongCommandException : GameException("не верная комманда")
object NoCellException : GameException("нет такой клетки")
class WrongStepException : GameException("неверный ход")