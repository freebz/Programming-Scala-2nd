val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

for {
  s <- states
} println(s)

states foreach println
