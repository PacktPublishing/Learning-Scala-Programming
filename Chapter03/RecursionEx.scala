package chapter3

object RecursionEx extends App {

  /*
  * 2 to the power n
  * Only works for positive integers
  */
  def power2toN(n: Int): Int = if(n == 0) 1 else 2 * power2toN(n - 1)

  println(power2toN(2))
  println(power2toN(4))
  println(power2toN(6))
}