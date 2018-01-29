package lsp

object First {
  def main(args: Array[String]): Unit = {
    val double: (Int => Int) = _ * 2
    (1 to 10) foreach double .andThen(println)
  }
}


// Uncomment the below code snippet.
/*

  object FirstApp extends App {
    val double: (Int => Int) = _ * 2
    (1 to 10) foreach double .andThen(print)
  }

 */

