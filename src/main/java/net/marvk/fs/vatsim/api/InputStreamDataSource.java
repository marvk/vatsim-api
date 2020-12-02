package net.marvk.fs.vatsim.api;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class InputStreamDataSource extends StringDataSource {
    public InputStreamDataSource(final InputStream data, final InputStream servers, final InputStream metar, final InputStream firBoundaries, final InputStream vatSpy, final InputStream mapData) {
        super(loadFile(data), loadFile(servers), loadFile(metar), loadFile(firBoundaries), loadFile(vatSpy), loadFile(mapData));
    }

    @SneakyThrows
    private static String loadFile(final InputStream inputStream) {
        try (final var br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }
}
