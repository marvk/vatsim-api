package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.Iterator;
import java.util.List;

@Data
public class VatsimFirBoundaries implements Iterable<VatsimAirspace> {
    private final List<VatsimAirspace> airspaces;

    @Override
    public Iterator<VatsimAirspace> iterator() {
        return airspaces.iterator();
    }
}
