package src.main.java.com.nbcuni.news.taxonomy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * @author Les Hazlewood
 */
public final class RestError {

    private final HttpStatus status;
    private final int code;
    private final String message;
    private final String developerMessage;
    private final String moreInfoUrl;
    private final Throwable throwable;

    /**
     * 
     * @param status
     *            -
     * @param code
     *            -
     * @param message
     *            -
     * @param developerMessage
     *            -
     * @param moreInfoUrl
     *            -
     * @param throwable
     *            -
     */

    public RestError(HttpStatus status, int code, String message,
            String developerMessage, String moreInfoUrl, Throwable throwable) {
        if (status == null) {
            throw new NullPointerException(
                    "HttpStatus argument cannot be null.");
        }
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfoUrl = moreInfoUrl;
        this.throwable = throwable;
    }

    /**
     * 
     * @return -
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * 
     * @return -
     */
    public int getCode() {
        return code;
    }

    /**
     * 
     * @return -
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @return -
     */
    public String getDeveloperMessage() {
        return developerMessage;
    }

    /**
     * 
     * @return -
     */
    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    /**
     * 
     * @return -
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * 
     * @param o
     *            -
     * @return -
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof RestError) {
            RestError re = (RestError) o;
            return ObjectUtils.nullSafeEquals(getStatus(), re.getStatus())
                    && getCode() == re.getCode()
                    && ObjectUtils
                            .nullSafeEquals(getMessage(), re.getMessage())
                    && ObjectUtils.nullSafeEquals(getDeveloperMessage(),
                            re.getDeveloperMessage())
                    && ObjectUtils.nullSafeEquals(getMoreInfoUrl(),
                            re.getMoreInfoUrl())
                    && ObjectUtils.nullSafeEquals(getThrowable(),
                            re.getThrowable());
        }

        return false;
    }

    @Override
    public int hashCode() {
        // noinspection ThrowableResultOfMethodCallIgnored
        return ObjectUtils.nullSafeHashCode(new Object[] { getStatus(),
                getCode(), getMessage(), getDeveloperMessage(),
                getMoreInfoUrl(), getThrowable() });
    }

    /**
     * 
     * @return -
     */
    public String toString() {
        // noinspection StringBufferReplaceableByString
        return new StringBuilder().append(getStatus().value()).append(" (")
                .append(getStatus().getReasonPhrase()).append(" )").toString();
    }

    public final static class Builder {

        private HttpStatus status;
        private int code;
        private String message;
        private String developerMessage;
        private String moreInfoUrl;
        private Throwable throwable;

        /**
         * 
         */
        public Builder() {
        }

        /**
         * 
         * @param statusCode
         *            -
         * @return -
         */
        public Builder setStatus(int statusCode) {
            this.status = HttpStatus.valueOf(statusCode);
            return this;
        }

        /**
         * 
         * @param status
         *            -
         * @return -
         */
        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        /**
         * 
         * @param code
         *            -
         * @return -
         */
        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        /**
         * 
         * @param message
         *            -
         * @return -
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 
         * @param developerMessage
         *            -
         * @return -
         */
        public Builder setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        /**
         * 
         * @param moreInfoUrl
         *            -
         * @return -
         */

        public Builder setMoreInfoUrl(String moreInfoUrl) {
            this.moreInfoUrl = moreInfoUrl;
            return this;
        }

        /**
         * 
         * @param throwable
         *            -
         * @return -
         */
        public Builder setThrowable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        /**
         * 
         * @return -
         */
        public RestError build() {
            if (this.status == null) {
                this.status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return new RestError(this.status, this.code, this.message,
                    this.developerMessage, this.moreInfoUrl, this.throwable);
        }
    }
}