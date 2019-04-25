package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import enums.MetaExpressionOperator;
import enums.Operators;
import model.Expression;
import model.MetaExpression;

public final class ConstructExpression {

    public static HashMap<String, Operators> operatorsMap;
    public static HashMap<String, MetaExpressionOperator> metaOperatorsMap;

    //we would read this from configs
    public static void initMaps(){

        //initializing operators maps
        operatorsMap = new HashMap<>();
        operatorsMap.put(">", Operators.GREATER_THAN);
        operatorsMap.put("<", Operators.LESS_THAN);
        operatorsMap.put("=", Operators.STRING_EQUALS);

        //initializing metaOperators maps
        metaOperatorsMap = new HashMap<>();
        metaOperatorsMap.put("&&", MetaExpressionOperator.AND);
        metaOperatorsMap.put("||", MetaExpressionOperator.OR);
    }

    public static MetaExpression constructMetaExpression(String str) {
        MetaExpression metaExpression = new MetaExpression();
        String[] strList = str.split(" ");
        Stack<String> expStack = new Stack<>();
        Expression exp;
        exp = new Expression();
        exp.setKey(strList[0]);
        exp.setOperator(operatorsMap.get(strList[1]));
        exp.setValue(strList[2]);
        for(int i=3; i< strList.length ;){
            if(metaOperatorsMap.containsKey(strList[i])){

            }
            exp = new Expression();
            exp.setKey(strList[i]);
            exp.setOperator(operatorsMap.get(strList[i+1]));
            exp.setValue(strList[i+2]);
            i+=3;
        }
        return metaExpression;
    }


}
