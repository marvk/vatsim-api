package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class VatsimMetar {
    private final String airport;
    private final String metar;
}
