package lab3

class Game(state: State = State()) {
    val states = ArrayList<State>()
    var indexState = 0
    val state: State
        get() {
            return states.last()
        }
    var gameOver = false

    init {
        states.add(state)
    }

    fun step(point: Point): Boolean {
        return if (state.step(point) != null) {
            states.add(state.step(point)!!)
            true
        }
        else {
            false
        }
    }

    fun takeBack(shift: Int): Boolean {
        return if (indexState-shift >=0){
            states[indexState - shift] = state
            indexState -= shift
            true
        } else false
    }
    override fun toString(): String{
       return if(gameOver) state.gameResult!! else {"Состояние $state Номер хода $indexState"}
    }
}