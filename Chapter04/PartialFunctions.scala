package chapter4

object PartialFunctions extends App {

  val isPrimeEligible: PartialFunction[Item, Boolean] = {
    case item => item.isPrimeEligible
  }

  val amountMoreThan500: PartialFunction[Item, Boolean] = {
    case item => item.price > 500.0
  }

  val freeDeliverable = isPrimeEligible orElse amountMoreThan500

  def deliveryCharge(item: Item): Double = if(freeDeliverable(item)) 0 else 50

  println(deliveryCharge(Item("1", "ABC Keyboard", 490.0, false)))

}

case class Item(id: String, name: String, price: Double, isPrimeEligible: Boolean)