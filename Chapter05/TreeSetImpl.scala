package chapter5

import scala.collection.immutable.TreeSet

object TreeSetImpl extends App {

  implicit val ordering = Ordering.fromLessThan[Int](_ > _)

  val treeSet = new TreeSet() + (1, 3, 12, 3, 5)

  val setOfMethods = Set("GET", "PUT", "POST", "DELETE")
  println(treeSet)
}
