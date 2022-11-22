package lab5
import lab3.Board
import lab4.Step

abstract class EAbstractState(val board:Board){
    abstract val gameResult: String?
    abstract fun copyState(): EAbstractState
    open fun checkStep(step: Step){
        when {
            (step.y > Board.size || step.x > Board.size) ||  (step.y < 0 || step.x <0) -> NoCellException
            board[step.point] != ' ' -> WrongStepException()
        }
    }
    abstract fun nextState(step: Step): EAbstractState
    fun step(step: Step): EAbstractState{
        return nextState(step)
    }
}
