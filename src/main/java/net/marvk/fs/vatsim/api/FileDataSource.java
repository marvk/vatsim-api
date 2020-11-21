package net.marvk.fs.vatsim.api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class FileDataSource extends StringDataSource {
    public FileDataSource(final File data, final File servers, final File metar) throws IOException {
        super(loadFile(data), loadFile(servers), loadFile(metar));
    }

    public FileDataSource(final InputStream data, final InputStream servers, final InputStream metar) throws IOException {
        super(loadFile(data), loadFile(servers), loadFile(metar));
    }

    private static String loadFile(final File file) throws IOException {
        return Files.readString(file.toPath());
    }

    private static String loadFile(final InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                                                                                             .collect(Collectors.joining("\n"));
    }
}
