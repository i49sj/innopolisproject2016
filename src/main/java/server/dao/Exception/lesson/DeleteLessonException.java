package server.dao.Exception.lesson;

/**
 * Created by User on 05.11.2016.
 */
public class DeleteLessonException extends Exception{
    public DeleteLessonException() {
    }

    public DeleteLessonException(String message) {
        super(message);
    }

    public DeleteLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteLessonException(Throwable cause) {
        super(cause);
    }

    public DeleteLessonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
