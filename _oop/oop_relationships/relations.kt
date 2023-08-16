package _oop.oop_relationships

data class PersonalInfo(
    val firstName: String,
    val lastName: String,
    val nationality: String,
    val yearOfBirth: Int,
)

data class Department(
    val deptName: String,
    val deptNumber: Number,
)

data class Task(
    val taskName: String,
    val taskDuration: Int
)


class Employee(
    var id: Int = 0,
    var salary: Double = 0.0,
    var personalInfo: PersonalInfo,//relationship (composite) or aggregation -- in meaning because it impossible to found without personalInfo
    var department: Department?,// relationship composite or (aggregation) -- -- in meaning because it possible to found without a department
) {



    /** Not now personalInfo can be aggregation or composition but not be Association because we already have an instance */
    constructor(
        id: Int,
        salary: Double,
        firstName: String,
        lastName: String,
        nationality: String,
        yearOfBirth: Int,
        department: Department?
    ) : this(id, salary, PersonalInfo(firstName, lastName, nationality, yearOfBirth), department)


    fun doTask(task: Task) {
        //...executing this task
    }
}


fun main() {


    // Employee <--> Department   | Aggregation
    // now relationship between department and employee is not full Composition It's just aggregation
    // because if we delete the employee1  the instance of department inside it will NOT be deleted too and this is so not - so strong relationship between them
    val department = Department(
        deptName = "Mobile Development",
        deptNumber = 2
    )
    val employee1 = Employee(
        id = 1,
        salary = 4000.0,
        personalInfo = PersonalInfo(firstName = "Kareem", "Aboelatta", nationality = "Egyptian", 2000),
        department = department
    )




    // Employee <--> PersonalInfo   | Composition
    // now relationship between personalInfo and employee is composition relationship
    // because if we delete the employee2  the instance of personalInfo inside it will be deleted too and this is so strong relationship between them
    val employee2 = Employee(
        id = 1,
        salary = 4000.0,
        firstName = "kareem",
        lastName = "Kamal",
        nationality = "American",
        yearOfBirth = 1999,
        department = null
    )





    // Employee <--> Task | Association
    // now relationship between employee and task is Association relationship because the relation is not strong between them
    // in programming because Employee don't have any Task instance as attribute
    val employee3 = Employee(
        id = 1,
        salary = 4000.0,
        firstName = "kareem",
        lastName = "Kamal",
        nationality = "American",
        yearOfBirth = 1999,
        department = null
    )

    val task = Task(taskName = "Eating", taskDuration = 30)
    employee3.doTask(task = task)


}
























