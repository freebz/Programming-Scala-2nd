package metaprogramming
import reflect.runtime.universe._
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

/**
  * A Macro written using the current macro syntax along with quasiquotes.
  * Requires a predicate for an invariant to be true before each expression
  * is evaluated.
  */
object invariant {
  case class InvariantFailure(msg: String) extends RuntimeException(msg)

  def apply[T](predecate: => Boolean)(block: => T): T = macro impl

  def impl(c: Context)(predicate: c.Tree)(block: c.Tree) ={
    import c.universe._
    val predStr = showCode(predicate)
    val q"..$stmts" = block
    val invariantStmts = stmts.flatMap { stmt =>
      val msg = s"FAILURE! $predStr == false, for statement: " + showCode(stmt)
      val tif = q"throw new metaprogramming.invariant.InvariantFailure($msg)"
      val predq2 = q"if (false == $predicate) $tif"
      List(q"{ val tmp = $stmt; $predq2; tmp };")
    }
    val tif = q"throw new metaprogramming.invariant.InvariantFailure($predStr)"
    val predq = q"if (false == $predicate) $tif"
    q"$predq; ..$invariantStmts"
  }
}
