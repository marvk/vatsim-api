package net.marvk.fs.vatsim.api.deserialization;

import net.marvk.fs.vatsim.api.data.VatsimFlightInformationRegion;

public class VatsimFlightInformationRegionDeserializer implements VatsimFormatDeserializer<VatsimFlightInformationRegion> {
    @Override
    public VatsimFlightInformationRegion deserialize(final String s) {
        final String[] split = s.split("\\|",-1);

        return new VatsimFlightInformationRegion(
                split[0],
                split[1],
                split[2],
                split[3]
        );
    }
}
