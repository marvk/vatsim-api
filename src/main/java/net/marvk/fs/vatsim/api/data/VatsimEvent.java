package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class VatsimEvent {
    private final Integer id;
    private final String type;
    private final String vsoName;
    private final String name;
    @SerializedName("organisers")
    private final List<Organizer> organizers;
    private final List<Airport> airports;
    private final List<Route> routes;
    @SerializedName("start_time")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime startTime;
    @SerializedName("end_time")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime endTime;
    @SerializedName("short_description")
    private final String shortDescription;
    private final String description;
    private final String banner;

    @Data
    public static class Organizer {
        private final String region;
        private final String division;
        private final String subdivision;
        @SerializedName("organized_by_vatsim")
        private final boolean organizedByVatsim;
    }

    @Data
    public static class Airport {
        private final String icao;
    }

    @Data
    public static class Route {
        private final String departure;
        private final String arrival;
        private final String route;
    }
}
