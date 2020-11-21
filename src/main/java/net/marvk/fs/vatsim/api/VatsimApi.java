package net.marvk.fs.vatsim.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import net.marvk.fs.vatsim.api.data.VatsimData;
import net.marvk.fs.vatsim.api.data.VatsimMetar;

import java.io.StringReader;

public class VatsimApi {
    private final DataSource dataSource;

    public VatsimApi(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static Gson gson() {
        return new GsonBuilder().create();
    }

    public VatsimData data() throws VatsimApiException {
        return gson().fromJson(new StringReader(dataSource.data()), VatsimData.class);
    }

    public VatsimMetar metar(final String airportIcao) throws VatsimApiException {
        final String metar = dataSource.metar(airportIcao);

        return new VatsimMetar(airportIcao, metar);
    }

    @SneakyThrows
    public static void main(final String[] args) {
        final VatsimApi vatsimApi = new VatsimApi(new ExampleDataSource());

        vatsimApi.data();
    }
}
