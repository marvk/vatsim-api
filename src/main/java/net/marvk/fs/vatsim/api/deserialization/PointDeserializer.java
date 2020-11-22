package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.Point;

public class PointDeserializer implements VatsimFormatDeserializer<Point> {
    @Override
    public Point deserialize(final String s) {
        final String[] split = s.split("\\|");
        return new Point(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }
}
