import scala.language.existentials

trait T[A] {
  val vT: A
  def mT = vT
}

class C(foo: Int) extends T[String] {
  val vT = "T"
  val vC = "C"
  def mC = vC

  class C2
}

val c = new C(3)
val clazz = classOf[C]
val clazz2 = c.getClass
val name = clazz.getName
val methods = clazz.getMethods
val fields = clazz.getFields
val annos = clazz.getAnnotations
val parentInterfaces = clazz.getInterfaces
val superClass = clazz.getSuperclass
val typeParams = clazz.getTypeParameters


c.isInstanceOf[String]
c.isInstanceOf[C]
c.asInstanceOf[T[AnyRef]]
