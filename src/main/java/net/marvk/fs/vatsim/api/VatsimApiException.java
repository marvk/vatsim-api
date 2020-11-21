package net.marvk.fs.vatsim.api;

public class VatsimApiException extends Exception {
    public VatsimApiException() {
    }

    public VatsimApiException(final String message) {
        super(message);
    }

    public VatsimApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public VatsimApiException(final Throwable cause) {
        super(cause);
    }

    public VatsimApiException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
