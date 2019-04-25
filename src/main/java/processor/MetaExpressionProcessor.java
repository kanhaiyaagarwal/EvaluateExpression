package processor;

import enums.MetaExpressionOperator;
import exceptions.IllegalDataTypeForOperator;
import model.Feature;
import model.MetaExpression;
import requests.UserRequest;

public final class MetaExpressionProcessor {

    public static boolean processMetaExpression(MetaExpression metaExpression, UserRequest request, Feature feature)
        throws IllegalDataTypeForOperator {
        if (metaExpression == null || request == null || feature == null) {
            return false;
        }

        if (metaExpression.isExpression()) {
            return ExpressionProcessor.process(metaExpression.getExpression(), request);
        }
        boolean exp1 = MetaExpressionProcessor
            .processMetaExpression(metaExpression.getMetaExpression1(), request, feature);
        boolean exp2 = MetaExpressionProcessor
            .processMetaExpression(metaExpression.getMetaExpression2(), request, feature);
        return processMetaOperator(exp1, exp2, metaExpression.getOperator());

    }

    public static boolean processMetaOperator(boolean exp1, boolean exp2, MetaExpressionOperator operator) {
        if (operator == MetaExpressionOperator.OR) {
            return exp1 || exp2;
        }
        if (operator == MetaExpressionOperator.AND) {
            return exp1 && exp2;
        }
        if (operator == MetaExpressionOperator.NOT) {
            return !exp1;
        }
        return exp1||exp2;
    }
}
