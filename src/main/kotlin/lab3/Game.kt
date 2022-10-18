package lab3

class Game(state: State = State()) {
    val states = ArrayList<State>()
    var indexState = 0
    val state: State
        get() {
            return states[indexState]
        }
    var gameOver = false

    init {
        states.add(state.copy())
    }

    fun step(point: Point): Boolean {
        return if (state.step(point) != null) {
            if (indexState >= states.lastIndex)
                states.add(state.step(point)!!)
            else
                states[indexState] = state.step(point)!!
            indexState++
            true
        }
        else {
            false
        }
    }

    fun takeBack(shift: Int): Boolean {
        return if (indexState-shift >=0){
            states[indexState] = state.copy()
            indexState -= shift
            true
        } else false
    }
    override fun toString(): String{
       return if(gameOver) state.gameResult!! else {"Состояние\n$state Номер хода $indexState\n"}
    }
}
// Не работает ход назад проверь как работает текущее состояние state debugom