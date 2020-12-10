package net.marvk.fs.vatsim.api.data;

public class VatsimFlightInformationRegionDeserializer implements VatsimFormatDeserializer<VatsimFlightInformationRegion> {
    @Override
    public VatsimFlightInformationRegion deserialize(final String s) {
        final String[] split = DeserializationUtil.split(s);

        return new VatsimFlightInformationRegion(
                split[0],
                split[1],
                split[2],
                split[3]
        );
    }
}
