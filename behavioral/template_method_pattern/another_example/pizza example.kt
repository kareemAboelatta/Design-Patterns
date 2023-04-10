package behavioral.template_method_pattern.another_example

abstract class MakePizzaAlgorithm{

    private  fun bakePizza(){
        println("Baking Pizza....")
    }

    abstract fun definePizzaShape()

    private fun putAddons(){
        println("Putting pizza addons ....")
    }

    private fun heatPizza(){
        println("Heating Pizza ....")
    }


    fun makePizza(){
        bakePizza()
        definePizzaShape()
        putAddons()
        heatPizza()
    }

}

class MakeRoundedPizza : MakePizzaAlgorithm() {
    override fun definePizzaShape() {
        println("Making the Pizza rounded")
    }
}

class MakeCirclePizza : MakePizzaAlgorithm() {
    override fun definePizzaShape() {
        println("Making the Pizza Circle")
    }
}


fun main() {
    val order1 = MakeRoundedPizza()
    order1.makePizza()

    println("-------------------------------")
    val order2 = MakeCirclePizza()
    order2.makePizza()


}