

package country {
  abstract class Region

  import customutil.{Util => u}

  class Country(val name: String) extends Region {

    val populationsMap  = scala.collection.mutable.Map[Int, Double]()

    def showAveragePopulation = println(u.averagePopulation(this.populationsMap.values))
  }

  package state {

    class State(val name: String) extends Region {

      import u.{averagePopulation => ap}

      val populationsMap  = scala.collection.mutable.Map[Int, Double]()

      def showAveragePopulation = println(ap(this.populationsMap.values))
    }

  }
}

package customutil {
  object Util {

    def averagePopulation(populations: Iterable[Double]) = populations.sum / populations.size

  }
}

object CountryApp extends App {
  import country.Country
  import customutil.Util.averagePopulation

  val aCountry = new Country("France")
  aCountry.populationsMap.put(2017, 64.94)
  aCountry.populationsMap.put(2016, 64.66)
  aCountry.populationsMap.put(2015, 64.395)

  println(averagePopulation(aCountry.populationsMap.values))

}