package net.marvk.fs.vatsim.api;

public class StringDataSource implements DataSource {
    private final String data;
    private final String servers;
    private final String metar;
    private final String firBoundaries;
    private final String vatSpy;

    public StringDataSource(final String data, final String servers, final String metar, final String firBoundaries, final String vatSpy) {
        this.data = data;
        this.servers = servers;
        this.metar = metar;
        this.firBoundaries = firBoundaries;
        this.vatSpy = vatSpy;
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

    @Override
    public String firBoundaries() throws VatsimApiException {
        return firBoundaries;
    }

    @Override
    public String vatSpy(final String airportIcao) throws VatsimApiException {
        return vatSpy;
    }
}
