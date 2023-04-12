package _patterns.behavioral

import java.util.Stack

class CompanyARepository : Iterable<String> {
    private var employees = arrayOfNulls<String>(10)
    private var index = 0

    init {
        addEmployee("kareem Kamal")
        addEmployee("Youssef Samir")
        addEmployee("Ahmed Kamel")
    }

    private fun addEmployee(employee: String) {
        if (index == employees.size) {
            var largerListOfEmployees: Array<String?>? = arrayOfNulls<String>(employees.size + 5)
            System.arraycopy(employees, 0, largerListOfEmployees, 0, employees.size)
            employees = largerListOfEmployees!!
            largerListOfEmployees = null
        }
        employees[index] = employee
        index++
    }

    override fun iterator(): Iterator<String> {
        return object : Iterator<String> {
            private var currentIndex = 0
            override fun hasNext(): Boolean {
                return currentIndex < employees.size && employees[currentIndex] != null
            }

            override fun next(): String {
                return employees[currentIndex++]!!
            }

        }
    }


}

class CompanyBRepository : Iterable<String> {
    private var employees = Stack<String>()
    init {
        addEmployee("Abo Elkhiur")
        addEmployee("Ahmed Ebrahim")
    }

    fun addEmployee(employee: String) {
        employees.push(employee)
    }

    override fun iterator(): Iterator<String> {
        return object : Iterator<String> {
            private var currentIndex = 0
            override fun hasNext(): Boolean {
                if (currentIndex < employees.size)
                    return true
                return false
            }

            override fun next(): String {
                return employees.pop()
            }

        }
    }

}

class CompanyCRepository : Iterable<String> {
    private var employees = arrayListOf<String>("Youssef","Belal")

    override fun iterator(): Iterator<String> {
        return object : Iterator<String> {
            private var currentIndex = 0
            override fun hasNext(): Boolean {
                if (currentIndex < employees.size)
                    return true
                return false
            }

            override fun next(): String {
                return employees[currentIndex++]
            }

        }
    }

}

class CompanyDRepository : Iterable<String> {
    private var employees =  mutableSetOf("adam", "yossef", "3id")

    override fun iterator(): Iterator<String> {
        return object : Iterator<String> {
            private var currentIndex = 0
            override fun hasNext(): Boolean {
                if (currentIndex < employees.size)
                    return true
                return false
            }

            override fun next(): String {
                return employees.elementAt(currentIndex++)
            }

        }
    }

}



// Client (manager)  of all companies don't care how to get data from each one
fun main() {
    val companyARepository = CompanyARepository()
    val companyBRepository = CompanyBRepository()
    val companyCRepository = CompanyCRepository()
    val companyDRepository = CompanyDRepository()


    companyARepository.forEach {
        println(it)
    }

    companyBRepository.forEach {
        println(it)
    }

    companyCRepository.forEach {
        println(it)
    }
    companyDRepository.forEach {
        println(it)
    }



}


/**
 * When to use ?
 * Provide a way to access the element of an aggregate object sequentially without  exposing its underlying
 * representation
 *
 *
 * Company A store his employees in arrayList,
 * Company B store his employees in normal array
 * and Company C store his employees in set or stack
 * I don't care
 * */


/**
*
 * Pitfalls
 * - No access to index of the collection
 * - Unidirectional
 * - Sometimes it's slower than using an index and looping through it.
 *
* */

//Design Patterns: Iterator Pattern (Arabic)
//link : youtube.com/watch?v=ZZBTSAlhim4&list=PLd-dOEgzBpGnt3GuEszo_piQq52XSqAmj&index=7


