package _scenarios



/**
Scenario: A system for managing a library has different types of items, such as books, magazines, and DVDs.
Each item has its own unique properties, such as title, author, publication date, etc.
The system needs to support different operations on these items, such as adding, removing, updating, and searching for items.
The system should also be extensible to support new types of items in the future.

Which design pattern do you think is most suitable for this scenario?
 * */



/*A more suitable design pattern for the given scenario is the Composite pattern. The Composite pattern allows you to
 represent a hierarchy of objects as a tree-like structure, where objects of different types can be treated uniformly.
  In the scenario described, the library items (books, magazines, DVDs) can be represented as components of
  a composite structure, where each item is a leaf node or a composite node.

  Operations such as adding, removing, updating, and searching for items can be implemented uniformly across
  the composite structure,regardless of the specific type of item.

*/



// Component
interface LibraryItem {
    fun display()
}

// Leaf
class Book(private val title: String, private val author: String) : LibraryItem {
    override fun display() {
        println("Book: $title by $author")
    }
}

// Leaf
class Magazine(private val title: String) : LibraryItem {
    override fun display() {
        println("Magazine: $title")
    }
}

// Leaf
class DVD(private val title: String, private val director: String) : LibraryItem {
    override fun display() {
        println("DVD: $title directed by $director")
    }
}

// Composite
class Library(private val name: String) : LibraryItem {
    private val items = mutableListOf<LibraryItem>()

    fun addItem(item: LibraryItem) {
        items.add(item)
    }

    fun removeItem(item: LibraryItem) {
        items.remove(item)
    }

    override fun display() {
        println("Library: $name")
        println("Items in the library:")
        for (item in items) {
            item.display()
        }
        println("End of library items")
    }
}

fun main() {
    // Create library items
    val book1 = Book("The Catcher in the Rye", "J.D. Salinger")
    val book2 = Book("To Kill a Mockingbird", "Harper Lee")
    val magazine1 = Magazine("National Geographic")
    val dvd1 = DVD("The Shawshank Redemption", "Frank Darabont")

    // Create library composite
    val library = Library("My Library")

    // Add items to the library
    library.addItem(book1)
    library.addItem(book2)
    library.addItem(magazine1)
    library.addItem(dvd1)

    // Display library items
    library.display()
}
