import progscala2.dynamic.CLINQ

def makeMap(name: String, capital: String, statehood: Int) =
  Map("name" -> name, "capital" -> capital, "statehood" -> statehood)

val states = CLINQ(
  List(
    makeMap("Alaska",     "Juneau",      1959),
    makeMap("California", "Sacramento",  1850),
    makeMap("Illinois",   "Springfield", 1818),
    makeMap("Virginia",   "Richmond",    1788),
    makeMap("Washington", "Olympia",     1889)))

states.name
states.capital
states.statehood
states.name_and_capital
states.capital_and_statehood
states.all
states.all.where("name").NE("Alaska")
states.all.where("statehood").EQ(1889)
states.name_and_statehood.where("statehood").NE(1850)
