package machine

class CoffeeMachine {
    private var water: Int = 400
    private var milk: Int = 540
    private var beans: Int = 120
    private var cups: Int = 9
    private var money: Int = 550
    private var state = State.IDLE

    private enum class State { IDLE, BUY, FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS }

    fun processInput(userInput: String): Boolean {
        when (state) {
            State.IDLE -> when (userInput) {
                "buy" -> state = State.BUY
                "fill" -> state = State.FILL_WATER
                "take" -> takeMoney()
                "remaining" -> printStatus()
                "exit" -> return false
            }

            State.BUY -> {
                when (userInput) {
                    "1" -> makeCoffee(250, 0, 16, 4)
                    "2" -> makeCoffee(350, 75, 20, 7)
                    "3" -> makeCoffee(200, 100, 12, 6)
                    "back" -> state = State.IDLE
                }
            }

            State.FILL_WATER -> {
                this.water += userInput.toInt()
                state = State.FILL_MILK
            }

            State.FILL_MILK -> {
                this.milk += userInput.toInt()
                state = State.FILL_BEANS
            }

            State.FILL_BEANS -> {
                this.beans += userInput.toInt()
                state = State.FILL_CUPS
            }

            State.FILL_CUPS -> {
                this.cups += userInput.toInt()
                state = State.IDLE
            }
        }
        return true
    }

    private fun makeCoffee(water: Int, milk: Int, beans: Int, money: Int) {
        state = State.IDLE
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

    override fun toString(): String {
        return when (state) {
            State.IDLE -> "Write action (buy, fill, take, remaining, exit):"
            State.BUY -> "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
            State.FILL_WATER -> "Write how many ml of water you want to add:"
            State.FILL_MILK -> "Write how many ml of milk you want to add:"
            State.FILL_BEANS -> "Write how many grams of coffee beans you want to add:"
            State.FILL_CUPS -> "Write how many disposable cups you want to add:"
        }
    }
}