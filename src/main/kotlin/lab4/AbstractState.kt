package lab4

import lab3.Board

abstract class AbstractState(val board: lab3.Board){
    abstract val gameResult: String?
    abstract fun copy(): AbstractState
    open fun checkStep(step: Step): Boolean{
        when {
            step.y > Board.Board.size || step.x > Board.Board.size  -> return false
            step.point
        }
    }
}
