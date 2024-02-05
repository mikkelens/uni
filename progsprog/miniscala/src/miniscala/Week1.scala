package miniscala

import scala.Console.err

object Week1 {

  import miniscala.Ast.*
  import miniscala.parser.*

  def main(args: Array[String]): Unit = {
    val a1 = BinOpExp(IntLit(2), MinusBinOp(), IntLit(10))
    val a2 = Parser.parse("2-10")
    //    err.println("Invoking toString on the AST gives: " + a2)
    assert(a1 == a2, "Parsing works as intended")

    val b1 = BinOpExp(
      BinOpExp(IntLit(44), MinusBinOp(), IntLit(2)),
      MaxBinOp(),
      IntLit(87)
    )
    val b2 = Parser.parse("(44 - 2) max 87")
    //    err.println("Invoking toString on the AST gives: " + b2)
    assert(b1 == b2)
    val b2result = Interpreter.eval(b2);
    assert(b2result == 87)

    val c1 = BinOpExp(IntLit(6), MultBinOp(), BinOpExp(IntLit(2), MinusBinOp(), IntLit(10)))
    val c2u = "(6*(2-10))"
    val c2 = Parser.parse(c2u)
    assert(c1 == c2, s"$c1 != $c2")
    val c1u = Unparser.unparse(c1)
    assert(c1u == c2u, s"$c1u != $c2u")

    for (program <- Array("")) {
      assert(Parser.parse(Unparser.unparse(Parser.parse(program))) == Parser.parse(program), s"Unparsed $program incorrectly!")
    }

    println("Assertions completed successfully!")
  }

  /* Notes for Week1-9
My stdout (as it was):
BinOpExp: BinOpExp(IntLit(1),PlusBinOp(),IntLit(2)) MultBinOp() IntLit(3)
BinOpExp: IntLit(1) PlusBinOp() IntLit(2)
Literal '1'
Literal '2'
1 + 2 = 3
Literal '3'
3 * 3 = 9
Output: 9

It looks like this because I enable the trace flag ('option') and that means that the interpreter prints what it encounter during evaluation.
When evaluating with operations, the operation logs the expression as a calculation with `a + b = c` syntax for readability.
First 1+2 is evaluated, then the result is used to evaluate leftval * 3 = 9. (leftval is 3)
   */
}