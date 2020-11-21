package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.Point;
import net.marvk.fs.vatsim.api.data.VatsimAirspace;
import net.marvk.fs.vatsim.api.data.VatsimAirspaceGeneral;
import net.marvk.fs.vatsim.api.data.VatsimFirBoundaries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VatsimFirBoundariesDeserializer implements VatsimFormatDeserializer<VatsimFirBoundaries> {
    private final VatsimFormatDeserializer<VatsimAirspaceGeneral> vatsimAirspaceGeneralDeserializer;
    private final VatsimFormatDeserializer<Point> pointDeserializer;

    public VatsimFirBoundariesDeserializer(final VatsimFormatDeserializer<VatsimAirspaceGeneral> vatsimAirspaceGeneralDeserializer, final VatsimFormatDeserializer<Point> pointDeserializer) {
        this.vatsimAirspaceGeneralDeserializer = vatsimAirspaceGeneralDeserializer;
        this.pointDeserializer = pointDeserializer;
    }

    public VatsimFirBoundariesDeserializer() {
        this(new VatsimAirspaceGeneralDeserializer(new PointDeserializer()), new PointDeserializer());
    }

    @Override
    public VatsimFirBoundaries deserialize(final String s) {
        final List<String> lines = s.lines().collect(Collectors.toList());

        final ArrayList<VatsimAirspace> result = new ArrayList<>();

        for (int i = 0; i < lines.size(); ) {
            final String header = lines.get(i);
            i += 1;
            final VatsimAirspaceGeneral vatsimAirspaceGeneral = vatsimAirspaceGeneralDeserializer.deserialize(header);

            final List<Point> points = lines.subList(i, i + vatsimAirspaceGeneral.getPointCount()).stream()
                                            .map(pointDeserializer::deserialize)
                                            .collect(Collectors.toList());

            result.add(new VatsimAirspace(vatsimAirspaceGeneral, points));

            i += vatsimAirspaceGeneral.getPointCount();
        }

        return new VatsimFirBoundaries(result);
    }
}
