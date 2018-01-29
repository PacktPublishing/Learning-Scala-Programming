package chapter3

object ForYieldExpressions extends App {

  val person1 = Person("Albert", 21, 'm')
  val person2 = Person("Bob", 25, 'm')
  val person3 = Person("Cyril", 19, 'f')

  val persons = List(person1, person2, person3)

  val winners = for {
    person <- persons
    age = person.age
    name = person.name
    if age > 20
  } yield name

  winners.foreach(println)

  case class Person(name: String, age: Int, gender: Char)
}


