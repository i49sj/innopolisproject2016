package server.dao.Exception.student;

/**
 * Created by User on 05.11.2016.
 */
public class AddStudentException extends Exception {
    public AddStudentException() {
    }

    public AddStudentException(String message) {
        super(message);
    }

    public AddStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddStudentException(Throwable cause) {
        super(cause);
    }

    public AddStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
