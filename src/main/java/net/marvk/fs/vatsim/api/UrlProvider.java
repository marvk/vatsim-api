package net.marvk.fs.vatsim.api;

public interface UrlProvider {
    String vatsimDataText();

    String vatsimDataJson();

    String vatsimServers();

    default String vatsimServersLive() {
        return vatsimServers();
    }

    String metar(final String airportIcao);

    String mapData();
}
