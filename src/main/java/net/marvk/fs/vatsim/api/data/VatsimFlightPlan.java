package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimFlightPlan {
    @SerializedName("flight_rules")
    private final String flightRules;

    private final String aircraft;

    @SerializedName("departure")
    private final String departureAirport;

    @SerializedName("arrival")
    private final String arrivalAirport;

    @SerializedName("alternate")
    private final String alternateAirport;

    @SerializedName("cruise_tas")
    private final String cruiseTas;

    private final String altitude;

    @SerializedName("deptime")
    private final String departureTime;

    @SerializedName("enroute_time")
    private final String enrouteTime;

    @SerializedName("fuel_time")
    private final String fuelTime;

    private final String route;

    private final String remarks;
}
