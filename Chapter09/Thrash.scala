package chapter9

trait Thrash {

  case class CC(number: Int, holder: String, limit: Double){
    def currentBalance() : Double = ???  // Some

    def accountsLinked(holder: String) : List[Account] = ???
  }

  case class Account(id: Int, holder: String)

  val creditCards = List(CC(1, "David", 50000), CC(2, "Alex", 60000))

/*
  creditCards.filter(_.limit < 55000)
    .map(cc => cc.accounts(cc.holder))
    .filter(_.isLinkedAccount)
      .get
    .info
*/

}
