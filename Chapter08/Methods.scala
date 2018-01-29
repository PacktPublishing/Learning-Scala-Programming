package chapter8

import java.io.File

object Methods {

  def filePrinter() = {
    println("Version 0")
    val filesHere = (new File(".")).listFiles()
    for(file <- filesHere)
      println(file)
  }

  def filePrinterV1()
  {
    println("Version 1")
    val filesHere = (new File(".")).listFiles()
    for(file <- filesHere)
      println(file)
  }

  def filePrinterV2() {
    println("Version 2")
    val filesHere = (new File(".")).listFiles()
    for(file <- filesHere)
      println(file)
  }

  def filePrinterV3() = println("Version 3")
    val filesHere = (new File(".")).listFiles()
    for(file <- filesHere)
      println(file)

  /*def main(args: Array[String]): Unit = {
    filePrinter()
    filePrinterV1()
    filePrinterV2()
    filePrinterV3()
  }*/

}



