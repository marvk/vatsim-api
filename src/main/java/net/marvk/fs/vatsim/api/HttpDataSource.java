package net.marvk.fs.vatsim.api;

import com.google.gson.Gson;
import net.marvk.fs.vatsim.api.data.VatsimMapData;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpDataSource implements VatsimApiDataSource {
    private final VatsimApiUrlProvider urlProvider;
    private final CloseableHttpClient httpClient;

    public HttpDataSource() {
        this(new UrlProviderV1());
    }

    public HttpDataSource(final VatsimApiUrlProvider urlProvider) {
        this.urlProvider = urlProvider;

        this.httpClient = HttpClients.createDefault();
    }

    private String httpRequest(final String url) throws VatsimApiException {
        return httpRequest(RequestBuilder.get(url).build());
    }

    private String httpRequest(final HttpUriRequest request) throws VatsimApiException {
        try (final CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity());
            }
            throw new VatsimApiException();
        } catch (final IOException e) {
            throw new VatsimApiException(e);
        }
    }

    @Override
    public String data() throws VatsimApiException {
        return httpRequest(urlProvider.vatsimDataJson());
    }

    @Override
    public String servers() throws VatsimApiException {
        return httpRequest(urlProvider.vatsimServers());
    }

    @Override
    public String metar(final String airportIcao) throws VatsimApiException {
        return httpRequest(urlProvider.metar(airportIcao));
    }

    @Override
    public String firBoundaries() throws VatsimApiException {
        return httpRequest(parsedMapData().getFirBoundariesDataUrl());
    }

    @Override
    public String vatSpy() throws VatsimApiException {
        return httpRequest(parsedMapData().getVatSpyDataUrl());
    }

    private VatsimMapData parsedMapData() throws VatsimApiException {
        return new Gson().fromJson(mapData(), VatsimMapData.class);
    }

    @Override
    public String mapData() throws VatsimApiException {
        return httpRequest(urlProvider.mapData());
    }
}
