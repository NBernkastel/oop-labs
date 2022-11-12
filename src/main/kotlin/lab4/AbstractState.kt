package lab4

abstract class AbstractState(val board: lab3.Board){
    abstract val gameResult: String?
    abstract fun copy(): AbstractState
    open fun checkStep(step: Step): Boolean
}
