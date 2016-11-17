package ru.innopolis.studentproject.server.dao.Exception.student;

/**
 * Created by User on 05.11.2016.
 */
public class GetStudentException extends Exception {
    public GetStudentException() {
    }

    public GetStudentException(String message) {
        super(message);
    }

    public GetStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetStudentException(Throwable cause) {
        super(cause);
    }

    public GetStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
