package lab4

sealed interface Input{
    companion object{
        fun parse(string: String): Input{
            val sub = string.split(' ')
            return when {
                sub.size > 2 -> Step(sub[0].toInt(),sub[1].toInt(),listOf(sub[2],sub[3]))
                sub[0] == "-1"-> TakeBack(sub[1].toInt())
                sub[0] == "-2" -> Exit()
                sub[0].toInt() >= 0 -> Step(sub[0].toInt(),sub[1].toInt(), listOf())
                else -> Exit()
            }
        }
    }
}