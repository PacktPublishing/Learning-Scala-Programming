package chapter10

object TypeErasure extends App {

  val strings: List[String] = List("First", "Second", "Third")
  val noStringsAttached: List[Int] = List(1, 2, 3)

  def listOf[A](value: List[A]) = value match {
    case listOfString: List[String] => println("Strings Attached!")
    case listOfNumbers: List[Int] => println("No Strings Attached!")
  }

  listOf(strings)
  listOf(noStringsAttached)

  abstract class Animal()
  class Cat(name: String) extends Animal()               // Inheritance relationship between Cat and Animal


  def doSomethingForAnimals(animals: List[Animal]) = ??? //definitely do something for animals.

  val cats = List(new Cat("Mischief"), new Cat("Birdie"))
  doSomethingForAnimals(cats)
}
