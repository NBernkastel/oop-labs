

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lab3.Board
import lab3.Point
import lab3.State
import lab3.copy
import lab4.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

var outputBuffer = ByteArrayOutputStream()
var output = PrintStream(outputBuffer,true, "UTF-8")
class test4 : StringSpec({
    "XO #1"{
        val input = "0 0\n0 1\n1 1\n0 2\n2 2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output,StateXO(Board("         "),'X'))
        outputBuffer.toString().last().toString() shouldBe "X"
    }
    "X0 #2"{
        val input = "1 1\n0 0\n0 1\n2 1\n1 2\n1 0\n2 0\n0 2\n2 2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe "Ничья!"
    }
    "X0 #3"{
        val input = "-2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe ""
    }
    "X0 #4"{
        test = false
        val input = "0 0"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe ""
    }
})