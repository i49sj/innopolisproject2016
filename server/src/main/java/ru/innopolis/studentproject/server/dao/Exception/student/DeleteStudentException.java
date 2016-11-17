package ru.innopolis.studentproject.server.dao.Exception.student;

/**
 * Created by User on 05.11.2016.
 */
public class DeleteStudentException extends Exception {
    public DeleteStudentException() {
    }

    public DeleteStudentException(String message) {
        super(message);
    }

    public DeleteStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteStudentException(Throwable cause) {
        super(cause);
    }

    public DeleteStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
