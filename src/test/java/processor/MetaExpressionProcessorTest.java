package processor;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import enums.MetaExpressionOperator;
import enums.Operators;
import exceptions.IllegalDataTypeForOperator;
import javafx.util.Pair;
import model.Expression;
import model.Feature;
import model.MetaExpression;
import requests.UserRequest;

public class MetaExpressionProcessorTest {

    @Test
    public void processMetaExpression() {
        //init expressions
        Expression expression = new Expression("order", Operators.GREATER_THAN, "100" );
        Expression expression1 = new Expression("order", Operators.LESS_THAN, "1000" );
        //init MetaExpression
        MetaExpression metaExpression = new MetaExpression(expression, null, null, null, true);
        MetaExpression metaExpression1 = new MetaExpression(expression1, null, null, null, true);
        MetaExpression metaExpression2 = new MetaExpression(null, metaExpression, metaExpression1, MetaExpressionOperator.AND, false);

        //init feature
        Feature feature = new Feature("foo");

        //init request
        HashMap<String, Pair<String, String>> map = new HashMap<>();
        map.put("order", new Pair<>("101", "Long"));
        UserRequest userRequest = new UserRequest(map);

        try {
            boolean outval = MetaExpressionProcessor.processMetaExpression(metaExpression2, userRequest, feature);
            System.out.println(outval);
        } catch (IllegalDataTypeForOperator illegalDataTypeForOperator) {
            illegalDataTypeForOperator.printStackTrace();
        }
    }

    @Test
    public void catchMetaExpressionException() {
        //init expressions
        Expression expression = new Expression("order", Operators.GREATER_THAN, "100" );
        Expression expression1 = new Expression("order", Operators.LESS_THAN, "1000" );
        //init MetaExpression
        MetaExpression metaExpression = new MetaExpression(expression, null, null, null, true);
        MetaExpression metaExpression1 = new MetaExpression(expression1, null, null, null, true);
        MetaExpression metaExpression2 = new MetaExpression(null, metaExpression, metaExpression1, MetaExpressionOperator.AND, false);

        //init feature
        Feature feature = new Feature("foo");

        //init request
        HashMap<String, Pair<String, String>> map = new HashMap<>();
        //Data type is wrong for this user
        map.put("order", new Pair<>("1001", "String"));
        UserRequest userRequest = new UserRequest(map);

        try {
            boolean outval = MetaExpressionProcessor.processMetaExpression(metaExpression2, userRequest, feature);
            System.out.println(outval);
        } catch (IllegalDataTypeForOperator illegalDataTypeForOperator) {
            illegalDataTypeForOperator.printStackTrace();
        }
    }
}