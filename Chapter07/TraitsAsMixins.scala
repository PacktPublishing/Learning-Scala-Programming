package chapter7


case class Amount(amt: Double, currency: String){
  override def toString: String = s"$amt ${currency.toUpperCase}"
}

abstract class CreditCard {
  val ccType = "Default"
  def creditLimit(x: Double) : Amount

  //legacy creditCardNumberGeneratorLogic
  val ccNum = scala.util.Random.nextInt(1000000000).toString

  //other methods
}

class BasicCreditCard extends CreditCard {
  override def creditLimit(x: Double): Amount = Amount(x,"USD")
}

trait GoldSubscription extends CreditCard {
  abstract override def creditLimit(x: Double): Amount = super.creditLimit(x * 1.10)
}

trait PlatinumSubscription extends CreditCard {
  abstract override def creditLimit(x: Double): Amount = super.creditLimit(x * 1.25)
}

trait CreditCardOps {
   self: CreditCard =>
   val ccNumber: String = ccType match {
     case "BASIC" => "BC" + ccNum
     case _ => "DC" + ccNum
   }
}
/*
object CCApp extends App {
  val basicCreditCard = new CreditCard with CreditCardOps {
    override def creditLimit(x: Double): chapter2.Amount = chapter2.Amount(x, "USD")
  }



  val limit = basicCreditCard.creditLimit(1000)
  println(s"CreditCardNumber ${basicCreditCard.ccNumber} with limit: $limit")
}*/

object CCApp extends App {
  val basicCreditCard = new BasicCreditCard()
  println(basicCreditCard.creditLimit(15000))

  val goldCreditCard = new BasicCreditCard() with GoldSubscription
  println(goldCreditCard.creditLimit(15000))

  val platinumCreditCard = new BasicCreditCard() with PlatinumSubscription
  println(platinumCreditCard.creditLimit(15000))

  val gpluspCreditCard = new BasicCreditCard() with GoldSubscription with PlatinumSubscription
  println(gpluspCreditCard.creditLimit(15000))
}
