package src.main.java.com.nbcuni.news.taxonomy.exception;

/**
 * Simulated business-logic exception indicating a desired business entity or
 * record cannot be found.
 */
public class UnknownResourceException extends RuntimeException {

    /**
     * 
     * @param msg
     *            Exception message
     */
    public UnknownResourceException(String msg) {
        super(msg);
    }
}