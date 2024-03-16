package machine

import scala.io.StdIn.readLine

class CoffeeMachine {
  private var availableWater = 400
  private var availableMilk = 540
  private var availableCoffeeBeans = 120
  private var availableCups = 9
  private var money = 550

  private def printState(): Unit = {
    println(
      s"""
         |The coffee machine has:
         |$availableWater ml of water
         |$availableMilk ml of milk
         |$availableCoffeeBeans g of coffee beans
         |$availableCups disposable cups
         |$$$money of money
         |""".stripMargin
    )
  }

  def processInput(input: String): Unit = {
    input match {
      case "remaining" => printState()
      case "buy" => buyCoffee()
      case "fill" => fillSupplies()
      case "take" => takeMoney()
      case _ => println("Invalid action")
    }
  }

  private def buyCoffee(): Unit = {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val coffeeType = readLine()
    coffeeType match {
      case "1" | "2" | "3" =>
        val coffee = coffeeType.toInt
        val (water, milk, beans, cost) = coffee match {
          case 1 => (250, 0, 16, 4)
          case 2 => (350, 75, 20, 7)
          case 3 => (200, 100, 12, 6)
          case _ => (0, 0, 0, 0) // Invalid option
        }
        if (availableWater >= water && availableMilk >= milk && availableCoffeeBeans >= beans && availableCups >= 1) {
          println("I have enough resources, making you a coffee!")
          availableWater -= water
          availableMilk -= milk
          availableCoffeeBeans -= beans
          availableCups -= 1
          money += cost
        } else {
          println("Sorry, not enough resources!")
        }
      case _ => println("Invalid option")
    }
  }

  private def fillSupplies(): Unit = {
    println("Write how many ml of water you want to add:")
    availableWater += readLine().toInt
    println("Write how many ml of milk you want to add:")
    availableMilk += readLine().toInt
    println("Write how many grams of coffee beans you want to add:")
    availableCoffeeBeans += readLine().toInt
    println("Write how many disposable cups you want to add:")
    availableCups += readLine().toInt
  }

  private def takeMoney(): Unit = {
    println(s"I gave you $$$money")
    money = 0
  }
}

object CoffeeMachine {
  def main(args: Array[String]): Unit = {
    val machine = new CoffeeMachine()
    var input = ""
    while (input != "exit")
    do {
      println("Write action (buy, fill, take, remaining, exit):")
      input = readLine()
      machine.processInput(input)
    }
  }
}
