package server.dao.Exception.lesson;

/**
 * Created by User on 05.11.2016.
 */
public class UpdateLessonException extends Exception{
    public UpdateLessonException() {
    }

    public UpdateLessonException(String message) {
        super(message);
    }

    public UpdateLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateLessonException(Throwable cause) {
        super(cause);
    }

    public UpdateLessonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
