package composite_design_pattern.solution_2_math_expression;

import static composite_design_pattern.solution_2_math_expression.OperationType.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************** Composite Design Pattern ******************************");

        /*
                expression - 2+(5*8)/4

                        +
                       / \
                      2   %
                         / \
                        *   4
                       / \
                      5   8

         */

        // create numbers.
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression five = new Number(5);
        ArithmeticExpression eight = new Number(8);
        ArithmeticExpression four = new Number(4);

        // create expressions.
        ArithmeticExpression multiply = new Expression(five, eight, MULTIPLY);
        ArithmeticExpression divide = new Expression(multiply, four, DIVIDE);
        ArithmeticExpression add = new Expression(two, divide, ADD);

        // evaluating the result.
        add.evaluate();


    }

}
