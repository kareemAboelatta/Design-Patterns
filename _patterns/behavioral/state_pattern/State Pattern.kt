package _patterns.behavioral.state_pattern


// MusicPlayerState interface
interface MusicPlayerState {
    fun play()
    fun pause()
    fun stop()
}

// PlayingState class
class PlayingState(private val player: MusicPlayer) : MusicPlayerState {
    override fun play() {
        // do nothing (already playing)
    }

    override fun pause() {
        player.changeState(PausedState(player))
        println("allow to play now")
    }

    override fun stop() {
        player.changeState(StoppedState(player))
        println("allow to play now")

    }
}

// PausedState class
class PausedState(private val player: MusicPlayer) : MusicPlayerState {
    override fun play() {
        player.changeState(PlayingState(player))
        println("allow to stop or pause now")
    }

    override fun pause() {
        // do nothing (already paused)
    }

    override fun stop() {
        player.changeState(StoppedState(player))
        println("allow to play now")

    }
}

// StoppedState class
class StoppedState(private val player: MusicPlayer) : MusicPlayerState {
    override fun play() {
        player.changeState(PlayingState(player))
        println("MusicPlayer started, You are allowed to pause and stop now")
    }

    override fun pause() {
        // do nothing (not playing)
    }

    override fun stop() {
        // do nothing (already stopped)
    }
}

// MusicPlayer class
class MusicPlayer {
    private var currentState: MusicPlayerState = StoppedState(this)

    fun play() {
        currentState.play()
    }

    fun pause() {
        currentState.pause()
    }

    fun stop() {
        currentState.stop()
    }

    fun changeState(newState: MusicPlayerState) {
        println("Current State is :: ${newState.javaClass.simpleName}")
        currentState = newState
    }
}


fun main() {
    val player = MusicPlayer()


    while (true){
        val input = readLine()!!

        if (input == "play"){
            player.play()
        }else if (input == "stop"){
            player.stop()
        }else if (input == "pause"){
            player.pause()
        }else{
            break
        }
    }


}

/**
 * The state pattern is a _patterns.behavioral design pattern that allows an object to change its behavior when its internal state
 * changes. In this pattern, an object's behavior is encapsulated in a set of states, each of which represents
 * a different behavior. The object's behavior changes when its state changes.

The state pattern is used to model systems that can be in different states and need to behave differently depending on
their current state. The pattern is especially useful when there are complex conditional statements that determine
the behavior of an object. By encapsulating each state in a separate object, the state pattern allows for more flexible
and modular code.

In this pattern, a context object maintains a reference to a current state object. The context object's behavior is
delegated to the current state object. When the context object's state changes, it updates its reference to the current
state object, which changes its behavior accordingly.

The state pattern promotes loose coupling between the context object and its state objects. It also makes it easier to
add new states and modify the behavior of existing states without affecting the context object or other state objects.
 * */

/** programming scenario */

/**
* Let's say you're developing a music player app. The app has a "play" button that users can press to start playing
* a song. When the song is playing, the app shows a "pause" button that users can press to pause the song. When the song
*  is paused, the app shows a "play" button again that users can press to resume playing the song from where it left off.

In this scenario, you can use the State pattern to represent the different states of the music player (playing, paused,
*  stopped, etc.) as separate classes. Each state class can have its own implementation of
* methods like play(), pause(), and stop(), which define the behavior of the music player in that state.


* */


/**
 * when to use
 * when you have an object that behaves differently depending in its current state
 * */

/**
 * Pitfalls
 *- more Classes -> more code
 * */