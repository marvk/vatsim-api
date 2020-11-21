package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VatsimVatspyDeserializer implements VatsimFormatDeserializer<VatsimVatSpy> {
    private final VatsimFormatDeserializer<VatsimCountry> vatsimCountyDeserializer;
    private final VatsimFormatDeserializer<VatsimAirport> vatsimAirportDeserializer;
    private final VatsimFormatDeserializer<VatsimFlightInformationRegion> vatsimFlightInformationRegionDeserializer;
    private final VatsimFormatDeserializer<VatsimUpperInformationRegion> vatsimUpperInformationRegionDeserializer;
    private final VatsimFormatDeserializer<Point> pointDeserializer;

    public VatsimVatspyDeserializer(
            final VatsimFormatDeserializer<VatsimCountry> vatsimCountyDeserializer,
            final VatsimFormatDeserializer<VatsimAirport> vatsimAirportDeserializer,
            final VatsimFormatDeserializer<VatsimFlightInformationRegion> vatsimFlightInformationRegionDeserializer,
            final VatsimFormatDeserializer<VatsimUpperInformationRegion> vatsimUpperInformationRegionDeserializer,
            final VatsimFormatDeserializer<Point> pointDeserializer
    ) {
        this.vatsimCountyDeserializer = vatsimCountyDeserializer;
        this.vatsimAirportDeserializer = vatsimAirportDeserializer;
        this.vatsimFlightInformationRegionDeserializer = vatsimFlightInformationRegionDeserializer;
        this.vatsimUpperInformationRegionDeserializer = vatsimUpperInformationRegionDeserializer;
        this.pointDeserializer = pointDeserializer;
    }

    public VatsimVatspyDeserializer() {
        this(
                new VatsimCountryDeserializer(),
                new VatsimAirportDeserializer(),
                new VatsimFlightInformationRegionDeserializer(),
                new VatsimUpperInformationRegionDeserializer(),
                new PointDeserializer()
        );
    }

    @Override
    public VatsimVatSpy deserialize(final String s) {
        final List<String> lines = s.lines()
                                    .filter(VatsimVatspyDeserializer::isNonEmptyLine)
                                    .collect(Collectors.toList());

        return new VatsimVatSpy(
                values(lines, "Countries", vatsimCountyDeserializer),
                values(lines, "Airports", vatsimAirportDeserializer),
                values(lines, "FIRs", vatsimFlightInformationRegionDeserializer),
                values(lines, "UIRs", vatsimUpperInformationRegionDeserializer),
                new Line(values(lines, "IDL", pointDeserializer))
        );
    }

    private static boolean isNonEmptyLine(final String line) {
        return !line.startsWith(";") && !line.isBlank();
    }

    private static <T> List<T> values(final List<String> lines, final String category, final VatsimFormatDeserializer<T> deserializer) {
        Integer startIndex = null;
        Integer endIndex = null;

        for (int i = 0; i < lines.size(); i++) {
            final String current = lines.get(i);

            if (current.startsWith("[")) {
                if (startIndex == null) {
                    if (current.equals("[" + category + "]")) {
                        startIndex = i + 1;
                    }
                } else {
                    endIndex = i;
                    break;
                }
            }
        }

        if (startIndex == null) {
            return Collections.emptyList();
        }

        if (endIndex == null) {
            endIndex = lines.size();
        }

        return lines.subList(startIndex, endIndex).stream().map(deserializer::deserialize).collect(Collectors.toList());
    }
}
