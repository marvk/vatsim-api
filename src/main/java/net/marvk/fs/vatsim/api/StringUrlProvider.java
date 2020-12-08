package net.marvk.fs.vatsim.api;

public class StringUrlProvider implements VatsimApiUrlProvider {
    private final String vatsimDataText;
    private final String vatsimDataJson;
    private final String vatsimServers;
    private final String metar;
    private final String mapData;
    private final String stats;

    public StringUrlProvider(final String vatsimDataText, final String vatsimDataJson, final String vatsimServers, final String metar, final String mapData, final String stats) {
        this.vatsimDataText = vatsimDataText;
        this.vatsimDataJson = vatsimDataJson;
        this.vatsimServers = vatsimServers;
        this.metar = metar;
        this.mapData = mapData;
        this.stats = stats;
    }

    @Override
    public String vatsimDataText() {
        return vatsimDataText;
    }

    @Override
    public String vatsimDataJson() {
        return vatsimDataJson;
    }

    @Override
    public String vatsimServers() {
        return vatsimServers;
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
