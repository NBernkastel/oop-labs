

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lab3.Board
import lab4.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

var outputBuffer = ByteArrayOutputStream()
var output = PrintStream(outputBuffer,true, "UTF-8")
class Test4 : StringSpec({
    "XO #1"{
        test = true
        Board.size = 3
        val input = "0 0\n0 1\n1 1\n0 2\n2 2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateXO(Board("         "),'X'))
        outputBuffer.toString().last() shouldBe 'X'
    }
    "X0 #2"{
        test = true
        Board.size = 3
        val input = "1 1\n0 0\n0 1\n2 1\n1 2\n1 0\n2 0\n0 2\n2 2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe "Ничья!"
    }
    "X0 #3"{
        test = true
        Board.size = 3
        val input = "-2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe ""
    }
    "X0 #4"{
        test = false
        Board.size = 3
        val input = "0 0\n-1 1\n-2"
        outputBuffer.reset()
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateXO(Board("         "),'X'))
        outputBuffer.toString() shouldBe "Состояние\n" +
                "X     \n" +
                "      \n" +
                "      \n" +
                " Номер хода 1\n" +
                "Состояние\n" +
                "      \n" +
                "      \n" +
                "      \n" +
                " Номер хода 0\n"
    }
    "balda #1"{
        outputBuffer.reset()
        Board.size = 5
        val input = "0 0 k kol\n-2\n"
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateBalda("games"))
        outputBuffer.toString() shouldBe "Состояние\n" +
                "k         \n" +
                "          \n" +
                "g a m e s \n" +
                "          \n" +
                "          \n" +
                " Номер хода 1\n"
    }
    "balda #2"{
        outputBuffer.reset()
        Board.size = 5
        val input = "0 0 k kol\n0 0 l kol\n-2\n"
        game(ByteArrayInputStream(input.toByteArray()),output= output,StateBalda("games"))
        outputBuffer.toString() shouldBe "Состояние\n" +
                "k         \n" +
                "          \n" +
                "g a m e s \n" +
                "          \n" +
                "          \n" +
                " Номер хода 1\n" +
                "неверный ход\n"
    }
})