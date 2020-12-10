package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class VatsimAtis extends VatsimController {
    public VatsimAtis(final String cid, final String name, final String callsign, final ZonedDateTime lastUpdate, final String serverId, final VatsimServer server, final ZonedDateTime logon, final List<String> textAtis, final String frequency, final String facilityId, final VatsimFacility facility, final String ratingId, final VatsimControllerRating rating, final String visualRange, final String atisCode) {
        super(cid, name, callsign, lastUpdate, serverId, server, logon, textAtis, frequency, facilityId, facility, ratingId, rating, visualRange);
        this.atisCode = atisCode;
    }

    @SerializedName("atis_code")
    private final String atisCode;

    @Override
    public VatsimClientType getClientType() {
        return VatsimClientType.ATIS;
    }
}
