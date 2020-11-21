package net.marvk.fs.vatsim.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import net.marvk.fs.vatsim.api.data.VatsimData;
import net.marvk.fs.vatsim.api.data.VatsimFirBoundaries;
import net.marvk.fs.vatsim.api.data.VatsimMetar;
import net.marvk.fs.vatsim.api.data.VatsimVatSpy;
import net.marvk.fs.vatsim.api.deserialization.VatsimFirBoundariesDeserializer;

import java.io.StringReader;

public class SimpleVatsimApi implements VatsimApi {
    private final DataSource dataSource;

    public SimpleVatsimApi(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static Gson gson() {
        return new GsonBuilder().create();
    }

    @Override
    public VatsimData data() throws VatsimApiException {
        return gson().fromJson(new StringReader(dataSource.data()), VatsimData.class);
    }

    @Override
    public VatsimData servers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public VatsimMetar metar(final String airportIcao) throws VatsimApiException {
        final String metar = dataSource.metar(airportIcao);

        return new VatsimMetar(airportIcao, metar);
    }

    @Override
    public VatsimFirBoundaries firBoundaries() throws VatsimApiException {
        return new VatsimFirBoundariesDeserializer().deserialize(dataSource.firBoundaries());
    }

    @Override
    public VatsimVatSpy vatSpy() throws VatsimApiException {
        throw new UnsupportedOperationException();
    }

    @SneakyThrows
    public static void main(final String[] args) {
        final ExampleDataSource dataSource = new ExampleDataSource();
        final VatsimApi vatsimApi = new SimpleVatsimApi(dataSource);

    }

}
