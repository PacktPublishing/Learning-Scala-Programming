package chapter1

object One extends App {

  val str = "Scala is a multi-paradigm language. Scala is scalable too."
  val word = "Scala"

  printOccurrence(str, word)

  def printOccurrence(str: String, word: String) = println ("Word " + word + " occurred "
    + str.split(" ").filter(_ == word).size + " times.")

}
