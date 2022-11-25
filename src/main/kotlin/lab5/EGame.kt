package lab5

class EGame(state: EAbstractState) {
    private val states = StateList(state)
    private var indexState = 0
    var gameOver = false

    init {
        states.add(state)
    }

    fun step(step: Step) {
        states.add(states.state.copyState())
        states.state.step(step)
        indexState++
        }

    fun takeBack(shift: Int) {
        indexState -= shift
        while (states.array.lastIndex != indexState) {
            states.array.removeAt(states.array.lastIndex)
            }
    }

    override fun toString(): String {
        return if (gameOver) states.state.gameResult!! else if (!test) {
            "Состояние\n${states.state} Номер хода $indexState\n"
        } else {
            return ""
        }
    }
}