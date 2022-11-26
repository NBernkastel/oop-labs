package dop

class StateList<T>( init: T, val array: ArrayList<T> = ArrayList()) {
    val state:T
        get() {
            return array.last()
        }
    fun add(state: T){
        array.add(state)
    }
    fun move(to: Int): T{
        try {
            return array[to]
        }
        catch (e:GameException){
            throw WrongCommandException("отсутсвует состояние")
        }
    }
}