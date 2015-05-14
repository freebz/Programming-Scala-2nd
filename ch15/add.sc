import scala.language.higherKinds
import progscala2.typesystem.higherkinded.{Add, Reduce}
import progscala2.typesystem.higherkinded.Add._
import progscala2.typesystem.higherkinded.Reduce._

def sum[T : Add, M[T]](container: M[T])(
  implicit red: Reduce[T,M]): T =
  red.reduce(container)(implicitly[Add[T]].add(_,_))

sum(Vector(1 -> 10, 2 -> 20, 3 -> 30))
sum(1 to 10)
sum(Option(2))
sum[Int,Option](None)
