package ru.innopolis.studentproject.server.dao.Exception.lesson;

/**
 * Created by User on 05.11.2016.
 */
public class GetLessonException extends Exception{
    public GetLessonException() {
    }

    public GetLessonException(String message) {
        super(message);
    }

    public GetLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetLessonException(Throwable cause) {
        super(cause);
    }

    public GetLessonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
