package model;

import enums.MetaExpressionOperator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaExpression {
    private Expression expression;
    private MetaExpression metaExpression1;
    private MetaExpression metaExpression2;
    private MetaExpressionOperator operator;
    private boolean isExpression;

    public boolean isExpression() {
        return isExpression;
    }

}
