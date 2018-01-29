package chapter8

object PaF extends App {

  type WebsitePlatform = String
  type DomainName = String
  type Host = String
  type Protocol = String

  def makeWebsite(platform: WebsitePlatform, domainName: DomainName, host: Host) =
    println(s"Making $domainName using $platform with hosting from $host ")

  val wordPressSite: (DomainName, Host) => Unit = makeWebsite("WordPress", _: DomainName, _: Host)

  val makeExampleDotCom: (WebsitePlatform, Host) => Unit = makeWebsite(_: WebsitePlatform,
      "example.com",
      _: Host
    )

  val makeBlueHostingExampleDotCom: (WebsitePlatform) => Unit = makeWebsite(_: WebsitePlatform,
    "example.com",
    "bluehost.com",
    )

  makeWebsite("Wordpress", "anyDomain.com", "Godaddy.com")
  wordPressSite("example.com", "Godaddy.com")
  makeExampleDotCom("Wordpress", "bluehost.com")
  makeBlueHostingExampleDotCom("Blogger")

}

object Curried {

  type WebsitePlatform = String
  type DomainName = String
  type Host = String
  type Protocol = String

  def makeWebsite(platform: WebsitePlatform)(domainName: DomainName)(host: Host) =
    println(s"Making $domainName using $platform with hosting from $host ")

  val wordPress: DomainName => Host => Unit = makeWebsite("WordPress")

  val wordPressDummyDotCom : Host => Unit = wordPress("dummy123.com")

  val blueHostedWordPressDummyDotCom : Unit = wordPressDummyDotCom("Bluehost.com")

  blueHostedWordPressDummyDotCom

  def add = (x: Int, y: Int) => x + y

  val addCurried = add.curried

  val addCurriedUncurried = Function.uncurried(addCurried)

  println(add(5,6))
  println(addCurried(5)(6))
  println(addCurriedUncurried(5,6))

}