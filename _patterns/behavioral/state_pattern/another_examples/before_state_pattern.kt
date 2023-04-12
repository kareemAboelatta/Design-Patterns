package _patterns.behavioral.state_pattern.another_examples

class Worker{
    var currentBook: String = "Zoo"

    fun getNextBook(){
        if (currentBook=="Zoo"){
            currentBook = "Math"
            println("Getting Math")
        }else if (currentBook == "Math"){
            currentBook = "Science"
            println("Getting Science")
        }else if (currentBook == "Science"){
            currentBook = "Arabic"
            println("Getting Arabic")
        }else if (currentBook == "Arabic"){
            currentBook = "English"
            println("Getting English")
        }
    }
}


fun main() {
  val worker = Worker()
  worker.getNextBook()
  worker.getNextBook()
  worker.getNextBook()
}







