package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = {"ratingId"})
@Getter
@Setter
public class VatsimPilot extends VatsimClient {
    public VatsimPilot(final String cid, final String name, final String callsign, final ZonedDateTime lastUpdate, final String serverId, final VatsimServer server, final ZonedDateTime logon, final String latitude, final String longitude, final String altitude, final String groundSpeed, final String transponder, final String heading, final String qnhInchesMercury, final String qnhMillibars, final VatsimFlightPlan flightPlan, final String ratingId, final VatsimPilotRating rating) {
        super(cid, name, callsign, lastUpdate, serverId, server, logon);
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.groundSpeed = groundSpeed;
        this.transponder = transponder;
        this.heading = heading;
        this.qnhInchesMercury = qnhInchesMercury;
        this.qnhMillibars = qnhMillibars;
        this.flightPlan = flightPlan;
        this.ratingId = ratingId;
        this.rating = rating;
    }

    private final String latitude;

    private final String longitude;

    private final String altitude;

    @SerializedName("groundspeed")
    private final String groundSpeed;

    private final String transponder;

    private final String heading;

    @SerializedName("qnh_i_hg")
    private final String qnhInchesMercury;

    @SerializedName("qnh_mb")
    private final String qnhMillibars;

    @SerializedName("flight_plan")
    private final VatsimFlightPlan flightPlan;

    @Getter(AccessLevel.PACKAGE)
    @SerializedName("pilot_rating")
    private final String ratingId;

    @Setter(AccessLevel.PACKAGE)
    private transient VatsimPilotRating rating;

    @Override
    public VatsimClientType getClientType() {
        return VatsimClientType.PILOT;
    }
}
