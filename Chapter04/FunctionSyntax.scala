package chapter4



object FunctionSyntax extends App{
 /*
  * Function compare two Integer numbers
  * @param value1 Int
  * @param value2 Int
  * return Int
  * 1  if value1 > value2
  * 0  if value1 = value2
  * -1 if value1 < value2
  */
  def compareIntegers(value1: Int, value2: Int): Int = if (value1 == value2) 0 else if (value1 > value2) 1 else -1

  def compareIntegersV1(value1: Int, value2: Int): Int = {
    if (value1 == value2) 0 else if (value1 > value2) 1 else -1
  }

  def compareIntegersV2(value1: Int, value2: Int): Int =
    if (value1 == value2) 0 else if (value1 > value2) 1 else -1

  println(compareIntegers(1, 2))
  println(compareIntegersV1(2, 1))
  println(compareIntegersV2(2, 2))

}
