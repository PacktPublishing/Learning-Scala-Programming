package restaurant

import restaurant.privaterestaurant.PrivateRestaurant
import restaurant.protectedrestaurant.ProtectedRestaurant

case class Dish(name: String)

class Restaurant


package privaterestaurant{

  trait Kitchen {
    self: Restaurant =>

    private[privaterestaurant]  val secret = "Secret to tasty dish" //Think of a secret logical evaluation resulting in value, we don't want to expose.

    def cookMyDish: Option[Dish] = Some(Dish(secret))

  }

  class  PrivateRestaurant  extends Restaurant with Kitchen  {

    def serveDishWithSecret = Dish(secret) // Symbol secret is inaccessible from this place.

    private[this] val magicSecret = "magic"

    def serveDish = cookMyDish // Works fine
  }

}

package  protectedrestaurant {

  import restaurant.privaterestaurant.Kitchen

  class ProtectedRestaurant extends Restaurant with Kitchen {

    //def serveDishWithSecret = Dish(secret) // Symbol secret is inaccessible from this place.

    def serveDish = cookMyDish // Works fine
  }

}

object privateApp extends App{
  val privateRestaurant = new PrivateRestaurant()
  val protectedRestaurant = new ProtectedRestaurant()

  println(s"private[this] : ${protectedRestaurant}")

  //println(s"private ${privateRestaurant.getClass.getPackage} and ${privateRestaurant.secret}")
  //println(s"protected ${protectedRestaurant.getClass.getPackage} and ${privateRestaurant.secret}")

}


