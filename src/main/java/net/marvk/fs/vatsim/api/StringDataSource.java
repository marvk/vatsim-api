package net.marvk.fs.vatsim.api;

public class StringDataSource implements VatsimApiDataSource {
    private final String data;
    private final String metar;
    private final String firBoundaries;
    private final String vatSpy;
    private final String mapData;
    private final String events;

    public StringDataSource(final String data, final String metar, final String firBoundaries, final String vatSpy, final String mapData, final String events) {
        this.data = data;
        this.metar = metar;
        this.firBoundaries = firBoundaries;
        this.vatSpy = vatSpy;
        this.mapData = mapData;
        this.events = events;
    }

    @Override
    public String data() throws VatsimApiException {
        return data;
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
    public String vatSpy() throws VatsimApiException {
        return vatSpy;
    }

    @Override
    public String mapData() throws VatsimApiException {
        return mapData;
    }

    @Override
    public String events() throws VatsimApiException {
        return events;
    }
}
