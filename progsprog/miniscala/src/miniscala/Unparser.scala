package miniscala

import miniscala.Ast.*

/** Unparser for MiniScala.
 */
object Unparser {
  // this unparse function can be used for all kinds of AstNode objects, including Exp objects (see Ast.scala)
  def unparse(n: AstNode): String = {
    n match {
      case exp: Exp => exp match {
        case IntLit(n) => n.toString
        case UnOpExp(op, exp) => "(" + unparse(op) + unparse(exp) + ")"
        case BinOpExp(l_exp, op, r_exp) => "(" + unparse(l_exp) + unparse(op) + unparse(r_exp) + ")"
      }
      case op: (BinOp | UnOp) => op match { // operations only share AstNode class
        case PlusBinOp() => "+"
        case MinusBinOp() | NegUnOp() => "-"
        case MultBinOp() => "*"
        case DivBinOp() => "/"
        case ModuloBinOp() => "%"
        case MaxBinOp() => "max"
      }
    }
  }
}