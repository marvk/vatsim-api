package net.marvk.fs.vatsim.api;

public class UrlProviderV3 extends StringUrlProvider {
    public UrlProviderV3() {
        super(
                "https://status.vatsim.net/status.json",
                "https://data.vatsim.net/v3/vatsim-data.json",
                "https://data.vatsim.net/v3/transceivers-data.json",
                "https://metar.vatsim.net/metar.php?id=%s",
                "https://api.vatsim.net/api/map_data/",
                "https://stats.vatsim.net/search_id.php?id=%s"
        );
    }
}
