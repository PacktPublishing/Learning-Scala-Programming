package example

import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props, ActorLogging}

import scala.concurrent.duration._

object SupervisionStrategyInPractice extends App {
  val system = ActorSystem("anActorSystem")

  val topLevelActor = system.actorOf(TopLevelActor.props)

  //Sending StopIt
  topLevelActor ! TopLevelActor.StopIt
  //Sending RestartIt
  topLevelActor ! TopLevelActor.RestartIt
}

class TopLevelActor extends Actor with ActorLogging {
  import akka.actor.SupervisorStrategy.{Resume, Restart}
  import TopLevelActor._

  override val preStart = log.info(s"TopLevelActor started!")
  override val postStop = log.info(s"TopLevelActor stopping!")

  val superSimpleActor = context.actorOf(SuperSimpleActor.props)

  override def receive = {
    case StopIt => superSimpleActor ! SuperSimpleActor.ArithmeticOpRequest
    case RestartIt => superSimpleActor ! SuperSimpleActor.OtherMessage
  }

  override val supervisorStrategy =
    OneForOneStrategy(
      maxNrOfRetries = 3,
      withinTimeRange = 1 minute
    ){
      case _: ArithmeticException => {
        log.info("Supervisor handling ArithmeticException! \n Resuming!")
        Resume
      }
      case _: Exception => {
        log.info("Supervisor handling Exception! \n Restarting!")
        Restart
      }
    }
}

object TopLevelActor {
  val props = Props[TopLevelActor]

  case object StopIt
  case object RestartIt
}

class SuperSimpleActor extends Actor with ActorLogging {
  import SuperSimpleActor._

  override val preStart = log.info(s"SuperSimpleActor started!")
  override val postStop = log.info(s"SuperSimpleActor stopping!")

  override def preRestart(reason: Throwable, message: Option[Any]): Unit =
    log.info(s"SuperSimpleActor restarting!")

  override def receive = {
    case ArithmeticOpRequest => 1 / 0
    case OtherMessage => throw new Exception("Some Exception Occurred!")
  }

}

object SuperSimpleActor {
  val props = Props[SuperSimpleActor]

  case object ArithmeticOpRequest
  case object OtherMessage
}