import scala.language.higherKinds
import progscala2.typesystem.typelambdas.Functor._

List(1,2,3) map2 (_ * 2)
Option(2) map2 (_ * 2)
val m = Map("one" -> 1, "tow" -> 2, "three" -> 3)
m map2 (_ * 2)
