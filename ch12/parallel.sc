((1 to 10) fold "") ((s1, s2) => s"$s1 - $s2")
((1 to 10) fold "") ((s1, s2) => s"$s1 - $s2")
((1 to 10).par fold "") ((s1, s2) => s"$s1 - $s2")
((1 to 10).par fold "") ((s1, s2) => s"$s1 - $s2")

((1 to 10) fold 0) ((s1, s2) => s1 + s2)
((1 to 10) fold 0) ((s1, s2) => s1 + s2)
((1 to 10).par fold 0) ((s1, s2) => s1 + s2)
((1 to 10).par fold 0) ((s1, s2) => s1 + s2)
