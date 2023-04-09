package behavioral

import java.util.Stack

class Game(var playerName: String , var  playerScore :Int){
    fun save() : CheckPoint {
        return CheckPoint(playerName, playerScore)
    }
    fun upgrade(){
        playerScore++
    }
    fun revert(checkPoint: CheckPoint){
        this.playerName=checkPoint.playerName
        this.playerScore=checkPoint.playerScore
    }
}

data class CheckPoint(
    val playerName: String,
    val playerScore: Int
)

class CareTaker{
    private val stack= Stack<CheckPoint>()

    fun saveGame(game: Game){
        stack.push(game.save())
    }

    fun revert(game: Game){
        game.revert(stack.pop())
    }
}

fun main() {
    val game = Game("Kareem",10)
    val careTaker = CareTaker()

    game.upgrade() //now im in level 11

    //save Cmd+s too save my state
    careTaker.saveGame(game = game)

    game.upgrade()//my level increased to 12 but i forget to save my state when im back (revert my current state will be removed)

    println("Before undo --> ${game.playerScore}")

    careTaker.revert(game)
    println("After undo --> ${game.playerScore}")
}