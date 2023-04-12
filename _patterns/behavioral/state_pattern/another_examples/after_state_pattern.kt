package _patterns.behavioral.state_pattern.another_examples

class GoodWorker{
    var currentBook : Book  = Book1(this )
    fun getNextBook(){
        currentBook.nextBook()
        println("getting $currentBook")
    }
}

abstract class Book(){
     abstract fun nextBook()
}

class Book1(private val goodWorker: GoodWorker):Book(){
    override fun nextBook() {
        goodWorker.currentBook = Book2(goodWorker)
    }

    override fun toString(): String {
        return "Zoo"
    }

}

class Book2(private val goodWorker: GoodWorker):Book(){
    override fun nextBook() {
        goodWorker.currentBook = Book3(goodWorker)
    }

    override fun toString(): String {
        return "Math"
    }

}

class Book3(private val goodWorker: GoodWorker):Book(){
    override fun nextBook() {
        goodWorker.currentBook = Book4(goodWorker)
    }

    override fun toString(): String {
        return "Science"
    }

}

class Book4(private val goodWorker: GoodWorker):Book(){
    override fun nextBook() {
        println("this is the last book")
    }

    override fun toString(): String {
        return "Arabic"
    }

}

fun main() {
    val goodWorker = GoodWorker()
    goodWorker.getNextBook()
    goodWorker.getNextBook()
    goodWorker.getNextBook()
}