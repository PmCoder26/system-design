package composite_design_pattern.solution_2_math_expression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Expression implements ArithmeticExpression {

    private ArithmeticExpression leftExpression;
    private ArithmeticExpression rightExpression;
    OperationType operation;

    @Override
    public double evaluate() {
        double value = 0;
        switch (operation) {
            case ADD -> value = leftExpression.evaluate() + rightExpression.evaluate();
            case SUBTRACT -> value = leftExpression.evaluate() - rightExpression.evaluate();
            case MULTIPLY -> value = leftExpression.evaluate() * rightExpression.evaluate();
            case DIVIDE -> value = leftExpression.evaluate() / rightExpression.evaluate();
        }
        System.out.println("Expression evaluation: " + value);
        return value;
    }
}
