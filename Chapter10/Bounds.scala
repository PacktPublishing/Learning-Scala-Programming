package chapter10

object Bounds extends App {

   /*
    * AircraftSeats can be consumed only by Passengers.
    */
  class AircraftSeat[-T <: Passengers]

  def reserveSeatForCorporatePassengers(corporateSeats: AircraftSeat[CorporatePassengers]) = {
    //Performs some logic regarding the seat reservation!
    println(s"Seats Confirmed!")
  }

  val corporateSeat = new AircraftSeat[CorporatePassengers]()
  val passengersSeat = new AircraftSeat[Passengers]()

  reserveSeatForCorporatePassengers(new AircraftSeat[CorporatePassengers]())
  reserveSeatForCorporatePassengers(new AircraftSeat[Passengers]())

  abstract class Passengers
  class CorporatePassengers extends Passengers
  class RegularPassengers extends Passengers

  /*class ListLikeStructure[T >: AnyRef <: Any]

  new ListLikeStructure[Any]()
  new ListLikeStructure[AnyRef]()
  new ListLikeStructure[Object]()*/


  abstract class Zero
  trait One extends Zero
  trait Two extends One
  trait Three extends Two
  trait Four extends Three

  class ListLikeStructure[T >: Four <: Two]

  new ListLikeStructure[Four]
  new ListLikeStructure[Three]
  new ListLikeStructure[Two]
  //new ListLikeStructure[One]

  trait CSVEncoder[T] {
    def encode(t: T): List[String]
  }

}
