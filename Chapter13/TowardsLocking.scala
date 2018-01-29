package chapter13

/*object TowardsLocking extends App {
  var counter = 0 // counter variable

  def readWriteCounter(): Int = {
    val incrementedCounter = counter + 1  //Reading counter
    counter = incrementedCounter // Writing to counter
    incrementedCounter
  }

  def printCounter(nTimes: Int): Unit = {
    val readWriteCounterNTimes = for(i <- 1 to nTimes) yield readWriteCounter()
    println(s"${Thread.currentThread.getName} executing :: counter $nTimes times:  $readWriteCounterNTimes")
  }

  class First extends Thread {
    override def run(): Unit = {
      printCounter(10)
    }
  }

  val first = new First
  first.start() // thread-0

  printCounter(10)   // main thread

}*/

object TowardsLockingOne extends App {
  var counter = 0 // counter variable

  def readWriteCounter(): Int = this.synchronized {
    val incrementedCounter = counter + 1  //Reading counter
    counter = incrementedCounter // Writing to counter
    incrementedCounter
  }

  def printCounter(nTimes: Int): Unit = {
    val readWriteCounterNTimes = for(i <- 1 to nTimes) yield readWriteCounter()
    println(s"${Thread.currentThread.getName} executing :: counter $nTimes times:  $readWriteCounterNTimes")
  }

  class First extends Thread {
    override def run(): Unit = {
      printCounter(10)
    }
  }

  val first = new First
  first.start() // thread-0

  printCounter(10)   // main thread
}
