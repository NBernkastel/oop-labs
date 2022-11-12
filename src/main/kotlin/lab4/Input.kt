package lab4

sealed interface Input{
    companion object{
        fun parse(string: String): Input{
            var sub =  string.split(' ')
            when {
                sub[0] == "-1"-> return TakeBack(sub[1].toInt())
                sub[0] == "-2" -> return Exit()
                sub[0].toInt() >= 0 -> return Step(sub[0].toInt(),sub[1].toInt(), listOf())
                sub.size > 2 -> return Step(sub[0].toInt(),sub[1].toInt(),listOf(sub[2],sub[3]))
                else -> return Exit()
            }
        }
    }
}