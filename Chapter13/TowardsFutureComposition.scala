package chapter13

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/*object TowardsFutureComposition extends App {

  val firstFuture = Future { "1" }
  firstFuture onComplete {
    case Success(value1) => Future { value1.toInt } onComplete {
      case Success(value2) => println(s"Converted int: $value2")
      case Failure(exception) => println(s"Conversion failed due to ${exception.getMessage} ")
    }
    case Failure(excep) => Future.failed(excep)
  }

  Thread.sleep(5000)
}*/

object FutureComposition extends App {

  def firstFuture: Future[String] = Future { "1" }
  def secondFuture(str: String): Future[Int] = Future { str.toInt }

  for {
    value1 <- firstFuture
    value2 <- secondFuture(value1)
  } yield println(s"Converted int: $value2")

  firstFuture flatMap( secondFuture(_) ) map(result => println(s"Converted int: $result"))

  /*firstFuture onComplete {
    case Success(value1) =>
      secondFuture(value1) onComplete {
      case Success(value2) => println(s"Converted int: $value2")
      case Failure(exception) => println(s"Conversion failed due to ${exception.getMessage} ")
    }
    case Failure(excep) => Future.failed(excep)
  }*/

  Thread.sleep(5000)
}
