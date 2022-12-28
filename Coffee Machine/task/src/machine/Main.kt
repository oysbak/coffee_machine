package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
    do {
        println(coffeeMachine)
        val input = readln().trim().lowercase()
        coffeeMachine.processInput(input)
    } while (input != "exit")
}