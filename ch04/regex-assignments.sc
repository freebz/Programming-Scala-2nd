val cols = """\*|[\w, ]+"""

val table = """\w+"""

val tail = """.*"""

val selectRE =
  s"""SELECT\\s*(DISTINCT)?\\s+($cols)\\s*FROM\\s+($table)\\s*($tail)?;""".r

val selectRE(distinct1, cols1, table1, otherClauses) =
  "SELECT DISTINCT * FROM atable;"

val selectRE(distinct2, cols2, table2, otherClauses) =
  "SELECT col1, col2 FROM atable;"

val selectRE(distinct3, cols3, table3, otherClauses) =
  "SELECT DISTINCT col1, col2 FROM atable;"

val selectRE(distinct4, cols4, table4, otherClauses) =
  "SELECT DISTINCT col1, col2 FROM atable WHERE col1 = 'foo';"
