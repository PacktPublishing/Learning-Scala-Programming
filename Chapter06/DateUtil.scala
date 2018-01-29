package chapter6

import java.time.LocalDate
import java.time.format.{DateTimeFormatter, TextStyle}
import java.util.Locale
import scala.util.{Failure, Success, Try}

object DateUtil {
  /*
  * Just pass a date with format DD/MM/YYYY, get back DAY_OF_WEEK
  * */
  def dayOfWeek(date: String): Option[String] = Try{
      LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getDayOfWeek
    } match {
      case Success(dayOfWeek) => Some(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH))
      case Failure(exp) => exp.printStackTrace; None
    }
}

object TestDateUtil extends App {
  import DateUtil._

  val date = "01/01/1992"

  dayOfWeek(date) match {
      case Some(dow) => println(s"It was $dow on $date")
      case None => println(s"Something went wrong!")
  }

}