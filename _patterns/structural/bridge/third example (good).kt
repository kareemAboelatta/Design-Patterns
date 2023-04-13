package _patterns.structural.bridge

// Implementation
interface Workshop {
    fun work()
}

// Concrete Implementation
class AssembleWorkshop : Workshop {
    override fun work() {
        println("Assembling...")
    }
}

// Concrete Implementation
class ProduceWorkshop : Workshop {
    override fun work() {
        println("Producing...")
    }
}









// Abstraction
abstract class Vehicle(
    //workshop field in the Vehicle class, which acts as the "bridge" between the abstraction and implementation,
    protected val workshop: Workshop
) {
    abstract fun manufacture()
}

// Refined Abstraction
class Car(workshop: Workshop) : Vehicle(workshop) {
    override fun manufacture() {
        println("Manufacturing Car...")
        workshop.work()
    }
}

// Refined Abstraction
class Bike(workshop: Workshop) : Vehicle(workshop) {
    override fun manufacture() {
        println("Manufacturing Bike...")
        workshop.work()
    }
}


/**
 * يمكن للعميل إنشاء أنواع مختلفة من Vehicle مع workshop مختلفة ،

دون تغيير واجهة المركبات أو الورش.



 * يتم توصيل السيارة والورشة من خلال مجال ورشة العمل في فئة المركبات ، والتي تعمل بمثابة "جسر" بين التجريد والتنفيذ ،
 * السماح لهم بالتنوع بشكل مستقل. * /
 * */
fun main() {
    // Create a car with an assemble workshop
    val car = Car(AssembleWorkshop())
    car.manufacture()
    // Output:
    // Manufacturing Car...
    // Assembling...

    // Create a bike with a produce workshop
    val bike = Bike(ProduceWorkshop())
    bike.manufacture()
    // Output:
    // Manufacturing Bike...
    // Producing...
}
/*
* In this example, the Vehicle class represents the abstraction, and the Car and Bike classes represent the refined abstractions.
*  The Workshop interface represents the implementation, and the AssembleWorkshop and ProduceWorkshop classes represent the concrete implementations.
*
*
*
*  The Client can create different types of vehicles with different workshops for manufacturing, without changing the interface of the vehicles or workshops.
*  The Vehicle and Workshop are connected through the workshop field in the Vehicle class, which acts as the "bridge" between the abstraction and implementation,
*  allowing them to vary independently.*/