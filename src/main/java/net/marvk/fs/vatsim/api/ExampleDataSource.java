package net.marvk.fs.vatsim.api;

import java.io.IOException;

public class ExampleDataSource extends InputStreamDataSource {
    public ExampleDataSource() throws IOException {
        super(
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-data.json"),
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-servers.txt"),
                ExampleDataSource.class.getResourceAsStream("example_data/metar"),
                ExampleDataSource.class.getResourceAsStream("example_data/FIRBoundaries.dat"),
                ExampleDataSource.class.getResourceAsStream("example_data/VATSpy.dat")
        );
    }
}
