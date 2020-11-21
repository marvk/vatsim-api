package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.VatsimCountry;

public class VatsimCountryDeserializer implements VatsimFormatDeserializer<VatsimCountry> {
    @Override
    public VatsimCountry deserialize(final String s) {
        final String[] split = s.split("\\|", -1);

        return new VatsimCountry(split[0], split[1], split[2]);
    }
}
