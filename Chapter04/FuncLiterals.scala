package chapter4


object ColorPrinter extends App {

  val printerSwitch = false

  def printPages(doc: Document, lastIndex: Int, print: (Int) => Unit) = {

    if(lastIndex <= doc.numOfPages && !printerSwitch) for(i <- 1 to lastIndex) print(i)

  }

  val colorPrint = (index: Int) => println(s"Printing Color Page $index.")

  val colorPrintV2 = new Function1[Int, Unit]{
    override def apply(index: Int): Unit =
      println(s"Printing Color Page $index.")
  }

  println("---------Function V1-----------")
  printPages(Document(15, "DOCX"), 2, colorPrint)

  println("---------Function V2-----------")
  printPages(Document(15, "DOCX"), 2, colorPrintV2)

}

case class Document(numOfPages: Int, typeOfDoc: String)



/*
* println("---------Method V3-----------")
  printPages(chapter3.Document(15, "DOCX"), 2, colorPrintV3, !printerSwitch)
*
* */

/*object AClosure extends App {

  var advertisement = "Buy an IPhone7"

  val playingShow = (showName: String) => println(s"Playing $showName. Here's the advertisement: $advertisement")

  playingShow("GOT")

  advertisement = "Buy an IPhone8"

  playingShow("GOF")

}*/
