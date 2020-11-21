package net.marvk.fs.vatsim.api;

public interface VatsimApiDataSource {
    String data() throws VatsimApiException;

    String servers() throws VatsimApiException;

    String metar(final String airportIcao) throws VatsimApiException;

    String firBoundaries() throws VatsimApiException;

    String vatSpy() throws VatsimApiException;

    String mapData() throws VatsimApiException;
}
