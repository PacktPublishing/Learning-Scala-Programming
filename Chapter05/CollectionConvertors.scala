package chapter5

import java.time.LocalDate
import scala.collection.JavaConverters._

object CollectionConvertors extends App {
    val aJavaList = new java.util.ArrayList[LocalDate]()
    aJavaList.add(LocalDate.now())
    aJavaList.add(aJavaList.get(0).plusDays(1))

    println(s"Java List of today and tomorrow: $aJavaList")

    val scalaDates = aJavaList.asScala
    scalaDates map { date =>
      println(s"Date :: $date")
    }

    val backToJavaList = scalaDates.asJavaCollection
    println(backToJavaList)
}