package chapter11

import java.time.{LocalDateTime}

object ImplicitParameter extends App {

  implicit val dateNow = LocalDateTime.now()

  def showDateTime(implicit date: LocalDateTime) = println(date)

  val ldt = implicitly[LocalDateTime]

  println(s"ldt value from implicit scope: $ldt")

  //Calling functions!
  //showDateTime
}
