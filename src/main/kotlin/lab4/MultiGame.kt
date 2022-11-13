package lab4

class MultiGame(state: AbstractState) {
    private val states = ArrayList<AbstractState>()
    private var indexState = 0
    var gameOver = false

    init {
        if (indexState == 0)
            states.add(state)
    }

    private val state: AbstractState
        get() {
            return states[indexState]
        }

    fun step(point: lab3.Point): Boolean {
        if(indexState >= states.lastIndex)
            states.add(state.copy())
        indexState++
        return if (state.step(point) != null) {
            if (indexState >= states.lastIndex)
                states[indexState]=state.step(point)!!
            else
                states[indexState] = state.step(point)!!
            true
        } else {
            false
        }
    }
    
    fun takeBack(shift: Int): Boolean {
        return if (indexState - shift >= 0) {
            indexState -= (shift)
            while (states.lastIndex!=indexState)
            {
                states.removeAt(states.lastIndex)
            }
            true
        } else false
    }

    override fun toString(): String {
        return if (gameOver) state.gameResult!! else {
            "Состояние\n${states[indexState]} Номер хода $indexState\n"
        }
    }
}