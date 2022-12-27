package machine

class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var beans: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550
) {
    fun run() {
        do {
            println("Write action (buy, fill, take, remaining, exit):")
            when (readln()) {
                "buy" -> buyCoffee()
                "fill" -> fillIngredients()
                "take" -> takeMoney()
                "remaining" -> printStatus()
                "exit" -> return
            }
        } while (true)
    }

    private fun buyCoffee() {
        when (requestInput("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")) {
            "1" -> makeCoffee(250, 0, 16, 4)
            "2" -> makeCoffee(350, 75, 20, 7)
            "3" -> makeCoffee(200, 100, 12, 6)
            "back" -> return
        }
    }

    private fun makeCoffee(water: Int, milk: Int, beans: Int, money: Int) {
        if (cups < 1) {
            println("Sorry, not enough cups!")
            return
        }
        if (this.water < water) {
            println("Sorry, not enough water!")
            return
        }
        if (this.milk < milk) {
            println("Sorry, not enough milk!")
            return
        }
        if (this.beans < beans) {
            println("Sorry, not enough beans!")
            return
        }
        println("I have enough resources, making you a coffee!")
        cups--
        this.water -= water
        this.milk -= milk
        this.beans -= beans
        this.money += money
    }

    private fun fillIngredients() {
        water += requestInput("Write how many ml of water you want to add:").toInt()
        milk += requestInput("Write how many ml of milk you want to add:").toInt()
        beans += requestInput("Write how many grams of coffee beans you want to add:").toInt()
        cups += requestInput("Write how many disposable cups you want to add:").toInt()
    }

    private fun takeMoney() {
        println("I gave you \$$money")
        money = 0
    }

    private fun printStatus() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$beans g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }

    private fun requestInput(prompt: String): String {
        println(prompt)
        return readln().trim().lowercase()
    }
}