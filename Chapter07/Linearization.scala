package chapter7


abstract class Language {
  def sayHello: String
}

trait British extends Language {
  override def sayHello: String = "Hello"
}

trait Spanish extends Language {
  override def sayHello: String = "Hola"
}

class Socializer extends British with Spanish {
  override def sayHello: String = super.sayHello
}

object Linearization extends App {

  class Person(val name: String)

  val albert = new Person("Alberto")
  val socializer = new Socializer()

  println(s"${socializer.sayHello} ${albert.name}")

}
