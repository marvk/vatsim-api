package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.Point;
import net.marvk.fs.vatsim.api.data.VatsimAirspaceGeneral;

public class VatsimAirspaceGeneralDeserializer implements VatsimFormatDeserializer<VatsimAirspaceGeneral> {
    private final VatsimFormatDeserializer<Point> pointDeserializer;

    public VatsimAirspaceGeneralDeserializer(final VatsimFormatDeserializer<Point> pointDeserializer) {
        this.pointDeserializer = pointDeserializer;
    }

    @Override
    public VatsimAirspaceGeneral deserialize(final String s) {
        final String[] split = s.split("\\|");

        return new VatsimAirspaceGeneral(
                split[0],
                !"0".equals(split[1]),
                !"0".equals(split[2]),
                Integer.parseInt(split[3]),
                pointDeserializer.deserialize(split[4] + "|" + split[5]),
                pointDeserializer.deserialize(split[4] + "|" + split[5]),
                pointDeserializer.deserialize(split[4] + "|" + split[5])
        );
    }
}
