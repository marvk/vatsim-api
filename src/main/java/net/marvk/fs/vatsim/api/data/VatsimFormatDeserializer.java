package net.marvk.fs.vatsim.api.data;

public interface VatsimFormatDeserializer<E> {
    E deserialize(final String s);
}
