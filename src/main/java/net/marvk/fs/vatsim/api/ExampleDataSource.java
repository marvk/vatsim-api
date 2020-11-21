package net.marvk.fs.vatsim.api;

import java.io.IOException;
import java.net.URISyntaxException;

public class ExampleDataSource extends FileDataSource {
    public ExampleDataSource() throws IOException {
        super(
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-data.json"),
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-servers.txt"),
                ExampleDataSource.class.getResourceAsStream("example_data/metar")
        );
    }
}
