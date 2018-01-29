package lsp

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import lsp.SimpleActor.{GetPlayerInformationRequest, PlayerInformationResponse}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

class SimpleActorSpec extends TestKit(ActorSystem("testActorSystem"))
  with ImplicitSender with WordSpecLike with BeforeAndAfterAll {

  override def afterAll(): Unit = super.afterAll()

  val players = List(Player("Cristiano Ronaldo", "Portuguese", "32",
    "Real Madrid", "La Liga", "1999", "1999", "1", "1"))

  "SimpleActor" must {

    "test for PlayerInformationRequest" in {

      val simpleActor = system.actorOf(SimpleActor.props)
      simpleActor ! GetPlayerInformationRequest("Cristiano Ronaldo", players)
      val expectedResponse =
        PlayerInformationResponse(Some(Player("Cristiano Ronaldo",
          "Portuguese", "32", "Real Madrid", "La Liga", "1999", "1999", "1", "1")))

      expectMsg(expectedResponse)
    }

  }

}