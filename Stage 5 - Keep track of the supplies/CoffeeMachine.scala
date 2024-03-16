package machine

import scala.io.StdIn.{readInt, readLine}

object CoffeeMachine extends App {
  private var availableWater = 400
  private var availableMilk = 540
  private var availableCoffeeBeans = 120
  private var availableCups = 9
  var money = 550

  private def printState(): Unit = {
    println(s"""
               |The coffee machine has:
               |$availableWater ml of water
               |$availableMilk ml of milk
               |$availableCoffeeBeans g of coffee beans
               |$availableCups disposable cups
               |$$$money of money
               |""".stripMargin)
  }

  private def buyCoffee(coffeeType: Int): Unit = {
    val (water, milk, beans, cost) = coffeeType match {
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
  }

  private def fillSupplies(): Unit = {
    println("Write how many ml of water you want to add:")
    availableWater += readInt()
    println("Write how many ml of milk you want to add:")
    availableMilk += readInt()
    println("Write how many grams of coffee beans you want to add:")
    availableCoffeeBeans += readInt()
    println("Write how many disposable cups you want to add:")
    availableCups += readInt()
  }

  private def takeMoney(): Unit = {
    println(s"I gave you $$$money")
    money = 0
  }

  var action = ""
  while (action != "exit")
  do {
    println("Write action (buy, fill, take, remaining, exit):")
    action = readLine()

    action match {
      case "buy" =>
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val coffeeType = readLine()
        if (coffeeType != "back") buyCoffee(coffeeType.toInt)
      case "fill" => fillSupplies()
      case "take" => takeMoney()
      case "remaining" => printState()
      case "exit" => // Do nothing, just exit the loop
      case _ => println("Invalid action")
    }
  }
}
