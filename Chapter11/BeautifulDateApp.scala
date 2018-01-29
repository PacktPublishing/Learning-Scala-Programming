package chapter11

import java.time.LocalDate
import LocalDateOps._

object BeautifulDateApp extends App {

  val today = LocalDate.now()
  val tomorrow = today + Day(1)
  val yesterday = today - Day(1)

  println(today)
  println(tomorrow)
  println(today + Year(1))

  val dateRange = today till tomorrow + Day(20)
  println(dateRange)
}