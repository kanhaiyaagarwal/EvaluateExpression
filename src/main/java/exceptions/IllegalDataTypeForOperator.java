package exceptions;

public class IllegalDataTypeForOperator extends Exception {

    String message;
    public IllegalDataTypeForOperator(String  message) {
        this.message = message;
    }
}
