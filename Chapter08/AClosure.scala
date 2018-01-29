package chapter8

object AClosure extends App {

  var advertisement = "Buy an IPhone7"

  val playingShow = (showName: String) => println(s"Playing $showName. Here's the advertisement: $advertisement")

  playingShow("GOT")

  advertisement = "Buy an IPhone8"

  playingShow("GOF")


  def multiplier10(x : Int): Int => Int = x => x * 10   //functionAsOutput

  //def intOpPerformer(g: Int => Int) : Int = g(5)        //functionAsInput

  def intOpPerformer(y: Int) : Int = multiplier10(y)(5)      //functionAsInput

  def multiplicator(x: Int)(g: Int => Int): Int = g(x)  //functionAsParameter

  println(s"functionAsInput Result: ${intOpPerformer(1)}")

  println(s"functionAsParameter Result: ${multiplicator(5)(multiplier10(5))}")

}