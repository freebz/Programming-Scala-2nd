import progscala2.typesystem.structuraltypes.SubjectFunc

val observer: Int => Unit = (state: Int) => println("get one! "+state)
val subject = new SubjectFunc {}
