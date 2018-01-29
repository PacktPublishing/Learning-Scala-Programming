package chapter9

import scala.annotation.tailrec

object TailRecursion {
  def main(args: Array[String]): Unit = {
      val list = List("Alex", "Bob", "Chris", "David", "Raven", "Stuart")
    someRecursiveMethod(list)
  }

  /*
      You have a sorted list of names of employees, within a company.
      print all names until the name "Raven" comes
  */
  @tailrec
  def someRecursiveMethod(list: List[String]): Unit = {
      list match {
        case Nil => println(s"Can't continue. Either printed all names or encountered Raven")
        case head :: tail => if(head != "Raven") {
          println(s"Name: $head")
          someRecursiveMethod(tail)
        } else someRecursiveMethod(Nil)
      }
  }
}