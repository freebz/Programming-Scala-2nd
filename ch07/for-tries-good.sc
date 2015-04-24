import scala.util.{ Try, Success, Failure }

def positive(i: Int): Try[Int] = Try {
  assert (i > 0, s"nonpositive number $i")
  i
}

for {
  i1 <- positive(5)
  i2 <- positive(10 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(2  * i3)
} yield (i1 + i2 + i3 + i4)

for {
  i1 <- positive(5)
  i2 <- positive(-1 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(-2 * i3)
} yield (i1 + i2 + i3 + i4)


def positive(i: Int): Try[Int] =
  if (i > 0) { Success(i)
  } else Failure(new AssertionError("assertion failed"))

for {
  i1 <- positive(5)
  i2 <- positive(10 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(2  * i3)
} yield (i1 + i2 + i3 + i4)

for {
  i1 <- positive(5)
  i2 <- positive(-1 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(-2 * i3)
} yield (i1 + i2 + i3 + i4)

