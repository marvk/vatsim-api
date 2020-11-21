package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimMapData {
    @Expose
    @SerializedName("current_commit_hash")
    private final String currentCommitHash;

    @Expose
    @SerializedName("fir_boundaries_dat_url")
    private final String firBoundariesDataUrl;

    @Expose
    @SerializedName("vatspy_dat_url")
    private final String vatSpyDataUrl;
}
