package lab4

class MultiGame(state: AbstractState) {
    private val states = ArrayList<AbstractState>()
    private var indexState = 0
    var gameOver = false

    init {
        states.add(state)
    }

    private val state: AbstractState
        get() {
            return states[indexState]
        }

    fun step(step: Step): Boolean {
        if (indexState >= states.lastIndex)
            states.add(state.copyState())
        return if (state.step(step) != null) {
            indexState++
            state.step(step)
            if (indexState >= states.lastIndex) {
                states[indexState] = state
                state.toString()
                if (state.gameResult != null) {
                    gameOver = true
                }
            } else {
                states[indexState] = state
                state.toString()
                if (state.gameResult != null) {
                    gameOver = true
                }
            }
            true
        } else {
            false
        }
    }

    fun takeBack(shift: Int): Boolean {
        return if (indexState - shift >= 0) {
            indexState -= (shift)
            while (states.lastIndex != indexState) {
                states.removeAt(states.lastIndex)
            }
            true
        } else false
    }

    override fun toString(): String {
        return if (gameOver) state.gameResult!! else if (!test) {
            "Состояние\n${states[indexState]} Номер хода $indexState\n"
        } else {
            return ""
        }
    }
}