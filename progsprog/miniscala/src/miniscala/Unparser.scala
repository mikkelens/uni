package miniscala

import miniscala.Ast.*

/** Unparser for MiniScala.
 */
object Unparser {
  // this unparse function can be used for all kinds of AstNode objects, including Exp objects (see Ast.scala)
  def unparse(n: AstNode): String = {
    n match {
      case IntLit(n) => n.toString
      case BinOpExp(l_exp, op, r_exp) => "(" + unparse(l_exp) + unparse(op) + unparse(r_exp) + ")"
      case UnOpExp(op, exp) => "(" + unparse(op) + unparse(exp) + ")"
      case PlusBinOp() => "+"
      case MinusBinOp() => "-"
      case MultBinOp() => "*"
      case DivBinOp() => "/"
      case ModuloBinOp() => "%"
      case MaxBinOp() => "max"
    }
    // Note: This is a flat pattern match, which is easier to identify for scala as exhaustive.
    // I am not sure why Scala does not complain about the pattern match in Interpreter.scala's `eval` function.
  }
}