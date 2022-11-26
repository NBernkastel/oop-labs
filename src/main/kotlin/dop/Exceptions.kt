package dop

import lab3.Game

open class GameException(message: String): Exception(message)
class WrongCommandException(str:String) : GameException(str)
class NoCellException(str:String) : GameException(str)
class WrongStepException(str:String) : GameException(str)