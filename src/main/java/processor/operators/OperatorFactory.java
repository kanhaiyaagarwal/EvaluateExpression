package processor.operators;

import enums.Operators;

public final class OperatorFactory  {
    public static OperatorEvaluater returnOperatorClass(Operators operator){
        if (operator == Operators.GREATER_THAN){
            return new GreaterThanOperator();
        }
        if (operator == Operators.LESS_THAN){
            return new LessThanOperator();
        }
        return new DefaultOperator();
    }
}
