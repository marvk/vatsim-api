package net.marvk.fs.vatsim.api;

public interface DataSource {
    String data() throws VatsimApiException;

    String servers() throws VatsimApiException;

    String metar(final String airportIcao) throws VatsimApiException;

    String firBoundaries() throws VatsimApiException;

    String vatSpy(String airportIcao) throws VatsimApiException;
}
