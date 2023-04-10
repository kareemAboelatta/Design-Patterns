package behavioral

interface TaxHolder{
    fun accept(visitor: VisitorA)
}

class House: TaxHolder{
    override fun accept(visitor: VisitorA) {
        visitor.visit(this)
    }

}

class Factory: TaxHolder{
    override fun accept(visitor: VisitorA) {
        visitor.visit(this)
    }

}

class Company : TaxHolder{
    override fun accept(visitor: VisitorA) {
        visitor.visit(this)
    }
}



class TaxCollectorCompany : TaxHolder {
    var taxHolders= arrayListOf<TaxHolder>()

    override fun accept(visitor: VisitorA) {
        taxHolders.forEach {
            it.accept(visitor)
        }
        visitor.visit(this)
    }

}







interface Visitor{
    fun visit(company: Company)
    fun visit(house: House)
    fun visit(factory: Factory)
    fun visit(taxCollectorCompany: TaxCollectorCompany)
}


class VisitorA: Visitor{
    var taxes=0
    override fun visit(company: Company) {
        taxes +=5
        println("Collected ${company.javaClass.simpleName} Taxes")
    }

    override fun visit(house: House) {
        taxes +=10
        println("Collected ${house.javaClass.simpleName} Taxes")
    }

    override fun visit(factory: Factory) {
        taxes +=15
        println("Collected ${factory.javaClass.simpleName} Taxes")
    }

    override fun visit(taxCollectorCompany: TaxCollectorCompany) {
        println("Taxes Collected = $taxes")
    }

}

fun main() {
    //Init Tax Holder
    var house = House()
    var company = Company()
    var factory = Factory()

    var listOfTaxHolder = arrayListOf(house,company,factory)

    //Init Tax Collector Company and VisitorA
    var taxCollectorCompany = TaxCollectorCompany()
    var visitor = VisitorA()

    taxCollectorCompany.taxHolders.addAll(listOfTaxHolder)

    taxCollectorCompany.accept(visitor)

}

/**
 * Visitor design pattern is a behavioral design pattern that allows adding new operations or behaviors to an object
 * structure without modifying the objects themselves. It defines a way to separate an algorithm from an
 * object structure on which it operates.

The Visitor pattern is useful in situations where you need to add new operations to an existing class hierarchy,
but don't want to modify that hierarchy. This pattern involves defining a separate object, called a visitor,

which can traverse the object hierarchy and perform operations on the objects.

The Visitor pattern consists of the following components:

-Visitor: an interface or an abstract class that defines the operations to be performed on elements of the object
structure.
-Concrete Visitor: implements the Visitor interface and provides an implementation for each operation defined in
the Visitor interface.

-Element: an interface or an abstract class that defines an accept() method that accepts a visitor.
-Concrete Element: implements the Element interface and provides an implementation for the accept() method.

-Object Structure: a collection of objects that provides the elements to be visited.




The Visitor pattern provides a way to add new operations to an object structure without changing the classes themselves.
This makes it easy to extend the functionality of an existing class hierarchy by adding new visitor classes. However,
the pattern can add some complexity to the code, and it can be difficult to maintain if the object structure
changes frequently.


 * */