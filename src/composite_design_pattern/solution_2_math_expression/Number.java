package composite_design_pattern.solution_2_math_expression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Number implements ArithmeticExpression {

    private double number;
    @Override
    public double evaluate() {
        return number;
    }

}
