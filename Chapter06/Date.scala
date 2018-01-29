package chapter6

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Date(val dateStr: String) {
  override def toString: String = s"Date(${this.dateStr})"
}

object Date{
  def apply(str: String): Date = {
    val dater = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    new Date(s"${dater.getDayOfWeek} ${dater.getDayOfMonth}-${dater.getMonth}-${dater.getYear}")
  }
}

object DateApp extends App {
  val date = Date("01/01/1992")
  println(date.dateStr)
}

