package machine

class CoffeeManager {
    fun start() {
        println("Write how many cups of coffee you will need:")
        val amount = readln().toInt()
        println("For $amount cups of coffee you will need:")
        println("${calculateWater(amount)} ml of water")
        println("${calculateMilk(amount)} ml of milk")
        println("${calculateBeans(amount)} g of coffee beans")
    }

    private fun calculateWater(noOfCups: Int) = noOfCups * 200
    private fun calculateMilk(noOfCups: Int) = noOfCups * 50
    private fun calculateBeans(noOfCups: Int) = noOfCups * 15
}