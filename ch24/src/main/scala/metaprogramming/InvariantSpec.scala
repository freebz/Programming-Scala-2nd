package metaprogramming

import reflect.runtime.universe._
import org.scalatest.FunSpec

class InvariantSpec extends FunSpec {
  case class Variable(var i: Int, var s: String)

  describe ("invariant.apply") {
    def succeed() = {
      val v = Variable(0, "Hello!")
      val i1 = invariant(v.s == "Hello!") {
        v.i += 1
        v.i += 1
        v.i
      }
      assert (i1 === 2)
    }

    it ("should not fail if the invariant holds") { succeed() }

    it ("should return the value returned by the expressions") { succeed() }

    it ("should fail if the invariant is broken") {
      intercept[invariant.InvariantFailure] {
        val v = Variable(0, "Hello!")
        invariant(v.s == "Hello!") {
          v.i += 1
          vs = "Goodbye!"
          v.i += 1
        }
      }
    }
  }
}
