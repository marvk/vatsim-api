package net.marvk.fs.vatsim.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import net.marvk.fs.vatsim.api.data.VatsimMapData;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class HttpDataSource implements VatsimApiDataSource {
    private final VatsimApiUrlProvider urlProvider;
    private final CloseableHttpClient httpClient;

    private String dataUrl;

    public HttpDataSource() {
        this(new UrlProviderV3());
    }

    public HttpDataSource(final CloseableHttpClient httpClient) {
        this(new UrlProviderV3(), httpClient);
    }

    public HttpDataSource(final VatsimApiUrlProvider urlProvider) {
        this(urlProvider, HttpClients.createDefault());
    }

    public HttpDataSource(final VatsimApiUrlProvider urlProvider, final CloseableHttpClient httpClient) {
        this.urlProvider = urlProvider;
        this.httpClient = httpClient;
    }

    private String httpRequest(final String url) throws VatsimApiException {
        return httpRequest(RequestBuilder.get(url).build());
    }

    private String httpRequest(final HttpUriRequest request) throws VatsimApiException {
        try (final CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity());
            }
            throw new VatsimApiException(response.getStatusLine().getReasonPhrase());
        } catch (final ClientProtocolException e) {
            throw new VatsimApiException(e);
        } catch (final IOException e) {
            throw new VatsimApiException(e);
        }
    }

    @Override
    public String data() throws VatsimApiException {
        return httpRequest(dataUrl());
    }

    private String dataUrl() {
        if (dataUrl == null) {
            try {
                dataUrl = fetchDataUrl();
            } catch (final VatsimApiException e) {
                e.printStackTrace();
                dataUrl = urlProvider.dataFallback();
            }
        }

        return dataUrl;
    }

    private String fetchDataUrl() throws VatsimApiException {
        final String rawStatusJson = httpRequest(urlProvider.status());
        final JsonArray dataUrls = JsonParser
                .parseString(rawStatusJson)
                .getAsJsonObject()
                .getAsJsonObject("data")
                .getAsJsonArray("v3");

        return dataUrls
                .get(ThreadLocalRandom.current().nextInt(dataUrls.size()))
                .getAsString();
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

    @Override
    public String events() throws VatsimApiException {
        return httpRequest(urlProvider.events());
    }
}
