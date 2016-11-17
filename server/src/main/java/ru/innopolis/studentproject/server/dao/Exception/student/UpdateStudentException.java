package ru.innopolis.studentproject.server.dao.Exception.student;

/**
 * Created by User on 05.11.2016.
 */
public class UpdateStudentException extends Exception {
    public UpdateStudentException() {
    }

    public UpdateStudentException(String message) {
        super(message);
    }

    public UpdateStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateStudentException(Throwable cause) {
        super(cause);
    }

    public UpdateStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
