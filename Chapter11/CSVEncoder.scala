package chapter11

trait CSVEncoder[T]{
  def encode(value: T): List[String]
}

object CSVEncoder {

  def toCSV[T](list: List[T])(implicit encoder: CSVEncoder[T]): String =
    list.map(mem => encoder.encode(mem).mkString(", ")).mkString(", ")

  implicit val personEncoder: CSVEncoder[Person] = new CSVEncoder[Person] {
    def encode(person: Person) = List(person.name)
  }

}

case class Person(name: String)

object EncoderApp extends App {
  import CSVEncoder._
  import CSVEncoderOps._

  println(CSVEncoder.toCSV(List(Person("Max Black"), Person("Caroline Channing"))))
  println(List(Person("Max Black"), Person("Caroline Channing")).toCSV)
}

object CSVEncoderOps {
  implicit class CSVEncoderExt[T](list: List[T]) {
    def toCSV(implicit encoder: CSVEncoder[T]) : String =
      list.map(mem => encoder.encode(mem).mkString(", ")).mkString(", ")
  }
}
