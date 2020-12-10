package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = {"facilityId", "ratingId"})
@Getter
@Setter
public class VatsimController extends VatsimClient {
    public VatsimController(final String cid, final String name, final String callsign, final ZonedDateTime lastUpdate, final String serverId, final VatsimServer server, final ZonedDateTime logon, final List<String> textAtis, final String frequency, final String facilityId, final VatsimFacility facility, final String ratingId, final VatsimControllerRating rating, final String visualRange) {
        super(cid, name, callsign, lastUpdate, serverId, server, logon);
        this.textAtis = textAtis;
        this.frequency = frequency;
        this.facilityId = facilityId;
        this.facility = facility;
        this.ratingId = ratingId;
        this.rating = rating;
        this.visualRange = visualRange;
    }

    @SerializedName("text_atis")
    private final List<String> textAtis;

    private final String frequency;

    @Getter(AccessLevel.PACKAGE)
    @SerializedName("facility")
    private final String facilityId;

    @Setter(AccessLevel.PACKAGE)
    private transient VatsimFacility facility;

    @Getter(AccessLevel.PACKAGE)
    @SerializedName("rating")
    private final String ratingId;

    @Setter(AccessLevel.PACKAGE)
    private transient VatsimControllerRating rating;

    @SerializedName("visual_range")
    private final String visualRange;

    @Override
    public VatsimClientType getClientType() {
        return VatsimClientType.CONTROLLER;
    }
}
