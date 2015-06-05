import scala.reflect.runtime.universe._

def toType2[T](t: T)(implicit tag: TypeTag[T]): Type = tag.tpe
def toType[T : TypeTag](t: T): Type = typeOf[T]

toType(1)
toType(true)
toType(Seq(1, true, 3.14))
toType((i: Int) => i.toString)


toType(1) =:= typeOf[AnyVal]
toType(1) =:= toType(1)
toType(1) =:= toType(true)

toType(1) <:< typeOf[AnyVal]
toType(1) <:< toType(1)
toType(1) <:< toType(true)

typeOf[Seq[Int]] =:= typeOf[Seq[Any]]
typeOf[Seq[Int]] <:< typeOf[Seq[Any]]


typeTag[Int]
typeTag[Seq[Int]]
