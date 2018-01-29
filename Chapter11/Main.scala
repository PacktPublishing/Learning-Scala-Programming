package chapter11

import java.lang.Exception
import scala.util.{Failure, Success, Try}

object Main extends App {

  /*def toInt(str: String): Int =
    try{
      str.toInt
    } catch {
      case exp: Exception =>
        println("Something unexpected happened, you may want to check the string you passed for conversion.")
        println("WARN: Overriding the usual behavior, returning Zero!")
        0
    }*/

  /*def toInt(str: String): Option[Int] = Try(str.toInt) match {
    case Success(value) => Some(value)
    case Failure(exp) => None
  }*/


  def toInt(str: String): Either[String, Int] = Try(str.toInt) match {
    case Success(value) => Right(value)
    case Failure(exp) => Left(s"${exp.toString} occurred," +
      s" You may want to check the string you passed.")
  }

  println(toInt("121"))
  println(toInt("-199"))
  println(toInt("+ -199"))

}
