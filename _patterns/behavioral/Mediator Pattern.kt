package _patterns.behavioral


interface AirCraft{
    fun notify(msg: String)
    fun requestLanding()
    /**
     * /// tell airPortTower that i will take of and let terminal empty
     * */
    fun notifyThisTakeOffSuccessfully()
}

interface AirPortTower{
    fun registerAirCraft(airCraft: AirCraft)
    fun requestLanding(airCraft: AirCraft)
    fun notifyAnAirCraftTakeOffSuccessfully()
}






class AirBus : AirCraft{
    private lateinit var airPortTower: AirPortTower

    fun setAirPortTower(airPortTower: AirPortTower){
        this.airPortTower = airPortTower
        airPortTower.registerAirCraft(this)
    }

    override fun notify(msg: String) {
        println("AirBus--->$msg")
    }

    override fun requestLanding() {
        airPortTower.requestLanding(this)
    }

    override fun notifyThisTakeOffSuccessfully() {
        airPortTower.notifyAnAirCraftTakeOffSuccessfully()
    }

}

class MiniAirBus : AirCraft{
    private lateinit var airPortTower: AirPortTower

    fun setAirPortTower(airPortTower: AirPortTower){
        this.airPortTower = airPortTower
        airPortTower.registerAirCraft(this)
    }

    override fun notify(msg: String) {
        println("MiniAirBus ---> $msg")
    }

    override fun requestLanding() {
        airPortTower.requestLanding(this)
    }

    override fun notifyThisTakeOffSuccessfully() {
        airPortTower.notifyAnAirCraftTakeOffSuccessfully()
    }
}

class NozhaTower : AirPortTower{
    private val registeredAirCrafts = arrayListOf<AirCraft>()
    var isTerminalEmpty = true
    private val towerName:String = "Nozha AirTower"

    override fun registerAirCraft(airCraft: AirCraft) {
        registeredAirCrafts.add(airCraft)
        println("$towerName : Register Success --> ${airCraft.javaClass.name}")
    }

    override fun requestLanding(airCraft: AirCraft) {
        if (isTerminalEmpty.not()){
            airCraft.notify("$towerName : terminal is busy, please wait..")
        }else{
            isTerminalEmpty = false
            airCraft.notify("$towerName okay you can land")
            registeredAirCrafts.forEach {     //tell all other airCrafts, an airCraft landed now
                if (it!= airCraft){
                    it.notify("$towerName : an airCraft in the terminal now ")
                }
            }
        }
    }

    override fun notifyAnAirCraftTakeOffSuccessfully() {
        isTerminalEmpty = true
        registeredAirCrafts.forEach {  //tell all airCrafts,an airCraft takes off and  Terminal is Empty now
            it.notify("Nozha Tower Terminal is Empty now..")
        }
    }

}

fun main() {


    val airBus = AirBus()
    val miniAirBus = MiniAirBus()
    val nozhaTower = NozhaTower()


    println("Register AirCrafts ....")
    airBus.setAirPortTower(nozhaTower)
    miniAirBus.setAirPortTower(nozhaTower)


    println()
    println("AirBus Requests Landing...")
    airBus.requestLanding() //and AirTower we tell other airCrafts "an airCraft in the terminal now."
    println("MiniAirBus Requests Landing...")
    miniAirBus.requestLanding()

    println()

    println("AirBus will take off Successfully ....")
    airBus.notifyThisTakeOffSuccessfully()

    println()

    println("MiniAirBus Requests landing again ....")
    miniAirBus.requestLanding()

    println()

    println("MiniAirBus will take off Successfully ....")
    miniAirBus.notifyThisTakeOffSuccessfully()




}




/**
 * Programming scenario
 * Chat-room // mediator (person1 , person2)
 * person3 request some one
*
* */


/**
 * Pitfalls
 * - creating one mediator for everything!!
 * - Used with other patters.
 *
 * */