package lab5

class StateList<T>( init: T, private val array: ArrayList<T> = ArrayList()) {
    val state:T
        get() {
            return array.last()
        }
    fun add(state: T){

    }
    fun move(to: Int): T{

    }
}