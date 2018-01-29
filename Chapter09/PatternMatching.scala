package chapter9

import scala.util.control.NonFatal

/**
  * Created by vika on 18/06/17.
  */
object PatternMatching extends App {

  def matchAgainst(i: Int) = i match {
    case 1 => println("One")
    case 2 => println("Two")
    case 3 => println("Three")
    case 4 => println("Four")
    case _ => println("Not in Range 1 to 4")
  }

  matchAgainst(1)
  matchAgainst(5)

  val somelist = 1 :: 2 :: 3 :: Nil

  val x = somelist match {
    case Nil => Nil
    case _ => println(s"anything")
    case head :: tail => println("something with a head and a tail")
  }

  def safeToInt(canBeNumber: String): Option[Int] = {
    try {
      Some(canBeNumber.toInt)
    } catch {
      case NonFatal(e) => None
    }
  }

  safeToInt("10") match {
    case None => println(s"Got nothing")
    case Some(value) =>  println(s"Got $value")
  }

  //lazy val x = processRecords

  def processRecords =


  safeToInt("ten") map println
  safeToInt("10") map println
  safeToInt("s10") map println


  trait Employee
  case class ContractEmp(id: String, name: String) extends Employee
  case class Developer(id: String, name: String) extends Employee
  case class Consultant(id: String, name: String) extends Employee

  def generateIdOp(emp: Employee): Option[String]= emp match {
    case c: ContractEmp => Some("C" + c.id)
    case d: Developer => Some("D" + d.id)
    case cn: Consultant => Some("CN" + cn.id)
    case _ => None
  }

 /*
  * Process joining bonus if
  *     :> Developer has ID Starting from "DL"  JB: 1L
  *     :> Consultant has  ID Starting from "CNL":  1L
  */
  def processJoiningBonus(employee: Employee, amountCTC: Double) = employee match {
    case ContractEmp(id, _) => amountCTC
    case Developer(id, _) if id.startsWith("DL") => amountCTC + 10000.0
    case Consultant(id, _) if id.startsWith("CNL") =>  amountCTC + 10000.0
    case _ => amountCTC
  }

  val developerEmplEligibleForJB = Developer("DL0001", "Alex")
  val consultantEmpEligibleForJB = Consultant("CNL0001","Henry")
  val developer = Developer("DI0002", "Heith")

  println(processJoiningBonus(developerEmplEligibleForJB, 55000))
  println(processJoiningBonus(consultantEmpEligibleForJB, 65000))
  println(processJoiningBonus(developer, 66000))

  case class Car(name: String, brand: CarBrand)
  case class CarBrand(name: String)

  val car = Car("Model X", CarBrand("Tesla"))
  val anyCar = Car("Model XYZ", CarBrand("XYZ"))

  def matchCar(c: Car) = c match {
    case Car(_, brand @ CarBrand("Tesla")) => println(s"It's a Tesla Car!")
    case _ => println(s"It's just a Carrr!!")
  }

  matchCar(car)
  matchCar(anyCar)
}

