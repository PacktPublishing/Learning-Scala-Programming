package chapter6

object CountryUtil extends App {

  case class Country(name: String, capital: String)
  val country = Country("France", "Paris")

  /*/*println(s"Country: => $country")
  println(s"Equality: => ${country == country}")
  println(s"HashCode: => ${country.hashCode()}")

  println(s"Unapply: => ${Country.unapply(country)}")
  println(s"apply: => ${Country.apply("Germany","Berlin")}")

  println(s"copy: => ${country.copy("Germany","Berlin")}")
  println(s"copyName: => ${country.copy(name="Germany")}")
  println(s"copyCapital: => ${country.copy(capital="Berlin")}")

  println(s"productArity: => ${country.productArity}")
  println(s"productPrefix: => ${country.productPrefix}")
  println(s"productElement(0): => ${country.productElement(0)}")
  println(s"productElement(1): => ${country.productElement(1)}")*/

  country match {
    case Country("Germany", _) => println(s"It's Germany")
    case Country("France", _) => println(s"It's France")
    case Country(_, _) => println(s"It's some country")
  }*/

}

abstract class Continent
case class Country(name: String, capital: String) extends Continent

