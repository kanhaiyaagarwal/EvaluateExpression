package processor.operators;

import exceptions.IllegalDataTypeForOperator;
import lombok.Data;

@Data
public class DefaultOperator implements OperatorEvaluater{

    @Override
    public boolean evaluate(String key, String value, String datatype) throws IllegalDataTypeForOperator {
        return false;
    }
}
