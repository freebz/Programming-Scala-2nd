import progscala2.basicoop.Address
import progscala2.basicoop.Person3

val a1 = new Address("1 Scala Lane", "Anytown", "CA", "98765")
val a2 = new Address("98765")


Person3("Buck Trends1")
Person3("Buck Trends2", Some(20), Some(a1))
Person3("Buck Trends3", Some(20))
Person3("Buck Trends4", address = Some(a2))

