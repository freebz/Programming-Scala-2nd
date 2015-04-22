def cat1(s1: String)(s2: String) = s1 + s2

val hello = cat1("Hello ") _
hello("World!")

cat1("Hello ")("World!")
cat1("Hello ")


val inverse: PartialFunction[Double,Double] = {
  case d if d != 0.0 => 1.0 / d
}

inverse(1.0)
inverse(2.0)
inverse(0.0)


def cat2(s1: String) = (s2: String) => s1 + s2

val cat2hello = cat2("Hello ")	// No _
cat2hello("World!")
cat1("foo")("bar")
cat2("foo")("bar")


def cat3(s1: String, s2: String) = s1 + s2
cat3("hello", "world")

val cat3Curried = (cat3 _).curried
cat3Curried("hello")("world")

val cat3Uncurried = Function.uncurried(cat3Curried)
cat3Uncurried("hello", "world")
