package net.marvk.fs.vatsim.api;

public class ExampleDataSource extends InputStreamDataSource {
    public ExampleDataSource() {
        super(
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-data.json"),
                ExampleDataSource.class.getResourceAsStream("example_data/vatsim-servers.txt"),
                ExampleDataSource.class.getResourceAsStream("example_data/metar"),
                ExampleDataSource.class.getResourceAsStream("example_data/FIRBoundaries.dat"),
                ExampleDataSource.class.getResourceAsStream("example_data/VATSpy.dat"),
                ExampleDataSource.class.getResourceAsStream("example_data/map_data.json")
        );
    }
}
