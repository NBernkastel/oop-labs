package lab5

class Step (val x: Int, val y: Int, val param: List<String>) : Input{
    var point: lab3.Point = lab3.Point(x = x, y = y)
}
