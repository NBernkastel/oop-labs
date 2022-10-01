package testcode
var str = "123456789"
val cells: Array<Array<Char>> = Array(3){i -> stringToArray(str.substring(0..3))}
fun main(){
    println(cells)
}
fun stringToArray(string: String): Array<Char> {
    return Array(3){i -> string[i]}
}