package net.marvk.fs.vatsim.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class InputStreamDataSource extends StringDataSource {
    public InputStreamDataSource(final InputStream data, final InputStream servers, final InputStream metar, final InputStream firBoundaries, final InputStream vatSpy) throws IOException {
        super(loadFile(data), loadFile(servers), loadFile(metar), loadFile(firBoundaries), loadFile(vatSpy));
    }

    private static String loadFile(final InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
