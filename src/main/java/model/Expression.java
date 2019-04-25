package model;

import enums.Operators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expression {
    String key;
    Operators operator;
    String value;
}
