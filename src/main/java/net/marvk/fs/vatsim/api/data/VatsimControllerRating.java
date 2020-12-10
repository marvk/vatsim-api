package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimControllerRating {
    private final String id;

    @SerializedName("short")
    private final String shortName;

    @SerializedName("long")
    private final String longName;
}
