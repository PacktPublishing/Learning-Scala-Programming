package chapter2

object Two extends App {

   def checkIF10AndReturn20(x: Int): Int =  {
      if(x == 10)
        x * 2
      else
        throw new Exception("Sorry, Value wasn't 10")
    }

   println(s"Calling function with 10: ${checkIF10AndReturn20(10)}")

   println(s"Calling function with 10: ${checkIF10AndReturn20(20)}") // Throws Exception!
}
