package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class VatsimPrefile extends VatsimClientBase {
    public VatsimPrefile(final String cid, final String name, final String callsign, final ZonedDateTime lastUpdate, final VatsimFlightPlan flightPlan) {
        super(cid, name, callsign, lastUpdate);
        this.flightPlan = flightPlan;
    }

    @SerializedName("flight_plan")
    private final VatsimFlightPlan flightPlan;
}
