package net.marvk.fs.vatsim.api.data;

public class VatsimCountryDeserializer implements VatsimFormatDeserializer<VatsimCountry> {
    @Override
    public VatsimCountry deserialize(final String s) {
        final String[] split = DeserializationUtil.split(s);

        return new VatsimCountry(split[0], split[1], split[2]);
    }
}
