package chapter13

object ThreadEncounter extends App {

  class FirstThread extends Thread {
    override def run(): Unit = println(s"FirstThread's run!")
  }

  val firstThread = new FirstThread()
  firstThread.start()

  println(s"CurrentThread: ${Thread.currentThread().getName}")
  println(s"firstThread: ${firstThread.getName}")

}
