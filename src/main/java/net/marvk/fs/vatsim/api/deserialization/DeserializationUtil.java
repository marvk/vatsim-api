package net.marvk.fs.vatsim.api.deserialization;

import java.util.regex.Pattern;

final class DeserializationUtil {
    private static final Pattern COMMENT = Pattern.compile("\\s*;.*$");

    private DeserializationUtil() {
        throw new AssertionError("No instances of utility class " + DeserializationUtil.class);
    }

    public static boolean isTrue(final String s) {
        return s != null && !s.isBlank() && !"0".equals(s);
    }

    public static String nullIfBlank(final String s) {
        return s.isBlank() ? null : s;
    }

    public static String[] split(final String input) {
        return COMMENT.matcher(input).replaceAll("").split("\\|", -1);
    }
}
