package net.marvk.fs.vatsim.api;

public class StringUrlProvider implements VatsimApiUrlProvider {

    private final String status;
    private final String dataFallback;
    private final String transceiversFallback;
    private final String metar;
    private final String mapData;
    private final String stats;

    public StringUrlProvider(final String status, final String dataFallback, final String transceiversFallback, final String metar, final String mapData, final String stats) {
        this.status = status;
        this.dataFallback = dataFallback;
        this.transceiversFallback = transceiversFallback;
        this.metar = metar;
        this.mapData = mapData;
        this.stats = stats;
    }

    @Override
    public String status() {
        return status;
    }

    @Override
    public String dataFallback() {
        return dataFallback;
    }

    @Override
    public String transceiversFallback() {
        return transceiversFallback;
    }

    @Override
    public String metar(final String airportIcao) {
        return metar.formatted(airportIcao);
    }

    @Override
    public String mapData() {
        return mapData;
    }

    @Override
    public String stats(final String cid) {
        return stats.formatted(cid);
    }
}
