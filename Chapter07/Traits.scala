package chapter7

trait Socialize {

  def greet(name: String) = "Hello " + name

  val socialNetworks = Set("Facebook", "LinkedIn", "Twitter", "Instagram", "Youtube")

  def linkToSocialNetwork(network: String, uri: String)
}

case class Person(val name: String)

object SocializeApp extends App {
  val person = Person("Victor Mark")

  val employee = new Employee("David Barbara")
  employee.linkToSocialNetwork("LinkedIn", "www.linkedin.com/profiles/david_b")

  println(employee.mapOfSocialNetwork)

}

class Employee(fullName: String) extends Person(fullName) with Socialize {
  var mapOfSocialNetwork = new scala.collection.mutable.HashMap[String, String]()

  override val socialNetworks = Set("LinkedIn", "Twitter", "Youtube")
  override def linkToSocialNetwork(network: String, uri: String): Unit = if (socialNetworks contains network) mapOfSocialNetwork.put(network, uri)

}
  //println(person.greet(employee.name))

