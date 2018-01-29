package chapter7

sealed trait Season

case object Autumn extends Season
case object Winter extends Season
case object Spring extends Season
case object Summer extends Season
case object Monsoon extends Season

object sealedApp extends App {
  def season(season: Season) = season match {
    case Autumn => println(s"It's Autumn :)")
    case Winter => println(s"It's Winter, Xmas time!")
    case Spring => println(s"It's Spring!!")
    case Summer => println(s"It's summer, who likes summer anyway!")
    case Monsoon => println(s"It's Monsoon!!")
  }

  season(Spring)
}