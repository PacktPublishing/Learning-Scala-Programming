package lsp

import lsp.SimpleActor.{GetPlayerInformationRequest, PlayerInformationResponse, ShowFootballPlayersRequest}
import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import scala.io.{BufferedSource, Source}
import akka.util.Timeout
import lsp.Util.{asPlayers, bufferedSourceToList}
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import akka.actor.OneForOneStrategy
import akka.actor.AllForOneStrategy


class SimpleActor extends Actor with ActorLogging {
  import SimpleActor.ShowFootballPlayersRequest

  override def preStart(): Unit = log.info("SimpleActor starting!")

  override def postStop(): Unit = log.info("SimpleActor stopping!")

  val anotherActor = context.actorOf(AnotherActor.props)

  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      anotherActor forward ShowFootballPlayersRequest(url)
    }

    case GetPlayerInformationRequest(name, listOfPlayers) => {
      log.info(s"Executing GetPlayerInformationRequest($name, listOfPlayers)")

      akka.pattern.pipe(
        Future {
          PlayerInformationResponse(listOfPlayers.find(_.name.contains(name)))
        }
      ) to sender()

    }

    case "terminate" => context stop self

  }

}

class AnotherActor extends Actor {
  override def receive = {
    case ShowFootballPlayersRequest(url) => {
      val playersInfoSource = Source.fromFile(url)

      val players = asPlayers(bufferedSourceToList(playersInfoSource))
      players.foreach(player => println(player + "\n"))
    }
  }
}

object AnotherActor {
  val props = Props[AnotherActor]
}

object SimpleActor {
  val props = Props[SimpleActor]

  final case class ShowFootballPlayersRequest(uri: String)

  final case class GetPlayerInformationRequest(name: String, source: List[Player])
  final case class PlayerInformationResponse(player: Option[Player])
}

object AkkaStarter extends App {
  import Util._

  implicit val timeout = Timeout(5 seconds)

  val simpleActorSystem = ActorSystem("SimpleActorSystem")
  val simpleActor = simpleActorSystem.actorOf(SimpleActor.props, "simple-actor")

  val fileSource =
    "/Users/vika/Workspace/akkaa/akka-starter/src/main/scala/files/football_stats.csv"

  //simpleActor ! ShowFootballPlayersRequest(fileSource)

  //Storing players in a collection!
  val players: List[Player] = Util
    .asPlayers(bufferedSourceToList(
      scala.io.Source.fromFile(fileSource)
    ))

  val playerInformation = (simpleActor ? GetPlayerInformationRequest("Cristiano Ronaldo", players))

  playerInformation
    .mapTo[PlayerInformationResponse]
    .map(futureValue => {
        futureValue.player map println
      })

  simpleActor ! PoisonPill
}

object Util {

  def bufferedSourceToList(source: BufferedSource): List[String] = {
      val list = source.getLines().toList
      source.close()
      list
  }

  def asPlayers(listOfPlayersString: List[String]) : List[Player] = listOfPlayersString match {
    case head :: tail => tail map {line =>
      val columns = line.split((",")).map(_.trim)
      Player(columns(5),columns(6),columns(9),columns(7),
        columns(8),columns(10), columns(12), columns(0),columns(2))
    }
    case Nil => List[Player]()
  }

}

case class Player(name: String, nationality: String, age:String, club: String,
                  domesticLeague: String, rawTotal: String, finalScore: String,
                  ranking2016: String, ranking2015: String)

