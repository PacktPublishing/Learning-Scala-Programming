package chapter10

object Intelligence extends App {
  type Rating = Int
  type NumericString = String //String that can be converted into Int!
  type AlphaNumeric = String  //Alphanumeric String

  trait ActionGenerator[In] {
    type Out

    def generateAction(): Out
  }

  val simpleRatingGenerator = new ActionGenerator[NumericString] {
    type Out = NumericString => Rating

   /* Times when ratings are simple NumericStrings
    * Rating as 1, 2, 3, 4, 5
    * We don't care about numbers more than 5
    */
    override def generateAction(): NumericString => Rating = _.toInt
  }

  val alphanumericRatingGenerator = new ActionGenerator[AlphaNumeric] {
    type Out = AlphaNumeric => Rating

   /* Times when ratings are Awesome, Super, Good, something else like Neutral
    * Rating as 1, 2, 3, 4, 5
    */
    override def generateAction(): AlphaNumeric => Rating = toRating// Some other mechanism to generate the rating
  }

  val toRating: AlphaNumeric => Rating = _ match {
    case "Awesome" => 5
    case "Cool"    => 4
    case "Nice"    => 3
    case "Worst Ever" => 1
    case _ => 3 // No Comments then average rating.
  }

  val generateNumericRating = simpleRatingGenerator.generateAction()
  val generateAlphanumericRating = alphanumericRatingGenerator.generateAction()

  println(generateNumericRating("1"))
  println(generateAlphanumericRating("Awesome"))
}

trait ActionGenerator[In] {
  type Out

  def generateAction(): Out
}

object RatingApp extends App {

  type Rating = Int
  type NumericString = String //String that can be converted into Int!
  type AlphaNumeric = String  //Alphanumeric String

  val simpleRatingGenerator = new ActionGenerator[NumericString] {
    type Out = NumericString => Rating

    /* Times when ratings are simple NumericStrings
     * Rating as 1, 2, 3, 4, 5
     * We don't care about numbers more than 5
     */
    override def generateAction(): NumericString => Rating = _.toInt
  }

  val generateNumericRating = simpleRatingGenerator.generateAction()

  println(generateNumericRating("1"))
}