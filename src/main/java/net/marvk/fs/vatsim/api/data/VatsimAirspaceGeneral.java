package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class VatsimAirspaceGeneral {
    private final String icao;
    private final Boolean oceanic;
    private final Boolean extension;
    private final Integer pointCount;
    private final Point minPosition;
    private final Point maxPosition;
    private final Point centerPosition;
}
