package behavioral.interpreter_pattern
import java.util.StringTokenizer


interface Expression {
    fun interpret(context: String): Boolean
}

class TerminalExpression(private val data: String) : Expression {
    override fun interpret(context: String): Boolean {
        val st = StringTokenizer(context)
        while (st.hasMoreTokens()) {
            val test = st.nextToken()
            if (test == data) {
                return true
            }
        }
        return false
    }
}

class OrExpression(private val expr1: Expression, private val expr2: Expression) : Expression {
    override fun interpret(context: String): Boolean {
        return expr1.interpret(context) or expr2.interpret(context)
    }
}

class AndExpression(private val expr1: Expression, private val expr2: Expression) : Expression {
    override fun interpret(context: String): Boolean {
        return expr1.interpret(context) and expr2.interpret(context)
    }
}


class Interpreter {
    companion object {

        fun buildInterpreterTree(): Expression {
            val hasAbo = TerminalExpression("AboElatta")
            val hasSmallAbo = TerminalExpression("aboElatta")
            val hasSmallAboElatta = TerminalExpression("aboelatta")


            val hasKamal = TerminalExpression("kamal")    // his father name is kamal

            val hasAboElatta1 = OrExpression(hasAbo, hasSmallAbo)
            val hasAboElatta = OrExpression(hasAboElatta1, hasSmallAboElatta) // from aboElatta family

            return AndExpression(hasKamal, hasAboElatta)
        }

    }
}

fun main() {
    val name = "mohamed kamal mohamed ahmed ahmed aboelatta"
    val mama = Interpreter.buildInterpreterTree()
    println("is brother of me  ${mama.interpret(name)}")
}


//same program
/*

fun main() {
    val name = "swa kamal mohamed ahmed ahmed Aboelatta"
    val pattern = Pattern.compile(".*kamal.*(aboelatta|aboelatta|aboelatta)$", Pattern.CASE_INSENSITIVE)


    if (pattern.matcher(name).find()){
        println("is your brother")
    }else{
        println("is not your brother")
    }

}
*/


/**
 *The Interpreter pattern is a behavioral design pattern that provides a way to evaluate language grammar or expressions. It defines a representation for the grammar of a language and provides an interpreter that can parse the input and evaluate it.

The basic idea behind the Interpreter pattern is to create a class hierarchy that represents the grammar rules of a language. Each non-terminal symbol in the grammar is represented by a separate class, while each terminal symbol is represented by a method in the non-terminal classes.

When a client provides an input expression, the interpreter parses the expression and builds an abstract syntax tree (AST). The interpreter then traverses the AST and evaluates the expression by invoking methods on the non-terminal classes, which in turn may invoke methods on other non-terminal classes or on terminal symbols.

The Interpreter pattern can be useful in situations where you need to interpret a custom language or grammar, such as when building a query language or when processing input in a specific format. However, it can also be complex to implement and can result in a lot of class hierarchy and code.
 * */


/**
 * When to use ?
 * Representing grammar of a language (Music, Formula, mathematics)
 * Domain Specification Language like  'SQL' because it not a programming language
 * */


/**
 *pitfalls
 *
 * Complexity of grammar not easy to use
 * Used in specific situations
 * */


// Design Patterns: Interpreter Pattern (Arabic)
// video link:https://www.youtube.com/watch?v=zakCZEVGgJU&list=PLd-dOEgzBpGnt3GuEszo_piQq52XSqAmj&index=4
