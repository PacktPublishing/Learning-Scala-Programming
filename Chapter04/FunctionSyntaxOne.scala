package chapter4

object FunctionSyntaxOne extends App {

  def compareIntegersV4(value1: Int, value2: Int): String = {
    println(s"Executing V4")
    val result = if (value1 == value2) 0 else if (value1 > value2) 1 else -1
    giveAMeaningFullResult(result, value1, value2)
  }

  private def giveAMeaningFullResult(result: Int, value1: Int, value2: Int) = result match {
    case 0 => "Values are equal"
    case -1 => s"$value1 is smaller than $value2"
    case 1 => s"$value1 is greater than $value2"
    case _ => "Could not perform the operation"
  }

  println(compareIntegersV4(2,1))
}