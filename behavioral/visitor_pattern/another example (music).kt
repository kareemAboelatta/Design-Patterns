package behavioral.visitor_pattern

/**
 * Another programming scenario
 * Let's say you are developing a music library application that allows users to import and manage their music collection.
 * You have implemented a class hierarchy for different types of music files, such as MP3, WAV, FLAC, etc.,
 * each represented by a separate class.
 * You also have a class hierarchy for music metadata, such as artist, album,
 * and song title, each represented by a separate class.

You now want to implement a feature that allows users to export their music collection to different formats,
such as CSV, JSON, and XML. Instead of implementing a separate export method in each music file and metadata class,
you decide to use the Visitor pattern to achieve this.
 * */

interface MusicVisitor {
    fun visit(mp3: MP3)
    fun visit(wav: WAV)
    fun visit(flac: FLAC)
    fun visit(artist: Artist)
    fun visit(album: Album)
    fun visit(song: Song)
}






class CSVVisitor : MusicVisitor {
    override fun visit(mp3: MP3) {
        println("Exporting MP3 metadata to CSV")
    }

    override fun visit(wav: WAV) {
        println("Exporting WAV metadata to CSV")
    }

    override fun visit(flac: FLAC) {
        println("Exporting FLAC metadata to CSV")
    }

    override fun visit(artist: Artist) {
        println("Exporting artist metadata to CSV")
    }

    override fun visit(album: Album) {
        println("Exporting album metadata to CSV")
    }

    override fun visit(song: Song) {
        println("Exporting song metadata to CSV")
    }
}

class JSONVisitor : MusicVisitor {
    override fun visit(mp3: MP3) {
        println("Exporting MP3 metadata to JSON")
    }

    override fun visit(wav: WAV) {
        println("Exporting WAV metadata to JSON")
    }

    override fun visit(flac: FLAC) {
        println("Exporting FLAC metadata to JSON")
    }

    override fun visit(artist: Artist) {
        println("Exporting artist metadata to JSON")
    }

    override fun visit(album: Album) {
        println("Exporting album metadata to JSON")
    }

    override fun visit(song: Song) {
        println("Exporting song metadata to JSON")
    }
}

class XMLVisitor : MusicVisitor {
    override fun visit(mp3: MP3) {
        println("Exporting MP3 metadata to XML")
    }

    override fun visit(wav: WAV) {
        println("Exporting WAV metadata to XML")
    }

    override fun visit(flac: FLAC) {
        println("Exporting FLAC metadata to XML")
    }

    override fun visit(artist: Artist) {
        println("Exporting artist metadata to XML")
    }

    override fun visit(album: Album) {
        println("Exporting album metadata to XML")
    }

    override fun visit(song: Song) {
        println("Exporting song metadata to XML")
    }
}







interface Music {
    fun accept(visitor: MusicVisitor)
}

class MP3 : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

class WAV : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

class FLAC : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

class Artist : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

class Album : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

class Song : Music {
    override fun accept(visitor: MusicVisitor) {
        visitor.visit(this)
    }
}

fun main() {
    // Create some sample music files and metadata
    val mp3 = MP3()
    val wav = WAV()
    val flac = FLAC()
    val artist = Artist()
    val album = Album()
    val song = Song()

    // Create a list of music elements
    val musicElements: List<Music> = listOf(mp3, wav, flac, artist, album, song)

    // To export the music collection to CSV I will use CSVVisitor
    val csvVisitor = CSVVisitor()
    for (element in musicElements) {
        element.accept(csvVisitor)
    }

    // To export the music collection to JSON I will use JSONVisitor
    val jsonVisitor = JSONVisitor()
    for (element in musicElements) {
        element.accept(jsonVisitor)
    }

    // To export the music collection to XML I will use XMLVisitor
    val xmlVisitor = XMLVisitor()
    for (element in musicElements) {
        element.accept(xmlVisitor)
    }
}