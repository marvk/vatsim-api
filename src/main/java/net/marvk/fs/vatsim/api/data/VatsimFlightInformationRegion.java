package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class VatsimFlightInformationRegion {
    private final String icao;
    private final String name;
    private final String prefixPosition;
    private final String unknown1;
}
