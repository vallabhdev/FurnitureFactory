package practice.exceptions;

public class MyUncheckedException extends RuntimeException {
//    List of some unchecked exceptions:
//    NullPointerException
//    ArrayIndexOutOfBound
//    IllegalArgumentException
//    IllegalStateException
//    Rest all exceptions which is not a child of RuntimeException is called Checked Exception.
//    and Checked Exception handling verified during compile time.
//    Unchecked Exception are mostly programming errors.

    public MyUncheckedException(String msg, Object obj) {
        super(msg + obj.getClass().toString());
    }
}
