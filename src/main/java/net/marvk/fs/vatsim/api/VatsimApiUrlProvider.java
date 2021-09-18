package net.marvk.fs.vatsim.api;

public interface VatsimApiUrlProvider {
    String status();

    String dataFallback();

    String transceiversFallback();

    String metar(final String airportIcao);

    String mapData();

    String stats(final String cid);

    String events();
}
