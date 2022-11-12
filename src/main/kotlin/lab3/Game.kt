package lab3

class Game(state: State = State()) {
    private val states = ArrayList<State>()
    private var indexState = 0
    var gameOver = false

    init {
        if (indexState == 0)
            states.add(state)
    }

    private val state: State
        get() {
            return states[indexState]
        }

    fun step(point: Point): Boolean {
        state.turn = if (indexState % 2 == 0) 'X' else '0'
        if(indexState >= states.lastIndex)
            states.add(state.copyState())
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