package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class VatsimCountry {
    private final String name;
    private final String shorthand;
    private final String discriminator;
}
