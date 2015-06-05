import reflect.runtime.universe._

import reflect.runtime.currentMirror
import tools.reflect.ToolBox
val toolbox = currentMirror.mkToolBox()


val C = q"case class C(s: String)"
showCode(C)
showRaw(C)


val q = q"List[String]"
val tq = tq"List[String]"
showRaw(q)
showRaw(tq)
q equalsStructure tq


Seq(tq"Int", tq"String") map { param =>
  q"case class C(s: $param)"
} foreach { q =>
  println(showCode(q))
}



val list = Seq(1,2,3,4)
val fmt = "%d, %d, %d, %d"
val printq = q"println($fmt, ..$list)"



val q"${i: Int} + ${d: Double}" = q"1 + 3.14"
