package _patterns.creational

/**
 * The Object Pool pattern is a _patterns.creational design pattern that manages a pool of objects and allows clients to
 * request and release objects from the pool, rather than creating new objects from scratch. This pattern can be useful
 * in scenarios where creating objects is expensive in terms of time or resources, and reusing existing objects
 * can improve performance and efficiency.
 * */


/**
 * Here's an example of the Object Pool pattern in Kotlin, using a scenario where we have a Connection class that
 * represents a database connection, and we want to manage a pool of Connection objects to avoid the overhead of
 * creating and closing database.
 * */
class Connection {
    // Simulating a database connection
    fun connect() {
        println("Connecting to database...")
    }

    fun query(sql: String): String {
        println("Executing query: $sql")
        return "Result of query: $sql"
    }

    fun disconnect() {
        println("Disconnecting from database...")
    }
}


class ConnectionPool(private val maxSize: Int) {
    private val connections = mutableListOf<Connection>()

    init {
        for (i in 1..maxSize) {
            connections.add(Connection())
        }
    }

    fun getConnection(): Connection {
        if (connections.isEmpty()) {
            println("No connections available. Creating a new connection.")
            return Connection()
        } else {
            println("Getting a connection from the pool.")
            return connections.removeAt(0)
        }
    }

    fun releaseConnection(connection: Connection) {
        if (connections.size < maxSize) {
            println("Releasing a connection back to the pool.")
            connections.add(connection)
        } else {
            println("Connection pool is full. Closing the connection.")
            connection.disconnect()
        }
    }

    fun getSize(): Int {
        return connections.size
    }
}


fun main() {
    val connectionPool = ConnectionPool(5)

    // Get connections from the pool   it will remove it form the pool
    val connection1 = connectionPool.getConnection()
    val connection2 = connectionPool.getConnection()
    val connection3 = connectionPool.getConnection()


    println("--->connectionPool size: ${connectionPool.getSize()}")


    // Release connections back to the pool
    connectionPool.releaseConnection(connection1)
    connectionPool.releaseConnection(connection2)
    connectionPool.releaseConnection(connection3)

    println("--->connectionPool size: ${connectionPool.getSize()}")


    // Get more connections from the pool
    val connection4 = connectionPool.getConnection()
    val connection5 = connectionPool.getConnection()

    println("--->connectionPool size: ${connectionPool.getSize()}")


    // Close excess connections
    connectionPool.releaseConnection(connection4)
    connectionPool.releaseConnection(connection5)

    println("--->connectionPool size: ${connectionPool.getSize()}")

}


/**
 * Amazing
 * Another Programming scenario in android
 *Let's say you are developing a media player application that needs to manage a pool of MediaPlayer objects to
 * play audio files.
 *
 *  Creating and releasing MediaPlayer objects frequently can be expensive in terms of system resources, and it may result
 *  in poor performance or even crashes in the application. To avoid these issues, you can use the Object Pool pattern
 *  to manage a pool of MediaPlayer objects, allowing for efficient reuse of objects and reducing the overhead
 *  of creating and releasing MediaPlayer objects.
 *
 * '''
 * import android.media.MediaPlayer

class MediaPlayerPool(private val maxSize: Int) {
private val mediaPlayerPool = mutableListOf<MediaPlayer>()

    init {
        for (i in 1..maxSize) {
            mediaPlayerPool.add(MediaPlayer())
        }
    }

    fun getMediaPlayer(): MediaPlayer? {
        if (mediaPlayerPool.isEmpty()) {
            println("No MediaPlayer objects available. Creating a new MediaPlayer.")
            return MediaPlayer()
        } else {
            println("Getting a MediaPlayer from the pool.")
            return mediaPlayerPool.removeAt(0)
        }
    }

    fun releaseMediaPlayer(mediaPlayer: MediaPlayer) {
        if (mediaPlayerPool.size < maxSize) {
            println("Releasing a MediaPlayer back to the pool.")
            mediaPlayer.reset()
            mediaPlayerPool.add(mediaPlayer)
        } else {
            println("MediaPlayer pool is full. Releasing the MediaPlayer.")
            mediaPlayer.reset()
            mediaPlayer.release()
        }
    }

    fun getSize(): Int {
        return mediaPlayerPool.size
    }
}

fun main() {
    val mediaPlayerPool = MediaPlayerPool(5)

    // Get MediaPlayers from the pool
    val mediaPlayer1 = mediaPlayerPool.getMediaPlayer()
    val mediaPlayer2 = mediaPlayerPool.getMediaPlayer()
    val mediaPlayer3 = mediaPlayerPool.getMediaPlayer()

    // Release MediaPlayers back to the pool
    mediaPlayerPool.releaseMediaPlayer(mediaPlayer1!!)
    mediaPlayerPool.releaseMediaPlayer(mediaPlayer2!!)
    mediaPlayerPool.releaseMediaPlayer(mediaPlayer3!!)

    // Get more MediaPlayers from the pool
    val mediaPlayer4 = mediaPlayerPool.getMediaPlayer()
    val mediaPlayer5 = mediaPlayerPool.getMediaPlayer()

    // Release excess MediaPlayers
    mediaPlayerPool.releaseMediaPlayer(mediaPlayer4!!)
    mediaPlayerPool.releaseMediaPlayer(mediaPlayer5!!)
}

 * '''
 * */
