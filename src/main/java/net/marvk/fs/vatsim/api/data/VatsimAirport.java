package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class VatsimAirport {
    private final String icao;
    private final String name;
    private final Point position;
    private final String iataLid;
    private final String flightInformationRegion;
    private final Boolean pseudo;
}
