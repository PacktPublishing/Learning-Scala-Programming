package chapter11

import scala.util.{Failure, Success, Try}

object BankApp extends App {

  val accountHolders = Map(
    "1234" -> AccountInfo("Albert", 1000),
    "2345" -> AccountInfo("Bob", 3000),
    "3456" -> AccountInfo("Catherine", 9000),
    "4567" -> AccountInfo("David", 7000)
  )

  //def getAccountInfo(id: String): Option[AccountInfo] = Try(accountHolders(id)).toOption
  def getAccountInfo(id: String): Either[String, AccountInfo] = Try(accountHolders(id)) match {
    case Success(value) => Right(value)
    case Failure(excep) => Left("Could't fetch the AccountInfo, Please Check the id passed or try again!")
  }

  //def makeTransaction(amt: Double, accountInfo: AccountInfo): Option[Double] = Try(accountInfo.balance - amt).toOption
  def makeTransaction(amt: Double, accountInfo: AccountInfo): Either[String, Double] = Try {
    if(accountInfo.balance < amt) throw new Exception("Not enough account balance!") else accountInfo.balance - amt
  } match {
    case Success(value) => Right(value)
    case Failure(excep) => Left(excep.getMessage)
  }

  println(getAccountInfo("1234").flatMap(actInfo => makeTransaction(100, actInfo)))
  println(getAccountInfo("1234").flatMap(actInfo => makeTransaction(10000, actInfo)))
  println(getAccountInfo("12345").flatMap(actInfo => makeTransaction(100, actInfo)))

  def flatMap[A, B](someValue: Option[A])(functionToPerfom: A => Option[B]): Option[B] =
    if (someValue.isEmpty) None else functionToPerfom(someValue.get)
}

case class AccountInfo(id: String, balance: Double)
