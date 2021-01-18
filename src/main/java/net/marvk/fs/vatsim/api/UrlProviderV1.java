package net.marvk.fs.vatsim.api;

public class UrlProviderV1 extends StringUrlProvider {
    public UrlProviderV1() {
        super(
                "http://cluster.data.vatsim.net/vatsim-data.txt",
                "http://cluster.data.vatsim.net/v3/vatsim-data.json",
                "http://cluster.data.vatsim.net/vatsim-servers.txt",
                "http://metar.vatsim.net/metar.php?id=%s",
                "https://api.vatsim.net/api/map_data/",
                "https://stats.vatsim.net/search_id.php?id=%s"
        );
    }
}
