package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.List;

@Data
public class VatsimAirspace {
    private final VatsimAirspaceGeneral general;
    private final List<Point> airspacePoints;
}
