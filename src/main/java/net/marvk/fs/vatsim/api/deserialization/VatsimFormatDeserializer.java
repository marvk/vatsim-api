package net.marvk.fs.vatsim.api.deserialization;

public interface VatsimFormatDeserializer<E> {
    E deserialize(final String s);
}
