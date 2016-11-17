package ru.innopolis.studentproject.server.dao.Exception.lesson;

/**
 * Created by User on 05.11.2016.
 */
public class AddLessonException extends Exception
{
    public AddLessonException() {
    }

    public AddLessonException(String message) {
        super(message);
    }

    public AddLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddLessonException(Throwable cause) {
        super(cause);
    }

    public AddLessonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
