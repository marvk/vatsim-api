package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimMapData {

    @SerializedName("current_commit_hash")
    private final String currentCommitHash;

    @SerializedName("fir_boundaries_dat_url")
    private final String firBoundariesDataUrl;

    @SerializedName("vatspy_dat_url")
    private final String vatSpyDataUrl;
}
