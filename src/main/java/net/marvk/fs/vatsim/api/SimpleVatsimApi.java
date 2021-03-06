package net.marvk.fs.vatsim.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import net.marvk.fs.vatsim.api.data.*;

import java.io.StringReader;

public class SimpleVatsimApi implements VatsimApi {
    private final VatsimApiDataSource dataSource;

    public SimpleVatsimApi(final VatsimApiDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static Gson gson() {
        return new GsonBuilder().registerTypeAdapter(VatsimData.class, new VatsimDataDeserializer()).create();
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
        return new VatsimVatspyDeserializer().deserialize(dataSource.vatSpy());
    }

    @SneakyThrows
    public static void main(final String[] args) {
        final VatsimApiDataSource dataSource = new ExampleDataSource();
        final VatsimApi vatsimApi = new SimpleVatsimApi(dataSource);

        final VatsimData data = vatsimApi.data();

        System.out.println(data);
    }

}
