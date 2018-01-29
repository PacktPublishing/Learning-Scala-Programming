package chapter5

object CollectionOperations extends App {

  val source = io.Source.fromFile("/Users/vika/Documents/LSProg/LSPWorkspace/FirstProject/src/chapter5/football_stats.csv")

  val bufferedSourceToList: List[String] = {
    val list = source.getLines().toList
    source.close()
    list
  }

  def giveMePlayers(list: List[String]): List[Player] = list match {
      case head :: tail => tail map {line =>
        val columns = line.split((",")).map(_.trim)
        Player(columns(5),columns(6),columns(9),columns(7),
          columns(8),columns(10), columns(12), columns(0),columns(2))
      }
      case Nil => List[Player]()
  }

  val players = giveMePlayers(bufferedSourceToList)

  def showPlayers(players: List[Player]) = players foreach(printPlayer(_))

  def printPlayer(p: Player) =
    println(s"""Player: ${p.name}    Country: ${p.nationality}   Ranking 2016: ${p.ranking2016}

    ***** Other Information *****
    Age: ${p.age}  |  Club: ${p.club}  |  Domestic League: ${p.domesticLeague}
    Raw Total: ${p.rawTotal}  |  Final Score: ${p.finalScore}  |  Ranking 2015: ${p.ranking2015}
    ##########################################################""")

  val isGermanPlayer: (Player => Boolean) = _.nationality.equalsIgnoreCase("Germany")
  val isAge35plus: (Player => Boolean) = _.age.toInt >= 35

  val takeTop10 = players takeWhile(_.ranking2016.toInt < 11)
  val filterTop10 = players filter(_.ranking2016.toInt < 11)

  val first50Players = players take 50
  val (top20,least30) = first50Players span(_.ranking2016.toInt < 21)

  /*val numberOfGermanPlayers = players count isGermanPlayer
  println(s"German Players: $numberOfGermanPlayers")
  //showPlayers(least30)

  val isAnyPlayerAbove45 = players exists(p => p.age.toInt > 40)
  println(s"isAnyPlayerAbove45: $isAnyPlayerAbove45")

  val topPlayerWithAge35plus = players find(p => p.age.toInt > 35)
  printPlayer(topPlayerWithAge35plus.get)*/

  val top5PlayerWithAge35plus = players filter isAge35plus take 5
  showPlayers(top5PlayerWithAge35plus)

  val Top20Countries = top20.foldLeft(List[String]())((b,a) => a.nationality :: b)
  val top20Countries = top20.foldRight(List[String]())((b,a) => b.nationality :: a)

  //top20Countries.par map(println(_))


}

case class Player(name: String, nationality: String, age:String, club: String, domesticLeague: String, rawTotal: String,
                  finalScore: String, ranking2016: String, ranking2015: String)