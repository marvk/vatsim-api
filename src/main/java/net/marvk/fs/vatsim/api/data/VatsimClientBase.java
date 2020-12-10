package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class VatsimClientBase {
    private final String cid;

    private final String name;

    private final String callsign;

    @SerializedName("last_updated")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime lastUpdate;
}
