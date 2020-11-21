package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.Point;
import net.marvk.fs.vatsim.api.data.VatsimAirport;

public class VatsimAirportDeserializer implements VatsimFormatDeserializer<VatsimAirport> {
    private final VatsimFormatDeserializer<Point> pointDeserializer;

    public VatsimAirportDeserializer(final VatsimFormatDeserializer<Point> pointDeserializer) {
        this.pointDeserializer = pointDeserializer;
    }

    public VatsimAirportDeserializer() {
        this(new PointDeserializer());
    }

    @Override
    public VatsimAirport deserialize(final String s) {
        final String[] split = s.split("\\|", -1);

        return new VatsimAirport(
                split[0],
                split[1],
                pointDeserializer.deserialize(split[2] + "|" + split[3]),
                split[4],
                split[5],
                DeserializationUtil.isTrue(split[6])
        );
    }
}
