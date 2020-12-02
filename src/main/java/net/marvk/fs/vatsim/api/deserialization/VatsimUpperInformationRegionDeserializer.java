package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.VatsimUpperInformationRegion;

import java.util.Arrays;

public class VatsimUpperInformationRegionDeserializer implements VatsimFormatDeserializer<VatsimUpperInformationRegion> {
    @Override
    public VatsimUpperInformationRegion deserialize(final String s) {
        final String[] split = DeserializationUtil.split(s);

        return new VatsimUpperInformationRegion(
                split[0],
                split[1],
                Arrays.asList(split[2].split(","))
        );
    }
}
