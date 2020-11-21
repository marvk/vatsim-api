package net.marvk.fs.vatsim.api;

public class UrlProviderV1 extends StringUrlProvider {
    public UrlProviderV1() {
        super(
                "http://cluster.data.vatsim.net/vatsim-data.txt",
                "http://cluster.data.vatsim.net/vatsim-data.json",
                "http://cluster.data.vatsim.net/vatsim-servers.txt",
                "http://stats.vatsim.net/search_id.php?id=%s"
        );
    }
}
