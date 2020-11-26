package net.marvk.fs.vatsim.api.deserialization;

final class DeserializationUtil {
    private DeserializationUtil() {
        throw new AssertionError("No instances of utility class " + DeserializationUtil.class);
    }

    public static boolean isTrue(final String s) {
        return s != null && !s.isBlank() && !"0".equals(s);
    }

    public static String nullIfBlank(final String s) {
        return s.isBlank() ? null : s;
    }
}
