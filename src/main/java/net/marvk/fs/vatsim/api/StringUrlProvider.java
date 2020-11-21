package net.marvk.fs.vatsim.api;

public class StringUrlProvider implements UrlProvider {
    private final String vatsimDataText;
    private final String vatsimDataJson;
    private final String vatsimServers;
    private final String metar;

    public StringUrlProvider(final String vatsimDataText, final String vatsimDataJson, final String vatsimServers, final String metar) {
        this.vatsimDataText = vatsimDataText;
        this.vatsimDataJson = vatsimDataJson;
        this.vatsimServers = vatsimServers;
        this.metar = metar;
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
        return String.format(metar, airportIcao);
    }
}
