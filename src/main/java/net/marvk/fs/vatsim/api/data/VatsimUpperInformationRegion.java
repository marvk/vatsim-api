package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.List;

@Data
public class VatsimUpperInformationRegion {
    private final String icao;
    private final String name;
    private final List<String> subordinateFlightInformationRegions;
}
