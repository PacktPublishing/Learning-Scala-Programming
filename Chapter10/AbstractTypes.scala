package chapter10

object AbstractTypes extends App {

  trait ColumnParameterized[T] {
       def column() : T
  }

  trait ColumnAbstract {
    type T

    def column(): T
  }

  val aColumnFromParameterized = new ColumnParameterized[String] {
    override val column = "CITY"
  }

  val aColumnFromAbstract = new ColumnAbstract {
    type T = String

    override val column = "HOUSE NO"
  }

  println(s"Coloumn from Parameterized: ${aColumnFromParameterized.column}   |  and Column from Abstract: ${aColumnFromAbstract.column} ")




}