package ru.innopolis.studentproject.server.dao.Exception.student;

/**
 * Created by User on 05.11.2016.
 */
public class GetStudentListException extends Exception {
    public GetStudentListException() {
    }

    public GetStudentListException(String message) {
        super(message);
    }

    public GetStudentListException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetStudentListException(Throwable cause) {
        super(cause);
    }

    public GetStudentListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
