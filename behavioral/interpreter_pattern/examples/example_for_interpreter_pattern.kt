package behavioral.interpreter_pattern.examples

import behavioral.interpreter_pattern.AndExpression
import behavioral.interpreter_pattern.OrExpression
import behavioral.interpreter_pattern.TerminalExpression
import java.lang.ArithmeticException
import java.util.Stack


// Expression interface
interface Expression {
    fun evaluate(): Int
}

// NumberExpression class
class NumberExpression(private val number: Int) : Expression {
    override fun evaluate(): Int {
        return number
    }
}


// AdditionExpression class
class AdditionExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun evaluate(): Int {
        return left.evaluate() + right.evaluate()
    }
}

// Subtraction Expression class
class SubtractionExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun evaluate(): Int {
        return left.evaluate() - right.evaluate()
    }
}

// MultiplicationExpression class
class MultiplicationExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun evaluate(): Int {
        return left.evaluate() * right.evaluate()
    }
}

// DivideExpression class
class DivideExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun evaluate(): Int {
        return left.evaluate() / right.evaluate()
    }
}

class Interpreter {
    companion object {

        fun handleExpression(expression: String ="2+3*4-3/2+1"):Expression{
            val stack = Stack<NumberExpression>()

            var currentIndex=0
            for (char in expression){
                if (char.isDigit()){
                    stack.push(NumberExpression(Character.getNumericValue(char)))
                    if (currentIndex == expression.length-1){
                        return stack.pop()
                    }
                }else if (char =='/'){
                    return DivideExpression(left = stack.pop(),right = handleExpression(expression.substring(startIndex = currentIndex+1)))
                }else if (char =='*'){
                    return MultiplicationExpression(left = stack.pop(),right = handleExpression(expression.substring(startIndex = currentIndex+1)))
                }else if (char == '+'){
                    return AdditionExpression(left = stack.pop(), right = handleExpression(expression.substring(startIndex = currentIndex+1)))
                }else if (char == '-'){
                    return SubtractionExpression(left = stack.pop(), right = handleExpression(expression.substring(startIndex = currentIndex+1)))
                }

                currentIndex++
            }

            throw ArithmeticException()
        }


    }
}


fun main() {

    val expression ="2+3*4-2"
    val num= Interpreter.handleExpression(expression)
    println("result = "+num.evaluate())



}







/*
fun handleExpression(expression: String ="2+3*4-2/2"):Expression{
    var currentIndex = 0
    var leftExpression: Expression? = null
    var currentOperator: Char? = null

    while (currentIndex < expression.length) {
        val char = expression[currentIndex]
        if (char.isDigit()) {
            val num = Character.getNumericValue(char)
            val numExpr = NumberExpression(num)
            if (leftExpression == null) {
                leftExpression = numExpr
            } else if (currentOperator == '*') {
                leftExpression = MultiplicationExpression(leftExpression, numExpr)
                currentOperator = null
            } else if (currentOperator == '/') {
                leftExpression = DivideExpression(leftExpression, numExpr)
                currentOperator = null
            } else if (currentOperator == '+') {
                return AdditionExpression(leftExpression, handleExpression(expression.substring(currentIndex)))
            } else if (currentOperator == '-') {
                return SubtractionExpression(leftExpression, handleExpression(expression.substring(currentIndex)))
            } else {
                throw ArithmeticException()
            }
        } else if (char == '+' || char == '-' || char == '*' || char == '/') {
            currentOperator = char
        }
        currentIndex++
    }

    return leftExpression ?: throw ArithmeticException()
}
*/



