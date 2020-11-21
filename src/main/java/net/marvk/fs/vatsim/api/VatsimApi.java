package net.marvk.fs.vatsim.api;

import net.marvk.fs.vatsim.api.data.VatsimData;
import net.marvk.fs.vatsim.api.data.VatsimFirBoundaries;
import net.marvk.fs.vatsim.api.data.VatsimMetar;
import net.marvk.fs.vatsim.api.data.VatsimVatSpy;

public interface VatsimApi {
    VatsimData data() throws VatsimApiException;

    VatsimData servers();

    VatsimMetar metar(String airportIcao) throws VatsimApiException;

    VatsimFirBoundaries firBoundaries() throws VatsimApiException;

    VatsimVatSpy vatSpy() throws VatsimApiException;
}
