// covariant
case class Opt[+A](value: A = null) {
  def getOrElse(default: A) = if (value != null) value else default
}

// invariant
case class Opt[A](value: A = null) {
  def getOrElse(default: A) = if (value != null) value else default
}

val p4: Parent = Opt(new Child(1)).getOrElse(new Parent(10))
val p5: Parent = Opt[Parent](null).getOrElse(new Parent(10))
val p6: Parent = Opt[Child](null).getOrElse(new Parent(10))
