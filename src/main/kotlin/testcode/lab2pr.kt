package testcode

class jojo : Cloneable {
    public override fun clone(): Any {
        return super.clone()
    }
    var arr: Array<Int> = arrayOf(1, 2, 3, 45, 641)
    var hgh = "fdg"
}
var arr1: Array<Int> = arrayOf(1,1,5454)
var arr2: Array<Array<Int>> = arrayOf(arrayOf(1),arrayOf(10),arrayOf(15),arrayOf(15))
fun main(){
    var jj = arr2.clone()
    jj[0][0] = 2222
    var jk = arr1.clone()
    jk[0]= 666
    // В первом примере массив является ссылкой на ссылки в хип, во второй ссылкой на элементы в хип
}