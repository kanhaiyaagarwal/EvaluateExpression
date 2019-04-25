package processor;

import exceptions.IllegalDataTypeForOperator;
import javafx.util.Pair;
import model.Expression;
import processor.operators.OperatorEvaluater;
import processor.operators.OperatorFactory;
import requests.UserRequest;

public final class ExpressionProcessor {

    public static boolean process(Expression expression, UserRequest request ) throws IllegalDataTypeForOperator {
        Pair<String,String> uservalue = request.getUserAttribues().get(expression.getKey());
        OperatorEvaluater evaluater = OperatorFactory.returnOperatorClass(expression.getOperator());
        return evaluater.evaluate(uservalue.getKey(), expression.getValue(), uservalue.getValue());
    }
}
