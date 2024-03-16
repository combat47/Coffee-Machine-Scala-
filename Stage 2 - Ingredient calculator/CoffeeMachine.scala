package machine

import scala.io.StdIn.readInt

object CoffeeMachine extends App {
  println("Write how many cups of coffee you will need:")
  val cups = readInt()
  var water = 200
  var milk = 50
  private val coffeeBeans = 15
  println(
    s"""
      |For $cups cups of coffee you will need:
      |${cups * water} ml of water
      |${cups * milk} ml of milk
      |${cups * coffeeBeans} g of coffee beans
      |""".stripMargin)
}