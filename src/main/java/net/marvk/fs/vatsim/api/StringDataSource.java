package net.marvk.fs.vatsim.api;

public class StringDataSource implements DataSource {
    private final String data;
    private final String servers;
    private final String metar;

    public StringDataSource(final String data, final String servers, final String metar) {
        this.data = data;
        this.servers = servers;
        this.metar = metar;
    }

    @Override
    public String data() throws VatsimApiException {
        return data;
    }

    @Override
    public String servers() throws VatsimApiException {
        return servers;
    }

    @Override
    public String metar(final String airportIcao) throws VatsimApiException {
        return metar;
    }
}
