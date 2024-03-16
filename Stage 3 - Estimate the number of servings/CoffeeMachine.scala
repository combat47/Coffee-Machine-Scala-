package machine

import scala.io.StdIn.readInt

object CoffeeMachine extends App {
  println("Write how many ml of water the coffee machine has:")
  private val availableWater = readInt()
  println("Write how many ml of milk the coffee machine has:")
  private val availableMilk = readInt()
  println("Write how many grams of coffee beans the coffee machine has:")
  private val availableCoffeeBeans = readInt()
  println("Write how many cups of coffee you will need:")
  private val cupsNeeded = readInt()

  // Calculate the maximum number of cups that can be made with available ingredients
  private val maxCupsWater = availableWater / 200
  private val maxCupsMilk = availableMilk / 50
  private val maxCupsBeans = availableCoffeeBeans / 15
  private val maxCupsPossible = List(maxCupsWater, maxCupsMilk, maxCupsBeans).min

  if (maxCupsPossible >= cupsNeeded) {
    val extraCups = maxCupsPossible - cupsNeeded
    if (extraCups == 0) {
      println("Yes, I can make that amount of coffee")
    } else {
      println(s"Yes, I can make that amount of coffee (and even $extraCups more than that)")
    }
  } else {
    println(s"No, I can make only $maxCupsPossible cup(s) of coffee")
  }
}
