package chapter9

object TypeParameterization {

  def main(args: Array[String]): Unit = {
      val mayBeAnInteger = Some("101")
      val mayBeADouble = Some("101.0")
      val mayBeTrue = Some("true")

    println(s"Calling mapToValue: ${mapToValue(mayBeAnInteger, x => x.toInt)}")
    println(s"Calling mapToValue: ${mapToValue(mayBeADouble, x => x.toDouble)}")
    println(s"Calling mapToValue: ${mapToValue(mayBeTrue, x => x.toBoolean)}")
  }

  def mapToValue[T](mayBeValue: Option[String], function: String => T) : T = function(mayBeValue.get)
}

/*def mapToInt(mayBeInt: Option[String], function: String => Int) = function(mayBeInt.get)

  def mapToDouble(mayBeDouble: Option[String], function: String => Double) = function(mayBeDouble.get)

  def mapToBoolean(mayBeBoolean: Option[String], function: String => Boolean) = function(mayBeBoolean.get)*/
