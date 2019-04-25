package processor.operators;


import exceptions.IllegalDataTypeForOperator;

public class GreaterThanOperator implements OperatorEvaluater{

    private String dataType = "Long";

    @Override
    public boolean evaluate(String key, String value, String datatype) throws IllegalDataTypeForOperator {
        if(datatype!=this.dataType)
            throw new IllegalDataTypeForOperator("Datatype : " + datatype  + " does not match : " + this.dataType);
        return  (Long.valueOf(key) > Long.valueOf(value));
    }
}
