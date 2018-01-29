package chapter11

import scala.concurrent.Future

object FuturesApp extends App {

  implicit val ctx = scala.concurrent.ExecutionContext.Implicits.global

  val futureComp = Future {
     1 + 1
  }

  println(s"futureComp: $futureComp")

  futureComp.map(result => println(s"futureComp: $result"))
}