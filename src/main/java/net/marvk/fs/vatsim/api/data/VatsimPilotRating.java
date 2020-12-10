package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimPilotRating {
    private final String id;

    @SerializedName("short_name")
    private final String shortName;

    @SerializedName("long_name")
    private final String longName;
}
