def hello(name: String) = s"""Welcome!
  Hello, $name!
  * (Gratutitous Star!!)
  |We're glad you're here.
  |  Have some extra whitespace.""".stripMargin

hello("Programming Scala")
