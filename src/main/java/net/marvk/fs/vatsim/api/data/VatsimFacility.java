package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimFacility {
    private final String id;

    @SerializedName("short")
    private final String shortName;

    @SerializedName("long")
    private final String longName;
}
