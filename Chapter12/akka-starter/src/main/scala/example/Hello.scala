package example

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

object Hello extends Greeting with App {
  println(greeting)
  val system = ActorSystem("SimpleActorSystem")

  val props = Props[SimpleActor]()
    .withDispatcher("some-simple-dispatcher")

  val simpleActor: ActorRef = system.actorOf(props, "simple-actor")

  println(s"SimpleActor: $simpleActor")

}

class SimpleActor extends Actor with ActorLogging{
  override def receive = Actor.emptyBehavior

  val anotherSimpleActor = context.actorOf(Props[AnotherSimplActor], "another-simple-actor")

  context.actorSelection("../siblingActor")
  context.actorSelection("/user/siblingActor")
}

object SimpleActor {

}

class AnotherSimplActor extends Actor {
  override def receive = Actor.emptyBehavior
}

object AnotherSimplActor {

}



trait Greeting {
  lazy val greeting: String = "hello"
}
