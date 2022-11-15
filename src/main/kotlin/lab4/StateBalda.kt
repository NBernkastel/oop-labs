package lab4

import lab3.Board

class StateBalda(
    board:Board,
    private val turn: Int = 1,
    private val words1: ArrayList<String> = ArrayList(),
    private val words2: ArrayList<String> = ArrayList(),
) : AbstractState(board){
    override val gameResult: String? = null
    constructor(str:String) : this(board = Board("          $str          ")){
        Board.size = 5
    }

    override fun checkStep(step: Step): Boolean {
        return if (step.param.size == 2){
            super.checkStep(step)
            true
        } else
            false
    }

    override fun nextState(step: Step): AbstractState {
        if(turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return StateBalda(
            board = board.setAndCopy(step.point,step.param[0][0]),
            turn = if(turn == 1) 2 else 1,
            words1 = words1,
            words2 = words2
        )
    }

    override fun copyState(): AbstractState {
        return StateBalda(Board(board),turn,words1,words2)
    }

    override fun toString(): String {
        return if (board.isFill) {
            ("Ничья!")
        } else {
            return (board.toString())
        }
    }
}
