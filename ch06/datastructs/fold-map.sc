(List(1, 2, 3, 4, 5, 6) foldRight List.empty[String]) {
  (x, list) => ("[" + x + "]") :: list
}

val list = List(1, 2, 3, 4, 5)
(list scan 10) (_ + _)

(List(1, 2, 3, 4, 5) fold 10) (_ * _)
(List(1, 2, 3, 4, 5) foldLeft 10) (_ * _)
(List(1, 2, 3, 4, 5) foldRight 10) (_ * _)

List(1, 2, 3, 4, 5) reduce (_ + _)
List(1, 2, 3, 4, 5) reduceLeft (_ + _)
List(1, 2, 3, 4, 5) reduceRight (_ + _)
