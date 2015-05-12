import scala.language.implicitConversions

object Serialization {
  case class Rem[A](value: A) {
    def serialized: String = s"-- $value --"
  }
  type Writable[A] = A => Rem[A]
  implicit val formInt: Writable[Int]       = (i: Int)    => Rem(i)
  implicit val fromFloat: Writable[Float]   = (f: Float)  => Rem(f)
  implicit val fromString: Writable[String] = (s: String) => Rem(s)
}

import Serialization._

object RemoteConnection {
  def write[T : Writable](t: T): Unit =
    println(t.serialized)  // Use stdout as the "remote connection"
}

RemoteConnection.write(100)
RemoteConnection.write(3.14f)
RemoteConnection.write("hello!")
RemoteConnection.write((1, 2))
