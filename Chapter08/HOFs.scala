package chapter8

object HOFs extends App {

  def operation(op: (Int, Int) => Int, a: Int, b: Int) : Int = op(a,b)

  println(operation((a, b) => a + b, 10, 5))
  println(operation((a, b) => a * b, 10, 5))
  println(operation((a, b) => a - b, 10, 5))
  println(operation((a, b) => a % b, 10, 5))
}

