package chapter10

object AbsVsParamTypes extends App {

  abstract class Animal {
     type SuitableFood <: Food

     def eatMeal(meal: SuitableFood)
  }

  class Lion extends Animal {
    type SuitableFood <: Meat

    override def eatMeal(meal: SuitableFood): Unit = println("Lion's eating meat!")
  }

  class Cow extends Animal {
    type SuitableFood <: Grass

    override def eatMeal(meal: SuitableFood): Unit = println("Cow's eating grass!")
  }

  val lion = new Lion(){
    type SuitableFood = Meat
  }

  val cow = new Cow(){
    type SuitableFood = Grass
  }

  cow.eatMeal(new Grass)
  lion.eatMeal(new Meat)

  abstract class Food
  class Grass extends Food
  class Meat extends Food

}