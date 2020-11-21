package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.List;

@Data
public class VatsimVatSpy {
    private final List<VatsimCountry> countries;
    private final List<VatsimAirport> airports;
    private final List<VatsimFlightInformationRegion> flightInformationRegions;
    private final List<VatsimUpperInformationRegion> upperInformationRegions;
    private final Line internationDateLine;
}
