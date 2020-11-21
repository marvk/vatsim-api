package net.marvk.fs.vatsim.api;

import java.io.Serial;

public class VatsimApiException extends Exception {
    @Serial
    private static final long serialVersionUID = 5331196155812379396L;

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
