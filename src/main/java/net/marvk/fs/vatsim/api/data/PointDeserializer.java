package net.marvk.fs.vatsim.api.data;

public class PointDeserializer implements VatsimFormatDeserializer<Point> {
    @Override
    public Point deserialize(final String s) {
        final String[] split = DeserializationUtil.split(s);
        return new Point(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }
}
