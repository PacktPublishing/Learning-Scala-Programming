package chapter13

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureExample extends App {

  val fileSource =
    "/Users/vika/Documents/LSProg/LSPWorkspace/FirstProject/src/chapter13/football_stats.csv"

  val listOfPlayers: Future[List[Player]] = Future {
      val source = io.Source.fromFile(fileSource)
      val list = source.getLines().toList

      source.close()

      giveMePlayers(list)
  }

  def giveMePlayers(list: List[String]): List[Player] = list match {
    case head :: tail => tail map {line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7),
        columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

  // Uncomment for No callbacks
  /*println(s"listOfPlayers completed: ${listOfPlayers.isCompleted}")
  Thread.sleep(500)
  println(s"listOfPlayers completed: ${listOfPlayers.isCompleted}")*/

  // Registering a callback
  /*listOfPlayers foreach {
    case list => list foreach println
  }*/


  listOfPlayers onComplete {
    case Success(list) => list foreach println
    case Failure(_) => println(s"listOfPlayers couldn't be fetched.")
  }

  Thread.sleep(5000)
}

case class Player(name: String, nationality: String, age:String, club: String,
                  domesticLeague: String, rawTotal: String, finalScore: String,
                   ranking2016: String, ranking2015: String)