class CSuper                { def msuper() = println("CSuper") }
class C      extends CSuper { def m()      = println("C") }
class CSub   extends C      { def msub()   = println("CSub") }

typeOf[C      => C     ] =:= typeOf[C => C]    // true
typeOf[CSuper => CSub  ] =:= typeOf[C => C]    // false
typeOf[CSub   => CSuper] =:= typeOf[C => C]    // false

typeOf[C      => C     ] <:< typeOf[C => C]    // true
typeOf[CSuper => CSub  ] <:< typeOf[C => C]    // true
typeOf[CSub   => CSuper] <:< typeOf[C => C]    // false



def toTypeRefInfo[T : TypeTag](x: T): (Type, Symbol, Seq[Type]) = {
  val TypeRef(pre, typName, parems) = toType(x)
  (pre, typName, parems)
}

toTypeRefInfo(1)
toTypeRefInfo(true)
toTypeRefInfo(Seq(1, true, 3.14))
toTypeRefInfo((i: Int) => i.toString)


val ts = toType(Seq(1, true, 3.14))
ts.typeSymbol
ts.erasure
ts.typeArgs
ts.baseClasses
ts.companion
ts.decls
ts.members
