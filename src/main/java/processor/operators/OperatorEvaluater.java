package processor.operators;

import enums.Operators;
import exceptions.IllegalDataTypeForOperator;

public interface OperatorEvaluater {
    public boolean evaluate(String key, String value, String datatype) throws IllegalDataTypeForOperator;
}
