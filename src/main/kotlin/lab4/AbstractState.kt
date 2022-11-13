package lab4

import lab3.Board

abstract class AbstractState(val board: lab3.Board){
    abstract val gameResult: String?
    abstract fun copy(): AbstractState
    open fun checkStep(step: Step): Boolean {
        return when {
            step.y > Board.Board.size || step.x > Board.Board.size -> return false
            board[step.point] != ' ' -> return false
            gameResult != null -> return false
            else -> true
        }
    }
    abstract fun nextState(step: Step): AbstractState
    fun step(step: Step): AbstractState?{
        return if (checkStep(step))
            nextState(step)
        else null
    }
}
