package chapter4

object FunctionCalls extends App {

  /*def average(numbers: Int*) : Double = numbers.foldLeft(0)((r,c) => r + c) / numbers.length
  def averageV1(numbers: Int*) : Double = numbers.foldLeft(0)(_ + _) / numbers.length
  def averageV2(numbers: Int*) : Double = numbers.sum / numbers.length

  println(average(2,2))
  println(averageV1(1,2,3))
  println(averageV2(1,2,3,2))*/

  def compareIntegersV6(value1: Int, value2: Int = 10): String = {
    println(s"Executing V6")

    def giveAMeaningFullResult(result: Int) = result match {
      case 0 => "Values are equal"
      case -1 => s"$value1 is smaller than $value2"
      case 1 => s"$value1 is greater than $value2"
      case _ => "Could not perform the operation"
    }

    val result = if (value1 == value2) 0 else if (value1 > value2) 1 else -1
    giveAMeaningFullResult(result)
  }

  println(compareIntegersV6(value2 = 12, value1 = 10))

  val compareFuncLiteral = (value1: Int, value2: Int) => if (value1 == value2) 0 else if (value1 > value2) 1 else -1

}
