package dop

import arrow.core.Either
import arrow.core.left
import lab3.Board

abstract class EAbstractState(val board: Board) {
    abstract val gameResult: String?
    abstract fun copyState(): EAbstractState
    open fun checkStep(step: Step): Either<String, Nothing>
        = when {
            (step.y >= Board.size || step.x >= Board.size) || (step.y < 0 || step.x < 0) -> Either.Left("клетка за пределами поля")
            board[step.point] != ' ' -> Either.Left("клетка занята")
            else -> Either.Left("")
    }

    abstract fun nextState(step: Step): EAbstractState
    fun step(step: Step): String? {
        if (checkStep(step) is Either.Left)
            return "${checkStep(step)}"
        else {
            nextState(step)
            return null
        }
    }
}
