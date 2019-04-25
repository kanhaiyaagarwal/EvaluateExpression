package requests;

import java.util.HashMap;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    //PAIR HAS DATA and DATATYPE
    HashMap<String, Pair<String, String>> userAttribues;
}
