package chapter7

import java.util

import scala.collection.mutable.ArrayBuffer

/*class Book(val title: String) {
   val chapters = scala.collection.mutable.Set[Chapter]()

   def addChapter(chapter: Chapter) = chapters.add(chapter)

   def pages = chapters.foldLeft(0)((b, c) => b + c.noOfPages)
}*/

case class Chapter(name: String, sn: Int, noOfPages: Int)

class Book(val title: String){
  val coverType: String = "Paperback"
  def cover(cover: String): String = coverType + "_" + cover
}

class Dictionary(name: String) extends Book(name){
  override val coverType: String = "Hardcover"
}

class Encyclopaedia(name: String) extends Book(name){
  override val coverType: String = "Blue_Hardcover"
}

object BookApp extends App {
  val dictionary: Book = new Dictionary("Collins")
  val encyclopedia: Book = new Encyclopaedia("Britannica")
  val theBoringBook: Book = new Book("TheBoringBook")

  println(s"${dictionary.title} has cover ${dictionary.cover("The Collins Dictionary")}")
  println(s"${encyclopedia.title} has cover ${encyclopedia.cover("Britannica")}")
  println(s"${theBoringBook.title} has cover ${theBoringBook.cover("Some Book")}")
}

/*book.addChapter(Chapter("Chapter1", 1, 15))
  book.addChapter(Chapter("Chapter2", 2, 13))
  book.addChapter(Chapter("Chapter3", 3, 17))*/

class CustomStack extends util.ArrayList[String] {
  def push(value: String) = ???
  def pop = ???
}