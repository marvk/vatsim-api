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
        return new GsonBuilder()
                .registerTypeAdapter(VatsimData.class, new VatsimDataDeserializer())
                .registerTypeAdapter(VatsimEvents.class, new VatsimEventsDeserializer())
                .create();
    }

    @Override
    public VatsimData data() throws VatsimApiException {
        return gson().fromJson(new StringReader(dataSource.data()), VatsimData.class);
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

    @Override
    public VatsimEvents events() throws VatsimApiException {
        return gson().fromJson(new StringReader(dataSource.events()), VatsimEvents.class);
    }

    @Override
    public VatsimMapData mapData() throws VatsimApiException {
        return gson().fromJson(new StringReader(dataSource.mapData()), VatsimMapData.class);
    }

    @SneakyThrows
    public static void main(final String[] args) {
        final VatsimApiDataSource dataSource = new ExampleDataSource();
        final VatsimApi vatsimApi = new SimpleVatsimApi(dataSource);

        final VatsimEvents data = vatsimApi.events();

        System.out.println(data);
    }
}
