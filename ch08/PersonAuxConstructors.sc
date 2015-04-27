import progscala2.basicoop.{Address, Person}

val a1 = new Address("1 Scala Lane", "Anytown", "CA", "98765")
val a2 = new Address("98765")

new Person("Buck Trends1")
new Person("Buck Trends2", Some(20), Some(a1))
new Person("Buck Trends3", 20, a2)
new Person("Buck Trends4", 20)
