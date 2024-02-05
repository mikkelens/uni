package miniscala

import miniscala.Ast.*

/**
 * Interpreter for MiniScala.
 */
object Interpreter {

  def eval(e: Exp): Int = e match {
    case IntLit(c) => trace(s"Literal '$c'"); c
    case BinOpExp(leftexp, op, rightexp) =>
      trace(s"BinOpExp: $leftexp $op $rightexp")
      val leftval = eval(leftexp)
      val rightval = eval(rightexp)
      op match {
        case PlusBinOp() => tap_trace_eval(leftval + rightval, s"$leftval + $rightval")
        case MinusBinOp() => tap_trace_eval(leftval - rightval, s"$leftval - $rightval")
        case MultBinOp() => tap_trace_eval(leftval * rightval, s"$leftval * $rightval")
        case DivBinOp() =>
          if (rightval == 0)
            throw InterpreterError(s"Division by zero", op)
          tap_trace_eval(leftval / rightval, s"$leftval / $rightval")
        case ModuloBinOp() => leftval % rightval
        case MaxBinOp() =>
          tap_trace_eval(if (leftval >= rightval) leftval else rightval, s"$leftval max $rightval")
      }
    case UnOpExp(op, exp) =>
      val expval = eval(exp)
      op match {
        case NegUnOp() => tap_trace_eval(-expval, s"-$exp")
      }
  }

  /**
   * Prints message if option -trace is used.
   */
  def trace(msg: String): Unit =
    if (Options.trace)
      println(msg)

  /**
   * Trace (log if `trace` is enabled) the evaluation of something.
   *
   * @param result the result of evaluation
   * @param msg    what we are evaluating
   * @tparam T type of eval result
   * @return the result, unchanged
   */
  private def tap_trace_eval[T](result: T, msg: String): T = {
    trace(msg + s" = $result")
    result
  }

  /**
   * Exception thrown in case of MiniScala runtime errors.
   */
  private class InterpreterError(msg: String, node: AstNode) extends MiniScalaError(s"Runtime error: $msg", node.pos)
}