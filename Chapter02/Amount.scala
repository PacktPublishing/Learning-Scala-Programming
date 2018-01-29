package chapter2

class Amount(val amt: Double) {

  def taxApplied(tax: Double) = this.amt * tax/100 + this.amt

}

object Order extends App {
  val tax = 10
  val firstOrderAmount = 130

  def amountAfterTax(amount: Amount) = amount taxApplied tax

  println(s"Total Amount for order:: ${amountAfterTax(new Amount(firstOrderAmount))}")

}