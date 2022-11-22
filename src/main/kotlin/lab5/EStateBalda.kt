package lab5

import lab3.Board
import lab4.Step

class EStateBalda(
    board:Board,
    private val turn: Int = 1,
    private val words1: ArrayList<String> = ArrayList(),
    private val words2: ArrayList<String> = ArrayList(),
) : EAbstractState(board){
    override val gameResult: String? = null
    constructor(str:String) : this(board = Board("          $str          ")){
        Board.size = 5
    }

    override fun checkStep(step: Step) {
        if (step.param.size == 2){
            super.checkStep(step)
        } else
            WrongCommandException
    }

    override fun nextState(step: Step): EAbstractState {
        if(turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return EStateBalda(
            board = board.setAndCopy(step.point,step.param[0][0]),
            turn = if(turn == 1) 2 else 1,
            words1 = words1,
            words2 = words2
        )
    }

    override fun copyState(): EAbstractState {
        return EStateBalda(Board(board),turn,words1,words2)
    }

    override fun toString(): String {
        return (board.toString())
    }
}
