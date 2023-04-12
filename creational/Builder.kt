data class Sandwich(
    val bread: String,
    val meat: String,
    val cheese: String,
    val veggies: List<String>,
    val sauce: String
) {
    // Additional properties and methods specific to Sandwich
    // ...
}

class SandwichBuilder {
    private var bread: String = ""
    private var meat: String = ""
    private var cheese: String = ""
    private var veggies: MutableList<String> = mutableListOf()
    private var sauce: String = ""

    fun setBread(bread: String): SandwichBuilder {
        this.bread = bread
        return this
    }

    fun setMeat(meat: String): SandwichBuilder {
        this.meat = meat
        return this
    }

    fun setCheese(cheese: String): SandwichBuilder {
        this.cheese = cheese
        return this
    }

    fun addVeggies(veggies: List<String>): SandwichBuilder {
        this.veggies.addAll(veggies)
        return this
    }

    fun setSauce(sauce: String): SandwichBuilder {
        this.sauce = sauce
        return this
    }

    // Additional methods for setting other options or configurations of the sandwich
    // ...

    fun build(): Sandwich {
        return Sandwich(bread, meat, cheese, veggies.toList(), sauce)
    }
}

// Client
fun main() {
    val sandwich = SandwichBuilder()
        .setMeat("Turkey")
        .setCheese("Swiss")
        .addVeggies(listOf("Lettuce", "Tomato", "Onion"))
        .setSauce("Mayonnaise")
        .build()


    // Use the built Sandwich object
    println(sandwich)
}




/**
 * The Builder pattern is a creational design pattern that provides a way to construct complex objects step-by-step,
 * allowing for the creation of objects with different configurations or variations without requiring the creation of
 * multiple constructors or constructor parameters. It separates the construction of an object from its representation,
 * enabling the creation of objects with different combinations of properties in a flexible and organized manner.
 *
 *
 *
 *
Some key components of the Builder pattern are:
    -Product: Represents the object being built, typically a complex object with multiple properties or configurations.

    -Builder: Represents the builder class that is responsible for constructing the product.It contains methods for
             setting or configuring different properties of the product, and it may have a method for returning the final built object.

    -Director (optional): Represents an optional class that provides a higher-level interface for using the builder.
        It may be responsible for coordinating the construction process and calling the appropriate methods on the builder
        class to create the product. In some cases, the client may directly interact with the builder
        without the need for a director class.

    -Client: Represents the class or code that uses the builder to create objects. The client typically interacts with
    the builder by calling its methods to set or configure the properties of the product, and then calling the appropriate
    method to retrieve the final built object.
 * */






/**
 * Android Programming scenario

---> when want to show alertDialog in android maybe i wanna add some widget and in some cases i don't want it
     for example I don't wanna to add a message in  alertDialog

    //client
   fun showAlertDialog() {
      val alertDialog = AlertDialogBuilder()
        .setTitle("Alert!")
        .setMessage("This is an example of AlertDialog using Builder pattern.") in this case i will remove this line.
        .setPositiveButton("OK") { dialog, which -> /* Handle positive button click */ }
        .setNegativeButton("Cancel") { dialog, which -> /* Handle negative button click */ }
        .create()

// Show the created AlertDialog
alertDialog.show()
}
 * */