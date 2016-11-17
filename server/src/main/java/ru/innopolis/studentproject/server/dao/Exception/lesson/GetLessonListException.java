package ru.innopolis.studentproject.server.dao.Exception.lesson;

/**
 * Created by User on 05.11.2016.
 */
public class GetLessonListException extends Exception{
    public GetLessonListException() {
    }

    public GetLessonListException(String message) {
        super(message);
    }

    public GetLessonListException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetLessonListException(Throwable cause) {
        super(cause);
    }

    public GetLessonListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
