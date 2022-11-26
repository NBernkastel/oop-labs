package lab5
import lab3.Board

abstract class EAbstractState(val board:Board){
    abstract val gameResult: String?
    abstract fun copyState(): EAbstractState
    open fun checkStep(step: Step){
        when {
            (step.y >= Board.size || step.x >= Board.size) ||  (step.y < 0 || step.x <0) -> throw NoCellException("клетка за пределами поля")
            board[step.point] != ' ' -> throw WrongStepException("клетка занята")
        }
    }
    abstract fun nextState(step: Step): EAbstractState
    fun step(step: Step): EAbstractState{
        checkStep(step)
        return nextState(step)
    }
}
