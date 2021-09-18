package net.marvk.fs.vatsim.api;

import net.marvk.fs.vatsim.api.data.*;

public interface VatsimApi {
    VatsimData data() throws VatsimApiException;

    VatsimMetar metar(String airportIcao) throws VatsimApiException;

    VatsimFirBoundaries firBoundaries() throws VatsimApiException;

    VatsimVatSpy vatSpy() throws VatsimApiException;

    VatsimEvents events() throws VatsimApiException;
}
