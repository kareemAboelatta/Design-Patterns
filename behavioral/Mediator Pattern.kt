package behavioral


interface AirCraft{
    fun notify(msg: String)
    fun requestLanding()
    fun notifySuccess()
}

interface AirPortTower{
    fun registerAirCraft(airCraft: AirCraft)
    fun requestLanding(airCraft: AirCraft)
    fun notifySuccess()
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

    override fun notifySuccess() {
        airPortTower.notifySuccess()
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

    override fun notifySuccess() {
        airPortTower.notifySuccess()
    }
}

class NozhaTower : AirPortTower{
    val registeredAirCrafts = arrayListOf<AirCraft>()
    var isTerminalEmpty = true
    val towerName:String = "Nozha AirTower"
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
            registeredAirCrafts.forEach {
                if (it!= airCraft){
                    it.notify("$towerName : An aircraft will land soon   ")
                }
            }
        }
    }

    override fun notifySuccess() {
        isTerminalEmpty = true
        registeredAirCrafts.forEach {
            it.notify("Nozha Tower Tirminal is Empty now..")
        }
    }

}

fun main() {
    val airBus1 = AirBus()
    val miniAirBus1 = MiniAirBus()
    val nozhaTower = NozhaTower()


    println("Register AirCrafts ....")
    airBus1.setAirPortTower(nozhaTower)
    miniAirBus1.setAirPortTower(nozhaTower)

    println("AirBus1 Requests Landing...")
    airBus1.requestLanding()
    println("MiniAirBus1 Requests Landing...")
    miniAirBus1.requestLanding()


    println("AirBus Landed Successfully ....")
    airBus1.notifySuccess()


    println("MiniAirBus1 Requests landing again ....")
    miniAirBus1.requestLanding()


    println("MiniAirBus1 Landed Successfully ....")
    miniAirBus1.notifySuccess()




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