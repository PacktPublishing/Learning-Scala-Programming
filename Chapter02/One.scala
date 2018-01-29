import java.util.UUID

class Item {
  val id: UUID = UUID.randomUUID()
}

class ElectronicItem(val name: String, val subCategory: String) extends Item {
  val uuid: String = "Elec_" + id
}

object CartApp extends App {

  def showItem(item: ElectronicItem) = println(s"Item id: ${item.id} uuid: ${item.uuid} name: ${item.name}")

  showItem(new ElectronicItem("Xperia", "Mobiles"))
  showItem(new ElectronicItem("IPhone", "Mobiles"))

}