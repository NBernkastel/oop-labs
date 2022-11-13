package lab4

import lab3.Board

class StateBalda(
    board: lab3.Board,
    val turn: Int = 1,
    val words1: ArrayList<String> = ArrayList(),
    val words2: ArrayList<String> = ArrayList(),
) : AbstractState(board){
    override val gameResult: String?
        get() = TODO("Not yet implemented")
    init{
        Board.Board.size = 5
    }

    override fun checkStep(step: Step): Boolean {
        if (step.param.size == 2){
            super.checkStep(step)
            return true
        }
        else
            return false
    }

    override fun nextState(step: Step): AbstractState {
        if(turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return StateBalda(
            board = board.setAndCopy(step.point,step.param[0][0]),
            turn = if(turn == 1) 2 else 1,
            words1 = words1,
            words2 = words2)
    }

    override fun copy(): AbstractState {
        return StateBalda(board,turn,words1,words2)
    }

    override fun toString(): String {
        return if (board.isFill) {
            ("Ничья!")
        } else {
            return (gameResult + board.toString())
        }
    }
}
