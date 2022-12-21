package machine

class CoffeeManager {
    fun start() {
        val coffeeMachine = CoffeeMachine()
        println("Write how many cups of coffee you will need:")
        val need = readln().toInt()
        val canMake = coffeeMachine.calculateNoOfCups()
        when (need.compareTo(canMake)) {
            -1 -> println("Yes, I can make that amount of coffee (and even ${canMake - need} more than that)")
            0 -> println("Yes, I can make that amount of coffee")
            1 -> println("No, I can make only $canMake cups of coffee")
        }
    }
}

/** Note that one cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans. */
const val WATER_RATIO = 200
const val MILK_RATIO = 50
const val BEANS_RATIO = 15

class CoffeeMachine {
    private val waterCompartment = IngredientCompartment(
        WATER_RATIO, requestInput("Write how many ml of water the coffee machine has:")
    )
    private val milkCompartment = IngredientCompartment(
        MILK_RATIO, requestInput("Write how many ml of milk the coffee machine has:")
    )
    private val beansCompartment = IngredientCompartment(
        BEANS_RATIO, requestInput("Write how many grams of coffee beans the coffee machine has:")
    )

    fun calculateNoOfCups() = waterCompartment.noOfCups().coerceAtMost(milkCompartment.noOfCups()).coerceAtMost(beansCompartment.noOfCups())
}

class IngredientCompartment(
    private val ratio: Int, private var level: Int

) {
    fun noOfCups() = level / ratio
}

fun requestInput(prompt: String): Int {
    println(prompt)
    return readln().toInt()
}