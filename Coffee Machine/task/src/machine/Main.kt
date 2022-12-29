package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
    do {
        println(coffeeMachine)
    } while (coffeeMachine.processInput(readln()))
}